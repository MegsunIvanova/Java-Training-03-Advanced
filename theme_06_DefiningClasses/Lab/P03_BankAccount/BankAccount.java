package theme_06_DefiningClasses.Lab.P03_BankAccount;

public class BankAccount {
    private static double interestRate = 0.02;
    private static int nextID = 1;

    private int id;
    private double balance;

    public BankAccount() {
        this.id = nextID;
        nextID++;
        this.balance = 0;
    }

    public int getID () {
        return this.id;
    }

    public static void setInterestRate(double interest) {
        interestRate = interest;
    }

    public double getInterest(int years) {
        return (this.balance * interestRate * years);
    }

    public void deposit(double amount) {
        this.balance += amount;
    }
}
