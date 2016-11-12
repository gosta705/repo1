package ru.sberbank.school.ExecutionManager;


public class ContextImpl implements Context {
    private int numberOfTasks;
    private int completedTasks = 0;
    private int failedTasks = 0;
    private int interruptedTasks = 0;

    public ContextImpl(int numberOfTasks) {
        this.numberOfTasks = numberOfTasks;
    }

    @Override
    public synchronized int getCompletedTaskCount() {
        return completedTasks;
    }

    @Override
    public synchronized int getFailedTaskCount() {
        return failedTasks;
    }

    @Override
    public synchronized int getInterruptedTaskCount() {
        return interruptedTasks;
    }

    @Override
    public void interrupt() {

    }
    @Override
    public boolean isFinished() {
        return numberOfTasks == completedTasks + failedTasks + interruptedTasks;
    }

    @Override
    public synchronized void increaseCompletedTaskCount() {
        completedTasks++;
    }

    @Override
    public synchronized void increaseFailedTaskCount() {
        failedTasks++;
    }

    @Override
    public synchronized void increaseInterruptedTaskCount(int inc) {
        interruptedTasks+=inc;
    }
}
