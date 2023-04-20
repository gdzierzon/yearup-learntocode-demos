package org.yearup;

public class Hotel
{
    private String name;
    private int rating;
    private double price;

    public Hotel(String name, int rating, double price)
    {
        this.name = name;
        this.rating = rating;
        this.price = price;
    }

    public Hotel()
    {
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getRating()
    {
        return rating;
    }

    public void setRating(int rating)
    {
        this.rating = rating;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
}
