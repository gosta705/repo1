package ru.sberbank.school.ExecutionManager;


import java.util.Arrays;



public class ExecutionManagerImpl implements ExecutionManager {
    private final int numberOfThreads;


    public ExecutionManagerImpl(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
    }


    @Override
    public Context execute(Runnable callback, Runnable... tasks) {
        ThreadPoolWithContext threadPool = new FixedThreadPoolWithContext(numberOfThreads,tasks.length);
        threadPool.start();
        Arrays.stream(tasks)
                .forEach(threadPool::execute);
        threadPool.callback(callback);
        return threadPool.getContext();
    }
}
