package org.yearup;

import java.util.Scanner;

public class WhileLoop
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);

        String goAgain = "y";

//        System.out.print("Do you want to play a game (y/n)? ");
//        goAgain = userInput.nextLine();

        while(goAgain.equalsIgnoreCase("y"))
        {
            System.out.println();
            System.out.println("Welcome to our game...");

            System.out.print("Do you want to play again (y/n)? ");
            goAgain = userInput.nextLine();
        }

        System.out.println();
        System.out.println("Good bye");

    }
}