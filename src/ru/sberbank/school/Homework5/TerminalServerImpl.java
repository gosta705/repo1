package package ru.sberbank.school.Homework5;


import Exception.NotEnoughMoneyException;

public class TerminalServerImpl implements TerminalServer {

    private int currentAccountBalance = 100000;

    public TerminalServerImpl(){};

    @Override
    public int checkAccountBalance() {
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
    public boolean depositMoney(int amount) {
        currentAccountBalance += amount;
        return true;
    }

}

