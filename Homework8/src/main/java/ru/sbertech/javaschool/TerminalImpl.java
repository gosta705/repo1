package ru.sbertech.javaschool;


import ru.sbertech.javaschool.Exception.AccountLockedException;
import ru.sbertech.javaschool.Exception.NotValidAmountException;
import ru.sbertech.javaschool.Exception.PinNotEnteredException;

import java.util.Calendar;


public class TerminalImpl implements Terminal {

    private final TerminalServerImpl server = new TerminalServerImpl();
    private final PinValidator pinValidator = new PinValidator();
    private final Calendar unlockedTime = Calendar.getInstance();
    private boolean pinCodeIsCorrect = false;
    private int numberOfIncorrectPin = 0;

    @Override
    public double checkAccountBalance() {
        pinCodeIsEntreid();
        return server.checkAccountBalance();
    }

    @Override
    public boolean withdrawMoney(int amount) {
        pinCodeIsEntreid();
        if (amount <= 0 || amount % 100 != 0) throw new NotValidAmountException(" ");
        return server.withdrawMoney(amount);
    }

    @Override
    public boolean depositMoney(double amount) {
        pinCodeIsEntreid();
        if (amount <= 0 || amount % 100 != 0) throw new NotValidAmountException(" ");
        return server.depositMoney(amount);
    }

    @Override
    public boolean getAccess(String cardNumber, char[] pinCode) {
        if (System.currentTimeMillis() < unlockedTime.getTimeInMillis()) {
            throw new AccountLockedException(unlockedTime.getTime() + "");
        }
        if (pinValidator.validate(cardNumber, pinCode)) {
            pinCodeIsCorrect = true;
            return true;
        } else {
            if (++ numberOfIncorrectPin == 3) {
                numberOfIncorrectPin = 0;
                long unlockedTimeInMilliS = System.currentTimeMillis() + 5000;
                unlockedTime.setTimeInMillis(unlockedTimeInMilliS);
                throw new AccountLockedException(unlockedTime.getTime() + "");
            }
        }
        return false;
    }

    private void pinCodeIsEntreid(){
        if (!pinCodeIsCorrect)  throw new PinNotEnteredException(" ");
        pinCodeIsCorrect = false;
    }

}
