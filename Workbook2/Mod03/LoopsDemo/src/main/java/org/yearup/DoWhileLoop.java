package org.yearup;

import java.util.Scanner;

public class DoWhileLoop
{
    public static void main(String[] args)
    {

        Scanner userInput = new Scanner(System.in);

        String goAgain;


        // do while guarantees at least 1 iteration
        do
        {
            System.out.println();
            System.out.println("Welcome to our game...");

            System.out.print("Do you want to play again (y/n)? ");
            goAgain = userInput.nextLine();

        }while(goAgain.equalsIgnoreCase("y"));

        System.out.println();
        System.out.println("Good bye");
    }
}
