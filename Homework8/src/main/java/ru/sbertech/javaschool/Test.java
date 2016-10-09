package ru.sbertech.javaschool;


import ru.sbertech.javaschool.Exception.TerminalException;

public class Test {
    public static void main(String [] args){
        /*Terminal testTerminal = new TerminalImpl();
        char[] myPinCode = new char[4];
        String myCardNumber = "4545121267678989";

        myPinCode[0] = '5';
        myPinCode[1] = '4';
        myPinCode[2] = '8';
        myPinCode[3] = '9';

        System.out.println("Тест 1: попытка проверить баланс, без ввода пин - кода.");
        try {
            testTerminal.checkAccountBalance();
        } catch (TerminalException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println("Тест 2: добавить 300, снять 200.");
        try {
            testTerminal.getAccess(myCardNumber, myPinCode);
            System.out.println("Баланс счета: " + testTerminal.checkAccountBalance());
            testTerminal.getAccess(myCardNumber, myPinCode);
            testTerminal.depositMoney(300);

            testTerminal.getAccess(myCardNumber, myPinCode);
            testTerminal.withdrawMoney(200);
            testTerminal.getAccess(myCardNumber, myPinCode);
            System.out.println("Баланс счета: " + testTerminal.checkAccountBalance());

        } catch (TerminalException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println("Тест 3: снять больше чем есть на счету.");
        try {
            testTerminal.getAccess(myCardNumber, myPinCode);
            System.out.println("Баланс счета: " + testTerminal.checkAccountBalance());
            testTerminal.getAccess(myCardNumber, myPinCode);
            testTerminal.withdrawMoney(2000000);
        } catch (TerminalException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println("Тест 4: добавить некратное 100 число.");
        try {
            testTerminal.getAccess(myCardNumber, myPinCode);
            System.out.println("Баланс счета: " + testTerminal.checkAccountBalance());
            testTerminal.getAccess(myCardNumber, myPinCode);
            testTerminal.depositMoney(101);
        } catch (TerminalException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println("Тест 5: многократно неправильно введенный пин - код.");
        try {
            for(int i = 0; i<10; ++i) {
                testTerminal.getAccess(myCardNumber, new char[4]);
            }
        } catch (TerminalException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();*/

    }
}
