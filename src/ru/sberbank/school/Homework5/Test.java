package package ru.sberbank.school.Homework5;


import Exception.TerminalException;

public class Test {
    public static void main(String [] args){
        TerminalImpl testTerminal = new TerminalImpl();

        System.out.println("Тест 1: попытка проверить баланс, без ввода пин - кода.");
        try {
            testTerminal.checkAccountBalance();
        } catch (TerminalException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println("Тест 2: добавить 300, снять 200.");
        try {
            testTerminal.getAccess(5489);
            System.out.println("Баланс счета: " + testTerminal.checkAccountBalance());
            testTerminal.getAccess(5489);
            testTerminal.depositMoney(300);

            testTerminal.getAccess(5489);
            testTerminal.withdrawMoney(200);
            testTerminal.getAccess(5489);
            System.out.println("Баланс счета: " + testTerminal.checkAccountBalance());

        } catch (TerminalException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println("Тест 3: снять больше чем есть на счету.");
        try {
            testTerminal.getAccess(5489);
            System.out.println("Баланс счета: " + testTerminal.checkAccountBalance());
            testTerminal.getAccess(5489);
            testTerminal.withdrawMoney(2000000);
        } catch (TerminalException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println("Тест 4: добавить некратное 100 число.");
        try {
            testTerminal.getAccess(5489);
            System.out.println("Баланс счета: " + testTerminal.checkAccountBalance());
            testTerminal.getAccess(5489);
            testTerminal.depositMoney(101);
        } catch (TerminalException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println("Тест 5: многократно неправильно введенный пин - код.");
        try {
            for(int i = 0; i<10; ++i) {
                testTerminal.getAccess(1234);
            }
        } catch (TerminalException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

    }
}
