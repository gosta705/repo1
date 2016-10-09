package ru.sbertech.javaschool.Exception;


public class PinNotEnteredException extends TerminalException {

    public PinNotEnteredException(String message) {
        super("Пин - код не введен!");
    }

}
