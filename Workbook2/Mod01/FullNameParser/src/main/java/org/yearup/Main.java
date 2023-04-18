package org.yearup;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        String fullName = "";
        String firstName = "";
        String middleName = "";
        String lastName = "";

        // get user input
        System.out.println();
        System.out.print("Please Enter your name: ");
        fullName = input.nextLine().strip();

        // format variables
        int index = fullName.indexOf(" ");
        if(index > 0)
        {
            firstName = fullName.substring(0, index);
            fullName = fullName.substring(index + 1);
        }
        else
        {
            firstName = fullName;
            fullName = "";
        }

        index = fullName.indexOf(" ");
        if(index > 0)
        {
            middleName = fullName.substring(0, index);
            lastName = fullName.substring(index + 1);
        }
        else
        {
            middleName = "";
            lastName = fullName;
        }

        System.out.println();
        System.out.println("First name: " + firstName);
        System.out.println("Middle name: " + middleName);
        System.out.println("Last name: " + lastName);
    }
}