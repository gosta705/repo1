package package ru.sberbank.school.Homework5;


public interface Terminal {

    int checkAccountBalance();

    boolean withdrawMoney(int amount);

    boolean depositMoney(int amount);

    boolean getAccess(int pinCode);

}
