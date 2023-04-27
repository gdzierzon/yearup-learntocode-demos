package org.yearup.models;

public class Hero
{
    private String name;
    private String citizenName;
    private String power;

    public Hero(String name, String citizenName, String power)
    {
        this.name = name;
        this.citizenName = citizenName;
        this.power = power;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getCitizenName()
    {
        return citizenName;
    }

    public void setCitizenName(String citizenName)
    {
        this.citizenName = citizenName;
    }

    public String getPower()
    {
        return power;
    }

    public void setPower(String power)
    {
        this.power = power;
    }
}
