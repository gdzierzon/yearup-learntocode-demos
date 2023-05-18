package org.yearup.shapes;

public class Circle extends Shape
{
    double radius;

    public Circle(double radius)
    {
        this.radius = radius;
    }

    public double getRadius()
    {
        return radius;
    }

    public void setRadius(double radius)
    {
        this.radius = radius;
    }

    public double getDiameter()
    {
        return radius * 2;
    }

    @Override
    public double getArea()
    {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter()
    {
        return 2 * Math.PI * radius;
    }

    public double getCircumference()
    {
        return getPerimeter();
    }

    @Override
    public void draw()
    {
        System.out.println("Drawing circle");
        System.out.println("Radius:   " + radius);
        System.out.println("Diameter: " + getDiameter());
    }
}
