package org.yearup;

import org.yearup.models.Transaction;
import org.yearup.services.TransactionFileManager;
import org.yearup.ui.UserScreens;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class AccountingLedgerApp
{
    UserScreens ui = new UserScreens();

    TransactionFileManager transactionManager = new TransactionFileManager("data\\transactions.csv");
    ArrayList<Transaction> transactions;

    public AccountingLedgerApp()
    {
        transactions = transactionManager.loadTransactions();
    }

    public void run()
    {
        while(true)
        {
            ui.displayHomeScreen();
            String choice = ui.getInputString("Enter your selection: ").toLowerCase();

            switch (choice)
            {
                case "d":
                    addTransaction(true);
                    break;
                case "p":
                    addTransaction(false);
                    break;
                case "l":
                    viewLedger();
                    break;
                case "x":
                    ui.displayMessage("Thank you. Good Bye.");
                    return;
                default:
                    ui.displayWarning("That was an invalid option. Please try again.");
                    break;
            }
        }
    }

    private void addTransaction(boolean isDeposit)
    {
        String header = isDeposit ? "Add Deposit" : "Add Payment";

        ui.displayHeader(header);
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
        String description = ui.getInputString("Enter description: ");
        String vendor = ui.getInputString("Enter vendor name: ");
        BigDecimal amount = ui.getInputBigDecimal("Enter the amount: $ ");

        if(!isDeposit) amount = amount.multiply(BigDecimal.valueOf(-1));

        Transaction transaction = new Transaction(date, time, description, vendor, amount);
        transactionManager.writeTransaction(transaction);
        transactions.add(transaction);
    }

    private void viewLedger()
    {
        while(true)
        {
            ui.displayLedgerScreen();
            String choice = ui.getInputString("Enter your selection: ").toLowerCase();

            switch (choice)
            {
                case "a":
                    ui.displayTransactions("All Transactions", transactions);
                    break;
                case "d":
                    var deposits = transactions.stream()
                            .filter(t -> t.getAmount().doubleValue() > 0)
                            .collect(Collectors.toList());

                    ui.displayTransactions("Deposits", deposits);
                    break;
                case "p":
                    var payments = transactions.stream()
                                               .filter(t -> t.getAmount().doubleValue() <= 0)
                                               .collect(Collectors.toList());

                    ui.displayTransactions("Deposits", payments);
                    break;
                case "r":
                    viewReports();
                    break;
                case "h":
                    return;
                default:
                    ui.displayWarning("That was an invalid option. Please try again.");
                    break;
            }
            ui.waitForUser();
        }
    }

    private void viewReports()
    {
        LocalDate today = LocalDate.now();
        int dayOfMonth = today.getDayOfMonth();
        LocalDate start = null;
        LocalDate end = null;
        LocalDate temp = null;

        while(true)
        {
            ui.displayReportsScreen();
            int choice  = -1;
            try
            {
                choice = ui.getInputInt("Enter your selection: ");
            }catch(Exception ex){}

            switch (choice)
            {
                case 1:
                    // Month-to-Date
                    // last day of previous month
                    start = today.minusDays(dayOfMonth);
                    // tomorrow
                    end = today.plusDays(1);
                    filterByDateRange("Month to Date", start, end);
                    break;
                case 2:
                    // Previous Month
                    temp = today.minusMonths(1);
                    // last day of 2 months ago
                    start = LocalDate.of(temp.getYear(), temp.getMonthValue(), 1).minusDays(1);
                    // first day of this month
                    end = LocalDate.of(today.getYear(), today.getMonthValue(), 1);
                    filterByDateRange("Previous Month", start, end);
                    break;
                case 3:
                    // Year-to-Date
                    // last day of last year
                    start = LocalDate.of(today.getYear() - 1, 12, 31);
                    // tomorrow
                    end = today.plusDays(1);
                    filterByDateRange("Year to Date", start, end);
                    break;
                case 4:
                    // Previous Year
                    // last day of 2 years ago
                    start = LocalDate.of(today.getYear() - 2, 12, 31);
                    // first day of this year
                    end = LocalDate.of(today.getYear(), 1, 1);
                    filterByDateRange("Previous Year", start, end);
                    break;
                case 5:
                    // Search by Vendor
                    filterByVendor();
                    break;
                case 6:
                    // custom search
                    filterCustom();
                    break;
                case 0:
                    return;
                default:
                    ui.displayWarning("That was an invalid option. Please try again.");
                    break;
            }

            ui.waitForUser();
        }
    }

    private void filterByDateRange(String report, LocalDate start, LocalDate end)
    {

        var filtered = transactions.stream()
                                   .filter(t -> t.getTransactionDate().isAfter(start) && t.getTransactionDate().isBefore(end))
                                   .collect(Collectors.toList());

        report = report + ": " + start.plusDays(1) + " - " + end.minusDays(1);

        ui.displayTransactions(report, filtered);
    }

    private void filterByVendor()
    {
        String vendor = ui.getInputString("Enter the vendor Name: ").toLowerCase();

        var filtered = transactions.stream()
                                   .filter(t -> t.getVendor().toLowerCase().contains(vendor))
                                   .collect(Collectors.toList());

        String report = "Search by Vendor: " + vendor;

        ui.displayTransactions(report, filtered);
    }

    private void filterCustom()
    {
        LocalDate start = ui.getInputDate("Enter start date yyyy-mm-dd (leave blank to skip): ");
        LocalDate end = ui.getInputDate("Enter end date yyyy-mm-dd (leave blank to skip): ");
        String description = ui.getInputString("Enter the description (leave blank to skip): ").toLowerCase();
        String vendor = ui.getInputString("Enter the vendor (leave blank to skip): ").toLowerCase();
        BigDecimal minAmount = ui.getInputBigDecimal("Enter the minimum amount (leave blank to skip): ");
        BigDecimal maxAmount = ui.getInputBigDecimal("Enter the maximum amount (leave blank to skip): ");

        boolean hasStartDate = start != null;
        boolean hasEndDate = end != null;
        boolean hasDescription = description != null && !description.equals("");
        boolean hasVendor = vendor != null && !vendor.equals("");
        boolean hasMinAmount = minAmount != null;
        boolean hasMaxAmount = maxAmount != null;

        var filtered = transactions.stream()
                                   .filter(t -> !hasStartDate || t.getTransactionDate().isAfter(start.minusDays(1)))
                                   .filter(t -> !hasEndDate || t.getTransactionDate().isBefore(end.plusDays(1)))
                                   .filter(t -> !hasDescription || t.getDescription().toLowerCase().contains(description))
                                   .filter(t -> !hasVendor || t.getVendor().toLowerCase().contains(vendor))
                                   .filter(t -> !hasMinAmount || t.getAmount().doubleValue() >= minAmount.doubleValue())
                                   .filter(t -> !hasMaxAmount || t.getAmount().doubleValue() <= maxAmount.doubleValue())
                                   .collect(Collectors.toList());

        String report = "Custom Search";

        ui.displayTransactions(report, filtered);
    }

}
