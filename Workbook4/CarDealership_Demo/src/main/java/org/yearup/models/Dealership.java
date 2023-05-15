package org.yearup.models;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Dealership
{
    private String name;
    private String address;
    private String phone;

    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone)
    {
        this.name = name;
        this.address = address;
        this.phone = phone;

        this.inventory = new ArrayList<>();
    }

    public Dealership(String name, String address, String phone, ArrayList<Vehicle> inventory)
    {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = inventory;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public ArrayList<Vehicle> getByPrice(double min, double max)
    {
        return new ArrayList<>();
    }

    public ArrayList<Vehicle> getByMakeModel(String make, String model)
    {
        return new ArrayList<>();
    }

    public ArrayList<Vehicle> getByYear(int min, int max)
    {
        ArrayList<Vehicle> searchResults = new ArrayList<>();

        for(Vehicle vehicle: inventory)
        {
            if(vehicle.getYear() >= min && vehicle.getYear() <= max)
            {
                searchResults.add(vehicle);
            }
        }

        return searchResults;
    }

    public ArrayList<Vehicle> getByColor(String color)
    {
        return new ArrayList<>();
    }

    public ArrayList<Vehicle> getByMileage(int min, int max)
    {
        return new ArrayList<>();
    }

    public ArrayList<Vehicle> getByType(String type)
    {
        return new ArrayList<>();
    }

    public ArrayList<Vehicle> getAllVehicles()
    {
        return inventory;
    }

    public void addVehicle(Vehicle vehicle)
    {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle)
    {
        inventory.remove(vehicle);
    }
}
