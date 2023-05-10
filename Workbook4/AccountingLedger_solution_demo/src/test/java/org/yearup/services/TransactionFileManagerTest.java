package org.yearup.services;

import org.junit.jupiter.api.Test;
import org.yearup.models.Transaction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TransactionFileManagerTest
{
    @Test
    public void loadTransactions_should_loadAllTransactionsFromFile()
    {

        // arrange
        // test file path data/test_transactions.csv
        String testFile = "data\\test_transactions.csv";
        TransactionFileManager fileManager = new TransactionFileManager(testFile);
        Transaction transaction1 = new Transaction(LocalDate.parse("2021-03-15"),
                                                    LocalTime.parse("10:13:25"),
                                                    "ergonomic keyboard",
                                                    "Amazon",
                                                    new BigDecimal("-89.50"));
        Transaction transaction2 = new Transaction(LocalDate.parse("2021-04-15"),
                                                    LocalTime.parse("11:15:00"),
                                                    "Invoice 1001 paid",
                                                    "Joe",
                                                    new BigDecimal("1500.00"));
        ArrayList<Transaction> expectedList = new ArrayList<>();
        expectedList.add(transaction1);
        expectedList.add(transaction2);

        // act
        ArrayList<Transaction> actualList = fileManager.loadTransactions();

        // assert
        assertEquals(expectedList.size(), actualList.size(), "because the test file only has 2 transactions");
        for (int i = 0; i < expectedList.size(); i++)
        {
            Transaction expected = expectedList.get(i);
            Transaction actual = actualList.get(i);

            assertEquals(expected.getTransactionDate(), actual.getTransactionDate(), "because the dates should match");
            assertEquals(expected.getTransactionTime(), actual.getTransactionTime(), "because the times should match");
            assertEquals(expected.getDescription(), actual.getDescription(), "because the descriptions should match");
            assertEquals(expected.getVendor(), actual.getVendor(), "because the vendors should match");
            assertEquals(expected.getAmount(), actual.getAmount(), "because the amounts should match");
        }


    }

}