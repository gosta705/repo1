package ru.sbertech.javaschool;

public interface TerminalServer {

    double checkAccountBalance();

    boolean withdrawMoney(int amount);

    boolean depositMoney(double amount);

}
