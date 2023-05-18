package org.yearup.shapes;

public class EquilateralTriangle extends Shape
{
    private double side;

    public EquilateralTriangle(double base)
    {
        this.side = base;
    }

    public double getSide()
    {
        return side;
    }

    public double getHeight()
    {
        // a2 + b2 = c2
        double a = side / 2;
        double c = side;
        double b2 = Math.pow(c, 2) - Math.pow(a, 2);
        return Math.sqrt(b2);
    }

    @Override
    public double getArea()
    {
        return (side * getHeight()) / 2;
    }

    @Override
    public double getPerimeter()
    {
        return side * 3;
    }

    @Override
    public void draw()
    {
        System.out.println("Drawing equilateral triangle");
        System.out.println("Side: " + side);
    }
}
