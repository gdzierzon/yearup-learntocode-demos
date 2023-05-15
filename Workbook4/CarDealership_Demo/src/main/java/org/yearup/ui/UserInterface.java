package org.yearup.ui;

import org.yearup.datastorage.DealershipFileManager;
import org.yearup.models.Dealership;
import org.yearup.models.Vehicle;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface
{
    Scanner userInput = new Scanner(System.in);
    private Dealership dealership;

    public UserInterface()
    {
        DealershipFileManager fileManager = new DealershipFileManager();
        dealership = fileManager.getDealership();
    }

    public void run()
    {

        while(true)
        {
            displayHomeScreen();
            int selection = getSelection("Make yer choice");

            switch (selection)
            {
                case 1: // search by year
                    processGetByYear();
                    break;
                case 2:
                    break;
                case 99: // exit
                    return;
                default:
                    System.out.println("Not a valid selection.");
            }

        }

    }

    public int getSelection(String message)
    {
        System.out.print(message + ": ");
        return Integer.parseInt(userInput.nextLine().strip());
    }

    public void displayHomeScreen()
    {
        System.out.println();
        System.out.println("What do you want to do?");
        System.out.println(" 1) search by year");
        System.out.println(" 2) search by price");
        System.out.println(" 99) exit");

    }

    private void displaySearchResults(ArrayList<Vehicle> results)
    {
        for(Vehicle vehicle: results)
        {
            System.out.printf("%-5d %-15s %-15s %-8s %-7d $ %.2f\n" ,vehicle.getYear(), vehicle.getMake(), vehicle.getModel(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());
        }
    }

    public void processGetByPrice()
    {

    }

    public void processGetByMakeModel()
    {

    }

    public void processGetByYear()
    {
        // declare variables
        int min;
        int max;

        // ask the user for min year
        System.out.print("Enter the lowest year: ");
        min = userInput.nextInt();
        // ask the user for the max year
        System.out.print("Enter the highest year: ");
        max = userInput.nextInt();
        userInput.nextLine();

        // get all cars from the dealership
        ArrayList<Vehicle> results = dealership.getByYear(min, max);

        // display the vehicles
        if(results.size() ==0)
        {
            System.out.println("No vehicles found");
        }
        else
        {
            System.out.println("Search by Year: " + min + " - " + max);
            System.out.println("------------------------------------");

            displaySearchResults(results);
        }
    }

    public void processGetByColor()
    {

    }

    public void processGetByMileage()
    {

    }

    public void processGetByVehicleType()
    {

    }

    public void processGetAllVehicles()
    {

    }

    public void processAddVehicle()
    {

    }

    public void processDeleteVehicle()
    {

    }
}
