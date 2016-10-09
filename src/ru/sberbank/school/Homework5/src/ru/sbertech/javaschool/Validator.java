package ru.sbertech.javaschool;

public interface Validator {
    boolean validate(String cardNumber, char[] pinCode);
}
