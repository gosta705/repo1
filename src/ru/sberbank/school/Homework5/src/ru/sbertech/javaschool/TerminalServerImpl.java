package ru.sbertech.javaschool;


import ru.sbertech.javaschool.Exception.NotEnoughMoneyException;

public class TerminalServerImpl implements TerminalServer {

    private double currentAccountBalance = 100000;

    public TerminalServerImpl(){};

    @Override
    public double checkAccountBalance() {
        return currentAccountBalance;
    }

    @Override
    public boolean withdrawMoney(int amount) {
        if (amount > currentAccountBalance) {
            throw new NotEnoughMoneyException ("");
        } else {
            currentAccountBalance -= amount;
            return true;
        }
    }

    @Override
    public boolean depositMoney(double amount) {
        currentAccountBalance += amount;
        return true;
    }

}

