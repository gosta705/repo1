package ru.sberbank.school.ExecutionManager;


public class ContextImpl implements Context {
    private volatile int wellDoneTask = 0;
    private volatile int failedTask = 0;
    private volatile int interruptedTask = 0;
    private volatile boolean isFinish = false;
    private volatile boolean isInterrupt = false;

    @Override
    public int getCompletedTaskCount() {
        return wellDoneTask;
    }

    @Override
    public int getFailedTaskCount() {
        return failedTask;
    }

    @Override
    public int getInterruptedTaskCount() {
        return interruptedTask;
    }

    @Override
    public void interrupt() {
        isInterrupt = true;
    }

    @Override
    public boolean isFinished() {
        return isFinish;
    }


    public void addWellDoneTask() {
        wellDoneTask++;
    }


    public void addFailedTask() {
        failedTask++;
    }


    public void addInterruptedTask() {
        interruptedTask++;
    }


    public void finish() {
        isFinish = true;
    }


    public boolean isInterrupt() {
        return isInterrupt;
    }
}
