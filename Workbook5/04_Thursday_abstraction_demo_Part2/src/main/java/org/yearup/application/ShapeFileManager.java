package org.yearup.application;

import org.yearup.shapes.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ShapeFileManager
{
    public ArrayList<Shape> loadShapes(String filePath)
    {
        ArrayList<Shape> shapes = new ArrayList<>();

        try(FileReader reader = new FileReader(filePath);
            Scanner scanner = new Scanner(reader);
        )
        {
            while (scanner.hasNext())
            {
                String line = scanner.nextLine();
                String[] columns = line.split("\\|");

                String type = columns[0].toLowerCase();
                double base= Double.parseDouble(columns[1]);
                double height;
                double side;

                switch (type)
                {
                    case "circle":
                        shapes.add(new Circle(base));
                        break;
                    case "triangle":
                        shapes.add(new EquilateralTriangle(base));
                        break;
                    case "parallelogram":
                        height= Double.parseDouble(columns[2]);
                        side= Double.parseDouble(columns[3]);
                        shapes.add(new Parallelogram(base, height, side));
                        break;
                    case "rectangle":
                        height= Double.parseDouble(columns[2]);
                        shapes.add(new Rectangle(base, height));
                        break;
                    case "square":
                        shapes.add(new Square(base));
                        break;
                }
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        return shapes;
    }
}
