package ru.sbertech.javaschool;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PinValidatorTest {

    Validator pinValidator = new PinValidator();

    String myCardNumber = "4545121267678989";
    char [] myPinCode = new char[]{'5', '4', '8', '9'};

    String wrongCardNumber = "111222333";
    char [] wrongPinCode = new char[]{'1', '2', '3', '4'};

    @Test
    public void wrongTestValidate() throws Exception {
        assertTrue("Pin code is incorrect", pinValidator.validate(wrongCardNumber, wrongPinCode));
    }

    @Test
    public void correctTestValidate() throws Exception {
        assertTrue("Pin code is correct", pinValidator.validate(myCardNumber, myPinCode));
    }
}