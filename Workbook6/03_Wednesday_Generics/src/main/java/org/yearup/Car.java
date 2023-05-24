package org.yearup;

public class Car
{
    private final String make;
    private final String model;

    public Car(String make, String model)
    {
        this.make = make;
        this.model = model;
    }

    @Override
    public String toString()
    {
        return make + " - " + model;
    }
}
