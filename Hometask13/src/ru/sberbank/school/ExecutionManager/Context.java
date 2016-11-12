package ru.sberbank.school.ExecutionManager;


public interface Context {
    int getCompletedTaskCount();


    int getFailedTaskCount();


    int getInterruptedTaskCount();


    void interrupt();


    boolean isFinished();

    void increaseCompletedTaskCount();

    void increaseFailedTaskCount();

    void increaseInterruptedTaskCount(int inc);


}