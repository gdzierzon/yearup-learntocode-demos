package org.yearup.models;

public class Robot implements Movable
{
    private Point position;

    public Robot(Point position)
    {
        this.position = position;
    }

    @Override
    public Point move(int x, int y)
    {
        System.out.println("Robot walking to (" + x + "," + y +")");
        position = new Point(x,y);
        return position;
    }

    @Override
    public void goHome()
    {
        System.out.println("Robot walking to (0,0)");
        position = new Point(0,0);
    }
}
