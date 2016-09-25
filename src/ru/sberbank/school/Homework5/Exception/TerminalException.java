package package ru.sberbank.school.Homework5.Exception;


public class TerminalException extends RuntimeException {

    public TerminalException(String message) {
        super(message);
    }

    public TerminalException(String message, Throwable cause) {
        super(message, cause);
    }

}
