package org.yearup;

public class Cellist extends Musician
{
    @Override
    public void perform()
    {
        System.out.println("Cellist is playing the cello");
    }

    @Override
    public String toString()
    {
        return "Cellist";
    }
}
