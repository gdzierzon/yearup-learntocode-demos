package org.yearup.ui;

import org.yearup.models.Transaction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserScreens
{
    Scanner scanner = new Scanner(System.in);

    public void clearScreen()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public String getInputString(String message)
    {
        System.out.print(message);
        return scanner.nextLine().strip();
    }

    public BigDecimal getInputBigDecimal(String message)
    {
        String input = getInputString(message);

        try
        {
            return new BigDecimal(input);
        }catch(Exception ex){}

        return null;
    }

    public int getInputInt(String message)
    {
        String input = getInputString(message);
        return Integer.parseInt(input);
    }

    public LocalDate getInputDate(String message)
    {
        String input = getInputString(message);

        try
        {
            return LocalDate.parse(input);
        }
        catch(Exception ex){}

        return null;
    }

    public void waitForUser()
    {
        System.out.println();
        getInputString("Press enter to continue...");
        clearScreen();
    }

    public void displayHeader(String title)
    {
        clearScreen();
        System.out.println();
        System.out.println(ColorCodes.YELLOW + "-".repeat(86) + ColorCodes.RESET);
        System.out.println(title);
        System.out.println(ColorCodes.YELLOW + "-".repeat(86) + ColorCodes.RESET);

    }

    public void displayHomeScreen()
    {
        displayHeader("Home");
        System.out.println("What would you like to do?");
        System.out.println(" D) Add Deposit");
        System.out.println(" P) Make Payment (Debit)");
        System.out.println(" L) Ledger");
        System.out.println(" X) Exit");
    }

    public void displayLedgerScreen()
    {
        displayHeader("Ledger");
        System.out.println("What would you like to do?");
        System.out.println(" A) All Transactions");
        System.out.println(" D) Deposits");
        System.out.println(" P) Payments");
        System.out.println(" R) Reports");
        System.out.println(" H) Home");
    }

    public void displayReportsScreen()
    {
        displayHeader("Reports");
        System.out.println("What would you like to do?");
        System.out.println(" 1) Month to Date");
        System.out.println(" 2) Previous Month");
        System.out.println(" 3) Year to Date");
        System.out.println(" 4) Previous Year");
        System.out.println(" 5) Search by Vendor");
        System.out.println(" 6) Custom Search");
        System.out.println(" 0) Back");
    }

    public void displayMessage(String message)
    {
        System.out.println();
        System.out.println(message);
    }

    public void displayWarning(String message)
    {
        displayMessage(ColorCodes.ORANGE + message + ColorCodes.RESET);
    }

    public void displayTransactions(String title, List<Transaction> transactions)
    {
        System.out.println();
        System.out.println(title.toUpperCase());
        System.out.println(ColorCodes.YELLOW + "-".repeat(86) + ColorCodes.RESET);
        System.out.printf(ColorCodes.CYAN + "%-12s %-10s %-30s %-20s $ %-8s\n" + ColorCodes.RESET, "Date","Time","Description","Vendor","Amount");
        System.out.println(ColorCodes.YELLOW + "------------ ---------- ------------------------------ -------------------- ----------" + ColorCodes.RESET);

        double netValue = 0;

        for(var t: transactions)
        {
            netValue += t.getAmount().doubleValue();

            System.out.printf("%-12s ", t.getTransactionDate());
            System.out.printf("%-10s ", t.getTransactionTime().format(DateTimeFormatter.ISO_TIME));
            System.out.printf("%-30s ", t.getDescription());
            System.out.printf("%-20s ", t.getVendor());
            System.out.print(t.getAmount().doubleValue() > 0 ? ColorCodes.GREEN : ColorCodes.RED);
            System.out.printf("$ %8.2f", t.getAmount().doubleValue());
            System.out.println(ColorCodes.RESET);
        }

        System.out.println();
        String color = netValue > 0 ? ColorCodes.GREEN : ColorCodes.RED;
        color += ColorCodes.BOLD;

        System.out.printf("Net Value: %s $ %.2f %s", color, netValue, ColorCodes.RESET);
    }
}
