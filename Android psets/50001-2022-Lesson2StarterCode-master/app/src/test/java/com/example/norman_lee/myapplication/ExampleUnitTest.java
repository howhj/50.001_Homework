package com.example.norman_lee.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    //TODO 5.4 Write unit tests to check the ExchangeRate class
    @Test
    public void exchangeRateDefaultRate() {
        String defaultExchangeRate = "2.95000";
        assertEquals(defaultExchangeRate, new ExchangeRate().getExchangeRate().toString());
    }

    @Test
    public void exchangeRateString() {
        String expected = "5.00000";
        assertEquals(expected, new ExchangeRate(expected).getExchangeRate().toString());
    }

    @Test
    public void exchangeRateStrings() {
        String home = "1.0";
        String foreign = "5.0";
        String expected = "5.00000";
        assertEquals(expected, new ExchangeRate(home, foreign).getExchangeRate().toString());
    }

    @Test
    public void calculate() {
        String expected = "10.00000";
        assertEquals(expected, new ExchangeRate("5.00000").calculateAmount("2").toString());
    }
}