package ru.sberbank.school.ExecutionManager;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;


public class FixedThreadPoolWithContext implements ThreadPoolWithContext {

    private final int numberOfTasks;
    private final int numberOfThreads;
    private final List<ContextThread> threads;
    private final Queue<Runnable> queue;
    private Context context;
    private final Object isFinished = new Object();

    public FixedThreadPoolWithContext(int maxCapacity, int numberOfTasks) {
        this.numberOfThreads = maxCapacity;
        this.threads = new ArrayList<>(maxCapacity);
        this.numberOfTasks = numberOfTasks;
        this.context = new ContextImpl(numberOfTasks) {
            @Override
            public void interrupt() {

                synchronized (queue) {
                    int notStartedTasks = queue.size();
                    queue.clear();
                    this.increaseInterruptedTaskCount(notStartedTasks);
                }
            }
        };
        this.queue = new ArrayDeque<>(numberOfTasks);
    }


    @Override
    public void execute(Runnable runnable) {
        synchronized (queue) {
            queue.add(runnable);
            queue.notify();
        }
    }

    @Override
    public void start() {
        IntStream.range(0, numberOfThreads)
                .forEach(i -> {
                    threads.add(i, new ContextThread());
                    threads.get(i).start();
                });
    }

    @Override
    public Context getContext() {
        return context;
    }

    @Override
    public void callback(Runnable callback) {
        new Thread(() -> {
            synchronized (isFinished) {
                int finish = countOfCompletedTasks();
                while (finish != numberOfTasks) {
                    try {
                        isFinished.wait();
                    } catch (InterruptedException ignored) {
                    }
                }
            }

            callback.run();

        }).start();
    }

    private int countOfCompletedTasks() {
        synchronized (context) {
            return context.getCompletedTaskCount() + context.getInterruptedTaskCount() + context.getFailedTaskCount();
        }
    }

    private final class ContextThread extends Thread {
        @Override
        public void run() {
            while (true) {
                Runnable runnable;
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            interrupt();
                        }
                    }

                    runnable = queue.poll();
                }
                try {
                    runnable.run();
                    context.increaseCompletedTaskCount();
                } catch (Exception e) {
                    context.increaseFailedTaskCount();
                } finally {
                    synchronized (isFinished) {
                        isFinished.notify();
                    }
                }

            }
        }
    }
}