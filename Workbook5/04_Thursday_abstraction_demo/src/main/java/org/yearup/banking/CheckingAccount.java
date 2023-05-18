package org.yearup.banking;

public class CheckingAccount extends BankAccount
{
    private static final double overdraftLimit = 500;

    public CheckingAccount(int accountNumber, String owner, double balance)
    {
        super(accountNumber, owner, balance);
    }

    @Override
    public double withdraw(double amount)
    {
       if(getBalance() - amount >= -overdraftLimit)
       {
           super.withdraw(amount);
       }
       return getBalance();
    }
}
