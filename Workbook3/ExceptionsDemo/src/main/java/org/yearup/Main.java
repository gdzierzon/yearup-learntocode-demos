package org.yearup;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int one = scanner.nextInt();
        System.out.print("Enter another number: ");
        int two = scanner.nextInt();

        // use if statements for things that are IN your control
        if(two == 0)
        {
            System.out.println("The 2nd number CANNOT be a 0!");
        }
        else
        {
            int answer = one / two;
            System.out.println(answer);
        }

        try
        {
            // use try blocks for things that are out of your control
            // user input
            // open a file
            // database
        }
        catch(Exception ex)
        {
            System.out.println("An error has occurred");
        }
        finally
        {

        }
    }
}