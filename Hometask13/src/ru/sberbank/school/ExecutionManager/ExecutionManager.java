package ru.sberbank.school.ExecutionManager;


public interface ExecutionManager {
    Context execute(Runnable callback, Runnable... tasks);

}
