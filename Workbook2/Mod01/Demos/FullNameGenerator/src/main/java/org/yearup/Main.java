package org.yearup;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        String firstName;
        String middleName;
        String lastName;
        String suffix;
        String fullName = "";

        // get all user input
        System.out.println("Please Enter your name");
        System.out.print("First name: ");
        firstName = input.nextLine().strip();
        System.out.print("Middle name: ");
        middleName = input.nextLine().strip();
        System.out.print("Last name: ");
        lastName = input.nextLine().strip();
        System.out.print("Suffix: ");
        suffix = input.nextLine().strip();

        // format full name
        if(firstName.length() > 0)fullName = firstName + " ";
        if(middleName.length() > 0)
        {
            char middle = middleName.toUpperCase().charAt(0);
            fullName += middle + ". ";
        }
        if(lastName.length() > 0) fullName += lastName;
        if(suffix.length() > 0) fullName += ", " + suffix;

        if(fullName.endsWith(" "))
        {
            int lastIndex = fullName.length() - 1;
            fullName = fullName.substring(0, lastIndex);
        }
        fullName = fullName.replace(" , ", ", ");

        System.out.println(fullName);


    }
}