package ru.sberbank.school.ExecutionManager;


public interface ThreadPoolWithContext {
    void execute(Runnable runnable);
    void start();
    Context getContext();
    void callback(Runnable callback);
}
