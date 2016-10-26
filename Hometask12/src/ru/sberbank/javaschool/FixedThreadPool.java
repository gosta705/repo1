package ru.sberbank.javaschool;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tanya on 26.10.2016.
 */
public class FixedThreadPool implements ThreadPool {

    private MyQueue queue;
    private List<Thread> threads = new LinkedList<>();

    public FixedThreadPool(int numThreads) {
        queue = new MyQueue(numThreads);
    }

    @Override
    public void start() {
        for (int i = 0; i < queue.getLimit(); i ++) {
            Thread thread = new Thread("Thread " + i);
            threads.add(thread);
            thread.start();
        }
    }

    @Override
    public void execute(Runnable runnable) throws InterruptedException {
        queue.put(runnable);
    }

}
