package org.yearup.datastorage;

import org.yearup.models.Dealership;
import org.yearup.models.Vehicle;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DealershipFileManager
{
    public Dealership getDealership()
    {
        Dealership dealership = null;

        try(FileReader reader = new FileReader("inventory.csv");
            Scanner scanner = new Scanner(reader)
        )
        {
            String line = scanner.nextLine();
            String[] columns = line.split("\\|");
            String name = columns[0];
            String address = columns[1];
            String phone = columns[2];

            // load cars
            ArrayList<Vehicle> inventory = new ArrayList<>();
            while (scanner.hasNext())
            {
                line = scanner.nextLine();
                columns = line.split("\\|");
                String vin = columns[0];
                int year = Integer.parseInt(columns[1]);
                String make = columns[2];
                String model = columns[3];
                String type = columns[4];
                String color = columns[5];
                int miles = Integer.parseInt(columns[6]);
                double price = Double.parseDouble(columns[7]);

                Vehicle vehicle = new Vehicle(vin,year,make, model,type,color,miles, price);
                inventory.add(vehicle);

            }

            dealership = new Dealership(name, address, phone, inventory);
        }
        catch (IOException e)
        {
        }
        return dealership;
    }

    public void saveDealership(Dealership dealership)
    {

    }
}
