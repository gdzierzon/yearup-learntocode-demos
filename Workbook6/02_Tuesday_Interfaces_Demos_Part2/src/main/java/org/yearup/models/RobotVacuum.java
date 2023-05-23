package org.yearup.models;

public class RobotVacuum implements Movable, Cleaner
{
    private Point location = new Point(0,0);

    public RobotVacuum()
    {
        Movable.super.print();
    }

    @Override
    public Point move(int x, int y)
    {
        int currentX = location.getX();
        int currentY = location.getY();
        location.setX(currentX + x);
        location.setY(currentY + y);

        System.out.println("Moving to (" + location.getX() + "," + location.getY() + ")");

        return location;
    }

    @Override
    public void goHome()
    {
        System.out.println("going home");
        location = new Point(0,0);
    }

    @Override
    public void clean()
    {
        System.out.println("Vacuum is cleaning");

    }

    @Override
    public void print()
    {
        System.out.println("Overriden print in Robot Vacuum");
        Movable.super.print();
        Cleaner.super.print();
    }

}
