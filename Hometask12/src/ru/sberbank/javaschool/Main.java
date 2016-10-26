package ru.sberbank.javaschool;

/**
 * Created by tanya on 26.10.2016.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        int min = 5, max = 10;
        ThreadPool fixedThreadPool = new FixedThreadPool(max);
        ThreadPool scalableThreadPool = new ScalableThreadPool(min, max);
        fixedThreadPool.start();
        scalableThreadPool.start();


        for (int i = 0; i < max; i++) {
            fixedThreadPool.execute(new Test());
        }


        for (int i = 0; i < min; i++) {
            scalableThreadPool.execute(new Test());
        }


        for (int i = min; i < max; i++) {
            scalableThreadPool.execute(new Test());
        }


    }

}
