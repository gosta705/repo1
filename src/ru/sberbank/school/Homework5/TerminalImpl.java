package package ru.sberbank.school.Homework5;


import java.util.Calendar;
import Exception.AccountLockedException;
import Exception.NotValidAmountException;
import Exception.PinNotEnteredException;

public class TerminalImpl implements Terminal {

    private final TerminalServerImpl server = new TerminalServerImpl();
    private final PinValidator pinValidator = new PinValidator();
    private final Calendar unlockedTime = Calendar.getInstance();
    private boolean pinCodeIsCorrect = false;
    private int numberOfIncorrectPin = 0;

    @Override
    public int checkAccountBalance() {
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
    public boolean depositMoney(int amount) {
        pinCodeIsEntreid();
        if (amount <= 0 || amount % 100 != 0) throw new NotValidAmountException(" ");
        return server.depositMoney(amount);
    }

    @Override
    public boolean getAccess(int pinCode) {
        if (System.currentTimeMillis() < unlockedTime.getTimeInMillis()) {
            throw new AccountLockedException(unlockedTime.getTime() + "");
        }
        if (pinValidator.validate(pinCode)) {
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
