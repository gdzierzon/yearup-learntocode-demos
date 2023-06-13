package org.yearup.models;

import java.math.BigDecimal;

// DTO - Data Transfer Object
// POJO - Plain Old Java Object
// Java Bean -
//      - private variables
//      - getter and setter for each varaible
//      - must have a parameterless constructor
public class Country
{
    private String code;
    private String name;
    private String continent;
    private String region;
    private double surfaceArea;
    private Integer independenceYear;
    private int population;
    private Double lifeExpectancy;
    private BigDecimal gnp;
    private BigDecimal gnpOld;
    private String localName;
    private String formOfGovernment;
    private String headOfState;
    private int capitalCityId;
    private String code2Characters;

    public Country()
    {
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getContinent()
    {
        return continent;
    }

    public void setContinent(String continent)
    {
        this.continent = continent;
    }

    public String getRegion()
    {
        return region;
    }

    public void setRegion(String region)
    {
        this.region = region;
    }

    public double getSurfaceArea()
    {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea)
    {
        this.surfaceArea = surfaceArea;
    }

    public Integer getIndependenceYear()
    {
        return independenceYear;
    }

    public void setIndependenceYear(Integer independenceYear)
    {
        this.independenceYear = independenceYear;
    }

    public int getPopulation()
    {
        return population;
    }

    public void setPopulation(int population)
    {
        this.population = population;
    }

    public double getLifeExpectancy()
    {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(double lifeExpectancy)
    {
        this.lifeExpectancy = lifeExpectancy;
    }

    public BigDecimal getGnp()
    {
        return gnp;
    }

    public void setGnp(BigDecimal gnp)
    {
        this.gnp = gnp;
    }

    public BigDecimal getGnpOld()
    {
        return gnpOld;
    }

    public void setGnpOld(BigDecimal gnpOld)
    {
        this.gnpOld = gnpOld;
    }

    public String getLocalName()
    {
        return localName;
    }

    public void setLocalName(String localName)
    {
        this.localName = localName;
    }

    public String getFormOfGovernment()
    {
        return formOfGovernment;
    }

    public void setFormOfGovernment(String formOfGovernment)
    {
        this.formOfGovernment = formOfGovernment;
    }

    public String getHeadOfState()
    {
        return headOfState;
    }

    public void setHeadOfState(String headOfState)
    {
        this.headOfState = headOfState;
    }

    public int getCapitalCityId()
    {
        return capitalCityId;
    }

    public void setCapitalCityId(int capitalCityId)
    {
        this.capitalCityId = capitalCityId;
    }

    public String getCode2Characters()
    {
        return code2Characters;
    }

    public void setCode2Characters(String code2Characters)
    {
        this.code2Characters = code2Characters;
    }
}
