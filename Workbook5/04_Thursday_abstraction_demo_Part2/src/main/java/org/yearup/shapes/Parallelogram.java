package org.yearup.shapes;

public class Parallelogram extends Shape
{
    private double base;
    private double height;
    private double side;

    public Parallelogram(double base, double height, double side)
    {
        this.base = base;
        this.height = height;
        this.side = side;
    }

    public double getBase()
    {
        return base;
    }

    public void setBase(double base)
    {
        this.base = base;
    }

    public double getHeight()
    {
        return height;
    }

    public void setHeight(double height)
    {
        this.height = height;
    }

    public double getSide()
    {
        return side;
    }

    public void setSide(double side)
    {
        this.side = side;
    }

    @Override
    public double getArea()
    {
        return base * height;
    }

    @Override
    public double getPerimeter()
    {
        return base * 2 + side * 2;
    }

    @Override
    public void draw()
    {
        System.out.println("Drawing parallelogram");
        System.out.println("Base:   " + base);
        System.out.println("Side:   " + side);
        System.out.println("Height: " + height);
    }
}
