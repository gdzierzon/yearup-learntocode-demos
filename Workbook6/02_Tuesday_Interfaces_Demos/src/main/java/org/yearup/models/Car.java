package org.yearup.models;

public class Car implements Movable
{
    @Override
    public Point move(int x, int y)
    {
        System.out.println("Car driving to (" + x + "," + y +")");
        return null;
    }

    @Override
    public void goHome()
    {
        System.out.println("Car driving home");
    }
}
