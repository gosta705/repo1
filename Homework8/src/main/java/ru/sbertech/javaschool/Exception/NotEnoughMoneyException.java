package ru.sbertech.javaschool.Exception;


public class NotEnoughMoneyException extends TerminalException {

    public NotEnoughMoneyException(String message) {
        super("Не хватает денег на счету.");
    }

}
