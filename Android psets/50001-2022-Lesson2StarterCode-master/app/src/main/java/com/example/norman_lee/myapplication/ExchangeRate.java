package com.example.norman_lee.myapplication;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class ExchangeRate {

    private BigDecimal exchangeRate;
    private static String defaultRate = "2.95000";
    private static final int DEFAULT_PRECISION = 5;
    private int precision = DEFAULT_PRECISION;
    private MathContext mathContext;


    ExchangeRate(){
        exchangeRate = new BigDecimal(defaultRate);
        instantiateMathContext(DEFAULT_PRECISION);
    }

    ExchangeRate(String exchangeRate){
        this.exchangeRate = new BigDecimal(exchangeRate);
        instantiateMathContext(DEFAULT_PRECISION);
    }

    ExchangeRate(String home, String foreign) {
        instantiateMathContext(DEFAULT_PRECISION);
        //3.13a The constructor initializes exchangeRate by calculating the exchangeRate
        BigDecimal a = new BigDecimal(home);
        BigDecimal b = new BigDecimal(foreign);
        this.exchangeRate = b.divide(a, mathContext);
    }

    BigDecimal getExchangeRate(){
        /*int temp = precision;
        setPrecision(2);
        exchangeRate = exchangeRate.round(mathContext);
        setPrecision(temp);*/
        return exchangeRate;
    }

    BigDecimal calculateAmount(String foreign){
        //2.5a complete this method to return the amount
        BigDecimal input = new BigDecimal(foreign);
        return input.multiply(exchangeRate);
    }

    void setPrecision(int precision){
        this.precision = precision;
        instantiateMathContext(precision);
    }

    private void instantiateMathContext(int precision){
        mathContext = new MathContext(precision, RoundingMode.HALF_UP);
    }
}
