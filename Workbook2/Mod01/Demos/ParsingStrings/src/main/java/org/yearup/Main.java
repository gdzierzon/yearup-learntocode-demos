package org.yearup;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String inputLine = "123|Gregor|20.00|2020-05-15";

        int employeeId;
        String employeeName;
        double payRate;
        LocalDate hireDate;

        String[] columns = inputLine.split("\\|");

        employeeId = Integer.parseInt(columns[0]);
        employeeName = columns[1];
        payRate = Double.parseDouble(columns[2]);
        hireDate = LocalDate.parse(columns[3]);

        System.out.println(employeeId);
        System.out.println(employeeName);
        System.out.println(payRate * 2);
        System.out.println("Hire Date: " + hireDate);
        System.out.println("Month hired: " + hireDate.getMonth());

        System.out.println();
        System.out.print("Enter a date: ");
        String userInput = scanner.nextLine();

        // we can customize the input date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        LocalDate date = LocalDate.parse(userInput, formatter);

//        // by default the date string MUST be yyyy-MM-dd
//        LocalDate date2 = LocalDate.parse(userInput);

        System.out.println("You entered: " + date);


    }
}