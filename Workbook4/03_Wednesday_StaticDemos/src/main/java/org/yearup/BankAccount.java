package org.yearup;

public class BankAccount
{
    // static class variables
    private static double interestRate;

    // instance variables
    private int accountNumber;
    private String owner;
    private double balance;

    static
    {
        interestRate = .025;
    }

    public BankAccount(int accountNumber, String owner, double balance)
    {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    public static double getInterestRate()
    {
        return interestRate;
    }

    public static void setInterestRate(double interestRate)
    {
        BankAccount.interestRate = interestRate;
    }

    public int getAccountNumber()
    {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber)
    {
        this.accountNumber = accountNumber;
    }

    public String getOwner()
    {
        return owner;
    }

    public void setOwner(String owner)
    {
        this.owner = owner;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public double withdraw(double amount)
    {
        if(balance >= amount)
        {
            balance -= amount;
        }

        return balance;
    }

    public double deposit(double amount)
    {
        balance += amount;
        return balance;
    }

    public void accrueInterest()
    {
        double monthlyInterest = interestRate / 12;
        balance += balance * monthlyInterest;
    }
}
