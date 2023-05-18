package org.yearup.banking;

public class Main
{
    public static void main(String[] args)
    {
        BankAccount ba = new CheckingAccount(123, "Joe", 2000);
        ba.withdraw(2100);
        System.out.println(ba.getBalance());
    }
}
