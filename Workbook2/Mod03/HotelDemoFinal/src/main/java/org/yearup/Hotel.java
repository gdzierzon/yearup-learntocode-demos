package org.yearup;

public class Hotel
{
    private int id;
    private String name;
    private String state;
    private double price;

    public Hotel(int id, String name, String state, double price)
    {
        this.id = id;
        this.name = name;
        this.state = state;
        this.price = price;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
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
