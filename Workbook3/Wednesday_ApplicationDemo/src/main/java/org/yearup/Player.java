package org.yearup;

public class Player
{
    private String name;
    private int overallRating;
    private int threeRating;
    private int dunkRating;

    public Player()
    {
    }

    public Player(String name, int overallRating, int threeRating, int dunkRating)
    {
        this.name = name;
        this.overallRating = overallRating;
        this.threeRating = threeRating;
        this.dunkRating = dunkRating;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getOverallRating()
    {
        return overallRating;
    }

    public void setOverallRating(int overallRating)
    {
        this.overallRating = overallRating;
    }

    public int getThreeRating()
    {
        return threeRating;
    }

    public void setThreeRating(int threeRating)
    {
        this.threeRating = threeRating;
    }

    public int getDunkRating()
    {
        return dunkRating;
    }

    public void setDunkRating(int dunkRating)
    {
        this.dunkRating = dunkRating;
    }
}

