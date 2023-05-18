package org.yearup.application;

import org.yearup.shapes.Shape;

import java.util.ArrayList;

public class ShapesApp
{
    private ArrayList<Shape> shapes;

    public ShapesApp()
    {
        ShapeFileManager manager = new ShapeFileManager();
        shapes = manager.loadShapes("data.csv");
    }

    public void run()
    {
        for (Shape shape: shapes)
        {
            display(shape);
        }
    }

    public void display(Shape shape)
    {
        shape.draw();
        System.out.println("-----------------------------------");
        System.out.println("Perimeter: " + shape.getPerimeter());
        System.out.println("Area:      " + shape.getArea());
        System.out.println();
    }

}
