package org.yearup;

import java.util.Scanner;

public class LoopsReview
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int option = 1;

        while(option == 1)
        {
            System.out.println("Looping...");

            System.out.print("What do you want to do (1 - go again 0 - quit): ");
            option = scanner.nextInt();
        }

        System.out.println();
        while (true)
        {
            System.out.println("Inside infinite loop...");
            System.out.print("What do you want to do (1 - go again 0 - quit): ");
            option = scanner.nextInt();
            scanner.nextLine();
            if(option == 0)
            {
                break;
            }
        }

        System.out.println();
        while (true)
        {
            System.out.print("Name a movie: ");
            String movie = scanner.nextLine();

            if(movie.equalsIgnoreCase("exit"))
            {
                break;
            }
            else if (movie.startsWith("Nightmare"))
            {
                continue;
            }

            System.out.println("Movie: " + movie);
        }

        // do while loop - will always execute at least one time
        do
        {
            System.out.println("Inside do..while loop...");
            System.out.print("What do you want to do (1 - go again 0 - quit): ");
            option = scanner.nextInt();
        }while(option != 0);

        // count up from 1 to  10
        for(int counter = 1; counter <= 10; counter++)
        {
            System.out.println(counter);
        }

        // countdown from 10 to 0
        for(int counter = 10; counter >= 0; counter--)
        {
            System.out.println(counter);
        }
    }
}
