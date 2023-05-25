package org.example.painters;

import org.example.canvases.Turtle;
import org.example.canvases.World;

import java.awt.*;

public class SquarePainter
{
    private Turtle turtle;

    public SquarePainter(World world, Color color, double width)
    {
        turtle = new Turtle(world,0,0);
        turtle.setColor(color);
        turtle.setPenWidth(width);
        turtle.setDelay(0.02);
    }

    public void paintSquare(double side, double x, double y)
    {
        turtle.setHeading(0);
        turtle.penUp();
        turtle.goTo(x, y);

        turtle.penDown();
        for (int i = 0; i < 4; i++)
        {
            turtle.forward(side);
            turtle.turnRight(90);
        }
        turtle.penUp();
    }

    public void fillSquare(double side, double x, double y)
    {
        turtle.setHeading(0);
        turtle.penUp();
        turtle.goTo(x, y);
        int width = (int)turtle.getPenWidth();
        Color color = turtle.getColor();
        turtle.setColor(Color.PINK);

        for (int i = 0; i < side; i+= width)
        {
            turtle.penDown();
            turtle.forward(side);

            turtle.penUp();
            turtle.turnRight(90);
            turtle.forward(width);
            turtle.turnRight(90);
            turtle.forward(side);
            turtle.turnRight(180);
        }
        turtle.setColor(color);
    }

//    public
}
