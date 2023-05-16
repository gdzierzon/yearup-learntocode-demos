package org.yearup.models;

import java.time.LocalDate;
import java.util.ArrayList;

// extends = IS-A
public class Customer extends Person
{
    private int creditRating;
    private ArrayList<BankAccount> bankAccounts = new ArrayList<>();

    public Customer(int id, String firstName, String lastName, LocalDate birthDate,
                    int creditRating)
    {
        super(id, firstName, lastName, birthDate);

        this.creditRating = creditRating;
        System.out.println("Log... Customer constructor");
    }

    public String getCustomerName()
    {
        return getFirstName() + " " + getLastName();
    }

    public int getCreditRating()
    {
        return creditRating;
    }

    public int getNumberOfBankAccounts()
    {
        return bankAccounts.size();
    }

    public boolean isHighRisk()
    {
        return  creditRating < 600;
    }

    public void calculateCreditRating()
    {
        // do our background check
        // set the creditRating
    }

    public void addAccount(BankAccount account)
    {
        bankAccounts.add(account);
    }
}
