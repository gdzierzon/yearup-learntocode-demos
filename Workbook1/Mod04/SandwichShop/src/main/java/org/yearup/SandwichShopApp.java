package org.yearup;

import java.util.Scanner;

public class SandwichShopApp
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);

        System.out.println("What size of sandwich would you like?");
        System.out.println(" 1) Regular");
        System.out.println(" 2) Large");
        System.out.print("Make a selection: ");
        int size = userInput.nextInt();
        userInput.nextLine();

        System.out.print("Would you like your sandwich loaded? (y/n) ");
        boolean isLoaded = userInput.nextLine().equalsIgnoreCase("y");

        System.out.println();
        System.out.print("Enter your age: ");
        int age = userInput.nextInt();
        userInput.nextLine();

        String sandwich = size == 1 ? "Regular" : "Large";
        double price = size == 1 ? 5.45 : 8.95;
        if(isLoaded)
        {
            price += size == 1 ? 1 : 1.75;
        }

        double discount = 0;
        if(age < 18) discount = price * .1;
        else if(age > 64) discount = price * .2;

        double total = price - discount;

        System.out.println();
        System.out.println("Receipt");
        System.out.println("-------------");
        System.out.println(sandwich + " Sandwich");
        if(isLoaded)
        {
            System.out.println("      (Loaded)");
        }
        System.out.println("Price:    " + price);
        System.out.println("Discount: " + discount);
        System.out.println("Total:    " + total);
    }
}