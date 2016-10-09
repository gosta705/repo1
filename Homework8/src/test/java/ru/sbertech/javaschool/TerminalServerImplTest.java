package ru.sbertech.javaschool;

import ru.sbertech.javaschool.Exception.*;

import static org.junit.Assert.*;
import org.junit.Test;

public class TerminalServerImplTest {
    TerminalServer testTerminalServer = new TerminalServerImpl();

    @Test
    public void checkAccountBalance() {
        assertTrue("Error, account is not empty", testTerminalServer.checkAccountBalance() == 0);
    }

    @Test(expected = NotEnoughMoneyException.class)
    public void withdrawMoney() {
        testTerminalServer.withdrawMoney(100);
    }

    @Test
    public void depositMoney() {
        assertTrue("Deposit money error", testTerminalServer.depositMoney(100) == true);
    }
}