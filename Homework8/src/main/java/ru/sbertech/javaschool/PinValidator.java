package ru.sbertech.javaschool;


public class PinValidator implements Validator {
    private final String cardNumber = "4545121267678989";
    private final char[] pinCode = new char[4];

    PinValidator(){
        pinCode[0] = '5';
        pinCode[1] = '4';
        pinCode[2] = '8';
        pinCode[3] = '9';
    }

    public boolean validate(String cardNumber, char[] pinCode){

        if (!this.cardNumber.equals(cardNumber)) return false;

        if (pinCode.length != 4) return false;
        for (int i = 0; i < 4; ++i){
            if(this.pinCode[i] != pinCode[i]) return false;
        }
        return true;
    }
}
