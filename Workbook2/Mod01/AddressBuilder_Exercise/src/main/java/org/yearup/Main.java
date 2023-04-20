package org.yearup;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);

        StringBuilder builder = new StringBuilder();
        String input;

        System.out.println();
        System.out.println("Please provide the following information:");

        System.out.print("Full name: ");
        input = userInput.nextLine().strip();
        builder.append(input).append("\n\n");


        builder.append("Billing Address:");
        System.out.print("Billing Street: ");
        input = userInput.nextLine().strip();
        builder.append(input).append("\n");

        System.out.print("Billing City: ");
        input = userInput.nextLine().strip();
        builder.append(input).append(", ");

        System.out.print("Billing State: ");
        input = userInput.nextLine().strip();
        builder.append(input).append(" ");

        System.out.print("Billing Zip: ");
        input = userInput.nextLine().strip();
        builder.append(input).append("\n\n");


        builder.append("Shipping Address:");
        System.out.print("Shipping Street: ");
        input = userInput.nextLine().strip();
        builder.append(input).append("\n");

        System.out.print("Shipping City: ");
        input = userInput.nextLine().strip();
        builder.append(input).append(", ");

        System.out.print("Shipping State: ");
        input = userInput.nextLine().strip();
        builder.append(input).append(" ");

        System.out.print("Shipping Zip: ");
        input = userInput.nextLine().strip();
        builder.append(input).append("\n\n");

        // output formatted info
        System.out.println();
        System.out.println(builder);
    }
}