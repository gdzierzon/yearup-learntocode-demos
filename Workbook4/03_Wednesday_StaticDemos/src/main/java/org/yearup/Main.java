package org.yearup;

public class Main
{
    public static void main(String[] args)
    {

        BankAccount yours = new BankAccount(123, "you", 25000);
        BankAccount mine = new BankAccount(456, "me", 500);

        System.out.println(yours.getOwner());
        System.out.println(yours.getBalance());

//        BankAccount.setInterestRate(0.025);
        yours.accrueInterest();
        System.out.println();
        System.out.println("after accrue interest");
        System.out.println(yours.getOwner());
        System.out.println(yours.getBalance());


        System.out.println();
        System.out.println("-- Calculator --");

        // not possible for me to create a new Calculator
        // Calculator calc = new Calculator();

        System.out.println(Calculator.add(5, 12));



    }
}