package org.yearup.models;

public class City
{
    private int id;
    private String name;
    private String countryCode;
    private String district;
    private double population;

    public City()
    {
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

    public String getCountryCode()
    {
        return countryCode;
    }

    public void setCountryCode(String countryCode)
    {
        this.countryCode = countryCode;
    }

    public String getDistrict()
    {
        return district;
    }

    public void setDistrict(String district)
    {
        this.district = district;
    }

    public double getPopulation()
    {
        return population;
    }

    public void setPopulation(double population)
    {
        this.population = population;
    }
}
