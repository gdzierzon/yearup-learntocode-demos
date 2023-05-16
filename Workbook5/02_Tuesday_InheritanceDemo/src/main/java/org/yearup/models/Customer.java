package org.yearup.models;

import java.util.ArrayList;

// extends = IS-A
public class Customer extends Person
{
    private int creditRating = 700;
    private ArrayList<BankAccount> bankAccounts = new ArrayList<>();

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
