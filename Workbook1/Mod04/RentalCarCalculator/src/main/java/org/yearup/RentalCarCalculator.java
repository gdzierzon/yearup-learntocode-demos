package org.yearup;

import java.util.Scanner;

public class RentalCarCalculator
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);

        // constants
        final double DAILY_RATE = 29.99;
        final double SURCHARGE = .3;
        final int MINIMUM_AGE = 25;
        final double TOLL_RATE = 3.95;
        final double GPS_RATE = 2.95;
        final double ROADSIDE_RATE = 3.95;

        // declare variables
        String pickupDate;
        int numberOfDays;
        boolean hasTollTag;
        boolean hasGps;
        boolean hasRoadsideAssitance;
        int driverAge;

        double subTotal = 0;
        double surcharge = 0;
        double tollCost = 0;
        double gpsCost = 0;
        double roadsideCost = 0;
        double totalCost = 0;

        // get user input
        System.out.print("Enter the pickup date (mm/dd/yyyy): ");
        pickupDate = userInput.nextLine();

        System.out.print("How many days do you need the car: ");
        numberOfDays = userInput.nextInt();
        userInput.nextLine();

        System.out.print("Do you need a toll tag (y/n): ");
        hasTollTag = userInput.nextLine().equalsIgnoreCase("y");

        System.out.print("Do you need GPS (y/n): ");
        hasGps = userInput.nextLine().equalsIgnoreCase("y");

        System.out.print("Do you need roadside assistance (y/n): ");
        hasRoadsideAssitance = userInput.nextLine().equalsIgnoreCase("y");

        System.out.print("What is the age of the driver: ");
        driverAge = userInput.nextInt();
        userInput.nextLine();

        // calculate all costs
        subTotal = DAILY_RATE * numberOfDays;
        if(driverAge < MINIMUM_AGE)
        {
            surcharge = subTotal * SURCHARGE;
        }
        if(hasTollTag)
        {
            tollCost = TOLL_RATE * numberOfDays;
        }
        if(hasGps)
        {
            gpsCost = GPS_RATE * numberOfDays;
        }
        if(hasRoadsideAssitance)
        {
            roadsideCost = ROADSIDE_RATE * numberOfDays;
        }
        totalCost = subTotal + surcharge + tollCost + gpsCost + roadsideCost;

        // display output
        System.out.println();
        System.out.println("Rental Agreement");
        System.out.println("---------------------------");
        System.out.printf( "Pickup Date:    %s\n", pickupDate);
        System.out.printf( "Number Of Days: %s\n", numberOfDays);
        System.out.println();
        System.out.printf( "%-20s %-7s %-5s %s", "Item", "Rate", "Days", "Price\n");
        System.out.println("-------------------- ------- ----- ----------");
        System.out.printf( "%-20s %7.2f %5d %10.2f\n", "Basic Rate", DAILY_RATE, numberOfDays, subTotal);
        if(driverAge < MINIMUM_AGE)
            System.out.printf("%-20s %5.0f %% %5d %10.2f\n", "Age Surcharge", SURCHARGE * 100, numberOfDays, surcharge);
        if(hasTollTag)
            System.out.printf("%-20s %7.2f %5d %10.2f\n", "Toll Tag", TOLL_RATE, numberOfDays, tollCost);
        if(hasGps)
            System.out.printf("%-20s %7.2f %5d %10.2f\n", "GPS", GPS_RATE, numberOfDays, gpsCost);
        if(hasRoadsideAssitance)
            System.out.printf("%-20s %7.2f %5d %10.2f\n", "Roadside Assistance", ROADSIDE_RATE, numberOfDays, roadsideCost);
        System.out.println("-------------------- ------- ----- ----------");
        System.out.printf( "%-34s $ %8.2f\n", "Total", totalCost);
    }
}