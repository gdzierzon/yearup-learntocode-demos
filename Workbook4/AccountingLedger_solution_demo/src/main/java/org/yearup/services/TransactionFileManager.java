package org.yearup.services;

import org.yearup.models.Transaction;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class TransactionFileManager
{
    private String filePath;

    public TransactionFileManager(String filePath)
    {
        this.filePath = filePath;
    }

    public ArrayList<Transaction> loadTransactions()
    {
        ArrayList<Transaction> transactions = new ArrayList<>();

        try(FileReader reader = new FileReader(this.filePath);
            Scanner scanner = new Scanner(reader)
        )
        {
            scanner.nextLine();

            while(scanner.hasNext())
            {
                String line = scanner.nextLine();
                String[] columns = line.split("\\|");
                LocalDate date = LocalDate.parse(columns[0]);
                LocalTime time = LocalTime.parse(columns[1], DateTimeFormatter.ofPattern("HH:mm:ss"));
                String description = columns[2];
                String vendor = columns[3];
                BigDecimal amount = new BigDecimal(columns[4]);

                Transaction transaction = new Transaction(date, time, description, vendor, amount);

                transactions.add(transaction);
            }
        }
        catch (IOException ex)
        {

        }

        return transactions;
    }

    public void writeTransaction(Transaction transaction)
    {
        try(FileWriter fileWriter = new FileWriter(filePath, true);
            PrintWriter writer = new PrintWriter(fileWriter)
        )
        {
            writer.printf("%s|%s|%s|%s|%.2f\n",
                    transaction.getTransactionDate(),
                    transaction.getTransactionTime().format(DateTimeFormatter.ISO_TIME),
                    transaction.getDescription(),
                    transaction.getVendor(),
                    transaction.getAmount().doubleValue());
        }
        catch (IOException e)
        {
        }
    }
}
