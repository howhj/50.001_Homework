package com.example.norman_lee.myapplication;

public class Utils {
    static void checkInvalidInputs (String value, Boolean isDivisor) throws IllegalArgumentException, NumberFormatException {
        double num = Double.valueOf(value);
        if (num < 0) {
            throw new IllegalArgumentException();
        }
        else if (num == 0 && isDivisor) {
            throw new IllegalArgumentException();
        }
    }
}
