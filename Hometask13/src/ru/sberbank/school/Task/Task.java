package ru.sberbank.school.Task;

import java.util.concurrent.Callable;

public class Task <T>{
    private Callable<? extends T> task;
    private Exception exception;
    private T result;


    public Task(Callable<? extends T> task) {
        this.task = task;
    }


    public T get() throws Exception {
        if (exception != null) {
            throw exception;
        }
        if (result == null)  {
            synchronized (this) {
                try {
                    result = task.call();
                } catch (Exception e) {
                    if (exception != null)
                        exception = new TaskException(e.getMessage());
                    throw exception;
                }
            }
        }
        return result;
    }

}
