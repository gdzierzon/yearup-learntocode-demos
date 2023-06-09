package org.yearup.shapes;

public class Triangle extends Shape
{
    private double base;
    private double height;

    public Triangle(double base, double height)
    {
        this.base = base;
        this.height = height;
    }

    public double getBase()
    {
        return base;
    }

    public double getHeight()
    {
        return height;
    }

    @Override
    public double getArea()
    {
        return (base * height) / 2;
    }

    @Override
    public double getPerimeter()
    {
        return base * 3;
    }

    @Override
    public void draw()
    {
        System.out.println("Drawing triangle");
    }
}
