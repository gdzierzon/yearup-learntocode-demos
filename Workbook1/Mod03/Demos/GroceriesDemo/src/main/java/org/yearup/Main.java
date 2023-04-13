package org.yearup;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner myScanner = new Scanner(System.in);

        // 1. variables
        String name = "";
        // variables for price
        double priceApples = .33;
        double priceBread = 2.99;
        // variables for quantity
        int numberOfApples = 0;
        int numberOfLoaves = 0;
        // totals
        double applesTotal;
        double breadTotal;
        double total;

        // 1-a - get User Information
        System.out.print("What is your name? ");
        name = myScanner.nextLine();

        System.out.print("How many apples would you like? ");
        // option 1 read as a String and convert to int
        String tempApples = myScanner.nextLine();
        numberOfApples = Integer.parseInt(tempApples);

        System.out.print("How many loaves of bread? ");
        // option 2 - read as an integer
        numberOfLoaves = myScanner.nextInt();
        myScanner.nextLine(); // "eat" the enter key

        // 2. work - calculate the cost
        applesTotal = priceApples * numberOfApples;
        breadTotal = priceBread * numberOfLoaves;
        total = applesTotal + breadTotal;

        // 3. output display the receipt

        System.out.println("Customer: " + name);
        System.out.println("Product  Qty    Price     Line Total");
        System.out.println("-------------------------------------");

//        String lineItem = String.format("Apples %d @ $ %.2f - $ %.2f", numberOfApples, priceApples, applesTotal);
//        System.out.println(lineItem);
        System.out.printf("Apples %5d    $ %-7.2f $ %.2f\n", numberOfApples, priceApples, applesTotal);
        System.out.printf("Bread  %5d    $ %-7.2f $ %.2f\n", numberOfLoaves, priceBread, breadTotal);

//        System.out.println("Apples " + numberOfApples + " @ $" + priceApples + "  $" + applesTotal);
//        System.out.println("Bread " + numberOfLoaves + " @ $" + priceBread + "  $" + breadTotal);
        System.out.println("-------------------------------------");
        System.out.printf( "Total                     $ %.2f \n",  total);

    }
}