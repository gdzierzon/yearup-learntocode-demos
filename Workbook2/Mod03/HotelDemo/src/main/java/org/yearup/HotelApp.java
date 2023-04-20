package org.yearup;

import java.util.Scanner;

public class HotelApp
{
    static Scanner scanner = new Scanner(System.in);

    static Hotel[] hotels;

    // manages the flow of the application
    public static void main(String[] args)
    {
        // add products to the array before running the program
        createInventory();

        while(true)
        {
            int selection = displayHomeScreen();

            if(selection == 1)
            {
                // display all hotels
                displayAllHotels();
            }
            else if(selection == 2)
            {
                // search by state
                searchByState();
            }
            else if(selection == 3)
            {
                System.out.println();
                System.out.println("Goodbye...");

                // break out of loop
                // and end the program
                break;
            }
            else
            {
                System.out.println();
                System.out.println("You selected an invalid option.");
            }
        }

    }

    // creating the hotels array
    private static void createInventory()
    {
        hotels = new Hotel[10];
        hotels[0] = new Hotel(1,"Hampton Inn - Dallas","TX",109.99);
        hotels[1] = new Hotel(2,"Hampton Inn - Houston","TX",119.99);
        hotels[2] = new Hotel(3,"Hampton Inn - Los Angeles","CA",110.99);
        hotels[3] = new Hotel(4,"Holiday Inn - Salt Lake City","UT",99.99);
        hotels[4] = new Hotel(5,"Holiday Inn - San Diego","UT",109.99);
        hotels[5] = new Hotel(6,"Courtyard - Austin","TX",129.99);
        hotels[6] = new Hotel(7,"Courtyard - Boise","ID",109.99);
        hotels[7] = new Hotel(8,"Residence Inn - Phoenix","AZ",159.99);
        hotels[8] = new Hotel(9,"Residence Inn - Los Angeles","CA",159.99);
        hotels[9] = new Hotel(10,"Residence Inn - San Diego","CA",179.99);
    }

    // show home screen and get the user option
    public static int displayHomeScreen()
    {
        System.out.println();
        System.out.println("What do you want to do? ");
        System.out.println("1) List all Hotels");
        System.out.println("2) Search Hotels by State");
        System.out.println("3) Exit");
        System.out.print("Enter your option: ");
        int selection = scanner.nextInt();
        scanner.nextLine();

        return selection;
    }

    // show list of all hotels
    public static void displayAllHotels()
    {
        System.out.println();
        System.out.println("All Hotels");
        System.out.println("---------------------");
        for (int i = 0; i < hotels.length; i++)
        {
            Hotel hotel = hotels[i];
            System.out.println(hotel.getName());
        }
    }

    // get user input for state, and display only hotels in that state
    public static void searchByState()
    {
        System.out.println();
        System.out.print("Enter the state abbreviation: ");
        String state = scanner.nextLine().strip();

        System.out.println("All Hotels in: " + state);
        System.out.println("---------------------");
        for (int i = 0; i < hotels.length; i++)
        {
            Hotel hotel = hotels[i];
            // only include hotels in the state that the user entered
            if(state.equalsIgnoreCase(hotel.getState()))
            {
                System.out.println(hotel.getName() + " -- " + hotel.getState());
            }
        }
    }
}