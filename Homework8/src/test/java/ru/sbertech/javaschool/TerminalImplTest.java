package ru.sbertech.javaschool;

import ru.sbertech.javaschool.Exception.*;

import static org.junit.Assert.*;
import org.junit.Test;

public class TerminalImplTest {

    Terminal terminalImplTest = new TerminalImpl();
    String myCardNumber = "4545121267678989";
    char [] myPinCode = new char[]{'5', '4', '8', '9'};

    @Test
    public void checkAccountBalanceTest() {
        terminalImplTest.getAccess(myCardNumber, myPinCode);
        assertTrue("Error, account is not empty", terminalImplTest.checkAccountBalance() == 0.0);
    }

    @Test(expected = NotValidAmountException.class)
    public final void withdrawMoneyTest1() {
        terminalImplTest.getAccess(myCardNumber, myPinCode);
        terminalImplTest.withdrawMoney(-1);
    }

    @Test(expected = NotValidAmountException.class)
    public final void withdrawMoneyTest2() {
        terminalImplTest.getAccess(myCardNumber, myPinCode);
        terminalImplTest.withdrawMoney(11);
    }

    @Test(expected = NotEnoughMoneyException.class)
    public final void withdrawMoneyTest3() {
        terminalImplTest.getAccess(myCardNumber, myPinCode);
        terminalImplTest.withdrawMoney(100);
    }

    @Test(expected = NotValidAmountException.class)
    public final void depositwMoneyTest1() {
        terminalImplTest.getAccess(myCardNumber, myPinCode);
        terminalImplTest.depositMoney(-2);
    }

    @Test(expected = NotValidAmountException.class)
    public final void depositMoneyTest2() {
        terminalImplTest.getAccess(myCardNumber, myPinCode);
        terminalImplTest.depositMoney(12);
    }

    @Test(expected = AccountLockedException.class)
    public void getAccessTest() {
        String myCardNumber = "111222333444";
        for(int i = 0; i<10; ++i) {
            terminalImplTest.getAccess(myCardNumber, new char[4]);
        }

    }

}