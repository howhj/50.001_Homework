package Q4.lib;

public class CheckingAccount extends Account {
    private int id = 0;
    private double balance = 0;

    public CheckingAccount() {}
    public CheckingAccount(int idValue, double balanceValue) {
        id = idValue;
        balance = balanceValue;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double value) {
        if (value < 0) {
            System.out.println("Invalid value.");
        }
        else if (balance - value <= -5000) {
            System.out.println("over limit");
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
