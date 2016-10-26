package ru.sberbank.javaschool;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tanya on 26.10.2016.
 */
public class ScalableThreadPool implements ThreadPool {

    private MyQueue queue;
    private List <Thread> threads = new LinkedList<>();
    private int min, max;


    public ScalableThreadPool(int min, int max) {
        this.min = min;
        this.max = max;
        queue = new MyQueue(max);
    }


    @Override
    public void start() {
        for (int i = 0; i < min; i ++) {
            Thread thread = new Thread("Thread " + i);
            threads.add(thread);
            thread.start();
        }
    }


    @Override
    public void execute(Runnable runnable) throws InterruptedException {
        queue.put(runnable);
        if (queue.getSize() != threads.size()) threadControl();

    }


    private void threadControl() {
        if (queue.getSize() > min && threads.size() < max) {
            Thread t = new Thread("Additional thread " + queue.getSize() + 1);
            threads.add(t);
            t.start();
        }

        else {
            while(threads.size() >  min) {
                int lastIndex = threads.size() - 1;
                Thread t = threads.get(lastIndex);
                t.interrupt();
                threads.remove(t);
            }
        }
    }


}
