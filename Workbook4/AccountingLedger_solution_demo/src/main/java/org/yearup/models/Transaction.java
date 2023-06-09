package org.yearup.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction
{
    LocalDate transactionDate;
    LocalTime transactionTime;
    String description;
    String vendor;
    BigDecimal amount;

    public Transaction()
    {
    }

    public Transaction(LocalDate transactionDate, LocalTime transactionTime, String description, String vendor, BigDecimal amount)
    {
        this.transactionDate = transactionDate;
        this.transactionTime = transactionTime;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    public LocalDate getTransactionDate()
    {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate)
    {
        this.transactionDate = transactionDate;
    }

    public LocalTime getTransactionTime()
    {
        return transactionTime;
    }

    public void setTransactionTime(LocalTime transactionTime)
    {
        this.transactionTime = transactionTime;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getVendor()
    {
        return vendor;
    }

    public void setVendor(String vendor)
    {
        this.vendor = vendor;
    }

    public BigDecimal getAmount()
    {
        return amount;
    }

    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }
}
