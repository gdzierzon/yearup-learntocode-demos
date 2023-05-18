package org.yearup.shapes;

public class Square extends Rectangle
{
    public Square(double side)
    {
        super(side, side);
    }

    @Override
    public void draw()
    {
        System.out.println("Drawing Square");
        System.out.println("Side: " + getSide());
    }
}
