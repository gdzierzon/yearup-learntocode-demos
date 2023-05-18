package org.yearup.shapes;

public class Rectangle extends Shape
{
    private int width;
    private int length;

    public Rectangle(int width, int length)
    {
        this.width = width;
        this.length = length;
    }

    public int getWidth()
    {
        return width;
    }

    public int getLength()
    {
        return length;
    }

    @Override
    public double getArea()
    {
        return width * length;
    }

    @Override
    public double getPerimeter()
    {
        return width * 2 + length * 2;
    }

    @Override
    public void draw()
    {
        System.out.println("Drawing Rectangle");
    }
}
