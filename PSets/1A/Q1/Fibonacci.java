package com.example.lib;

public class Fibonacci{

    public static String fibonacci( int n ) {
        String output;
        if (n==0) {
            output = "0";
        }
        else {
            output = "0,1";
        }
        if (n>1) {
            output = "0,1";
            int num1 = 0;
            int num2 = 1;
            int temp;
            for (int i = 2; i < n; i++) {
                temp = num2;
                num2 = num1 + num2;
                num1 = temp;
                output += "," + num2;
            }
        }
        return output;
    }

}
