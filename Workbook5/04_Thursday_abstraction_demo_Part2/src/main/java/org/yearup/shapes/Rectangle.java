package org.yearup.shapes;

public class Rectangle extends Parallelogram
{

    public Rectangle(double width, double length)
    {
        super(width, length, length);
    }

    @Override
    public void draw()
    {
        System.out.println("Drawing Rectangle");
        System.out.println("Width:  " + getBase());
        System.out.println("Length: " + getHeight());
    }
}
