package ru.sbertech.javaschool.Exception;


public class AccountLockedException extends TerminalException {

    public AccountLockedException(String message) {
        super("Пин - код неверно введен 3 раза, аккаунт будет заблокирован до " + message);
    }

}
