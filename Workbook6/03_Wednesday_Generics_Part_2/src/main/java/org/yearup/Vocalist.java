package org.yearup;

public class Vocalist extends Musician
{
    @Override
    public void perform()
    {
        System.out.println("Vocalist is singing");
    }

    @Override
    public String toString()
    {
        return "Vocalist";
    }
}
