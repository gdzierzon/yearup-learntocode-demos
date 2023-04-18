package org.yearup;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);

        String input;
        String suffix = "";
        String fullName;
        String firstName;
        String middleName = "";
        String lastName;

        // get user input
        System.out.println();
        System.out.print("Enter your full name: ");
        input = userInput.nextLine();

        // split the fullName from the suffix
        String[] parts = input.split(", ");
        fullName = parts[0];

        if(parts.length > 1)
        {
            suffix = parts[1];
        }

        // split the full name into parts
        String[] nameParts = fullName.split(" ");

        if(nameParts.length > 2)
        {
            firstName = nameParts[0];
            middleName = nameParts[1];
            lastName = nameParts[2];
        }
        else
        {
            firstName = nameParts[0];
            lastName = nameParts[1];
        }

        System.out.println();
        System.out.printf("First name: %s \n", firstName);
        System.out.printf("Middle name: %s \n", middleName);
        System.out.printf("Last name: %s \n", lastName);
        System.out.printf("Suffix: %s \n", suffix);
    }
}