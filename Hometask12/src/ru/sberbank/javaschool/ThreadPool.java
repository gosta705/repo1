package ru.sberbank.javaschool;

/**
 * Created by tanya on 26.10.2016.
 */
public interface ThreadPool {

    void start();

    void execute(Runnable runnable) throws InterruptedException;

}
