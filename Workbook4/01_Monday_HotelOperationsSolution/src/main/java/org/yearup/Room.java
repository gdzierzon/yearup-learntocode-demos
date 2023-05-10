package org.yearup;

public class Room
{
    private static final String KING = "King";

    // private variables
    private int numberOfBeds;
    private double price;
    private boolean isOccupied;
    private boolean isDirty;

    // constructors
    public Room()
    {
    }

    public Room(int numberOfBeds, double price, boolean isOccupied, boolean isDirty)
    {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.isOccupied = isOccupied;
        this.isDirty = isDirty;
    }

    // getters / setters
    public int getNumberOfBeds()
    {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds)
    {
        this.numberOfBeds = numberOfBeds;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public boolean isOccupied()
    {
        return isOccupied;
    }

    public void setOccupied(boolean occupied)
    {
        isOccupied = occupied;
    }

    public boolean isDirty()
    {
        return isDirty;
    }

    public void setDirty(boolean dirty)
    {
        isDirty = dirty;
    }

    public boolean isAvailable()
    {
        return !isDirty && !isOccupied;
    }

    // methods
    public void checkIn()
    {
        isOccupied = true;
        isDirty = true;
    }

    public void checkOut()
    {
        isOccupied = false;
    }

    public void cleanroom()
    {
        isDirty = false;
    }
}
