package ru.sbertech.javaschool;

public interface Terminal {

    double checkAccountBalance();

    boolean withdrawMoney(int amount);

    boolean depositMoney(double amount);

    boolean getAccess(String cardNumber, char[] pinCode);

}
