package package ru.sberbank.school.Homework5.Exception;


public class PinNotEnteredException extends TerminalException {

    public PinNotEnteredException(String message) {
        super("Пин - код не введен!");
    }

}
