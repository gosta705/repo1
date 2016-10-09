package ru.sbertech.javaschool.Exception;


public class NotValidAmountException extends TerminalException {

    public NotValidAmountException(String message) {
        super("Сумма должна быть кратна 100 и положительна.");
    }

}
