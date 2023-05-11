package Q4.lib;

import java.util.*;

public class Account {
    private int id = 0;
    private double balance = 0;
    private static double annualInterestRate = 0;
    private Date dateCreated;

    Account() {

    }

    Account(int idValue, double balanceValue) {
        id = idValue;
        balance = balanceValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int value) {
        if (value >= 0) {
            id = value;
        }
        else {
            System.out.println("Invalid value.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance (double value) {
        if (value >= 0) {
            balance = value;
        }
        else {
            System.out.println("Invalid value.");
        }
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static void setAnnualInterestRate (double value) {
        if (value >= 0) {
            annualInterestRate = value;
        }
        else {
            System.out.println("Invalid value.");
        }
    }

    public Date getDateCreated()  {
        return dateCreated;
    }

    public void setDateCreated (Date value) {
        dateCreated = value;
    }

    public double getMonthlyInterestRate() {
        return annualInterestRate/12;
    }

    public double getMonthlyInterest() {
        double monthlyInterestRate = getMonthlyInterestRate();
        return balance * monthlyInterestRate / 100;
    }

    public void withdraw(double value) {
        if (value < 0) {
            System.out.println("Invalid value.");
        }
        else if (balance < value) {
            System.out.println("Insufficient balance.");
        }
        else {
            balance -= value;
        }
    }

    public void deposit(double value) {
        if (value >= 0) {
            balance += value;
        }
        else {
            System.out.println("Invalid value.");
        }
    }
}

// **HINT**
// The problem set says "assume all accounts have the same interest rate".
// What does that tell you about the variable(s) and/or method(s) relating to the interest rate?
