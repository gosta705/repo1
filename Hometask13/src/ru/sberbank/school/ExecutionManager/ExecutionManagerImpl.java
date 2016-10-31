package ru.sberbank.school.ExecutionManager;


import java.util.ArrayDeque;
import java.util.Queue;


public class ExecutionManagerImpl implements ExecutionManager {
    private final ContextImpl context = new ContextImpl();
    private final FixedThreadPool threadPool;

    public ExecutionManagerImpl(int maximumTreads) {
        threadPool = new FixedThreadPool(maximumTreads);
    }

    public Context execute(Runnable callback, Runnable... tasks) {
        try {
            threadPool.start();
            for (Runnable r : tasks) {
                threadPool.execute(r);
            }
        } finally {
            Thread callbackThread = new Thread(callback);
            callbackThread.start();
            context.finish();
        }

        return context;
    }

    class FixedThreadPool {
        private volatile Queue<Runnable> tasks = new ArrayDeque<>();
        private final int threadCount;

        public FixedThreadPool(int threadCount) {
            this.threadCount = threadCount;
        }

        public void start() {
            for (int i = 0; i < threadCount; i++) {
                new Worker().start();
            }
        }

        public void execute(Runnable runnable) {
            tasks.add(runnable);
            notify();
        }

        public class Worker extends Thread {
            @Override
            public void run() {
                while (true) {
                    try {
                        if (!tasks.isEmpty()) {
                            Runnable poll = tasks.poll();
                            if (!context.isInterrupt()) {
                                try {
                                    poll.run();
                                    context.addWellDoneTask();
                                } catch (Exception e) {
                                    context.addFailedTask();
                                }
                            } else context.addInterruptedTask();

                        } else wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
