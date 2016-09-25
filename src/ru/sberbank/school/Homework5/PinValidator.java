package package ru.sberbank.school.Homework5;


public class PinValidator {
    private final int pinCode = 5489;

    public boolean validate(int pinCode){
        if (this.pinCode == pinCode) return true;
        return false;
    }
}
