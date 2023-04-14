package org.yearup;

import java.util.Scanner;

public class PayrollCalculator
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        // declare required variables
        String name;
        double hoursWorked;
        double payRate;
        double regularPay;
        double overtimePay = 0;
        double totalPay;

        // get user input
        System.out.print("Enter your name: ");
        name = scanner.nextLine();

        System.out.print("Enter thr hours worked: ");
        hoursWorked = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter the pay rate: ");
        payRate = scanner.nextDouble();
        scanner.nextLine();

        // perform calculations
        regularPay = hoursWorked * payRate;

        // calculate overtime only if hours worked is over 40
        if(hoursWorked > 40)
        {
            regularPay = payRate * 40;
            double overtimeHours = hoursWorked - 40;
            overtimePay = overtimeHours * (payRate * 1.5);
        }

        totalPay = regularPay + overtimePay;

        // display output
        System.out.println();
        System.out.println(name);
        System.out.println("---------------------");
        System.out.println("Hours:       " + hoursWorked);
        System.out.println("Pay Rate:  $ " + payRate);
        System.out.println("Regular:   $ " + regularPay);
        System.out.println("Overtime:  $ " + overtimePay);
        System.out.println("---------------------");
        System.out.println("Total Pay: $ " + totalPay);
    }
}
