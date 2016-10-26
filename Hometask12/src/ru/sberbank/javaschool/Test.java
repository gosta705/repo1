package ru.sberbank.javaschool;

/**
 * Created by tanya on 26.10.2016.
 */
public class Test implements Runnable {
    Thread runner;

    public Test() {
        this.runner = new Thread(this);
        this.runner.start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}