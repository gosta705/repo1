package package ru.sberbank.school.Homework5.Exception;


public class NotEnoughMoneyException extends TerminalException {

    public NotEnoughMoneyException(String message) {
        super("Не хватает денег на счету.");
    }

}
