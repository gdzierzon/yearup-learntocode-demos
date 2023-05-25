package org.example;

import org.example.canvases.Turtle;
import org.example.canvases.World;
import org.example.painters.SquarePainter;

import java.awt.*;

// https://codehs.com/sandbox/apcsa/java-turtle
public class Main
{
    public static void main(String[] args)
    {
        double radius = 100;
        double circumference = 2 * Math.PI * radius;
        double lineLength = circumference / 360;

        System.out.println(radius);
        System.out.println(circumference);
        System.out.println(lineLength);

        World world = new World(500,500);
//        Turtle t = new Turtle(world, 0, 0);
//
//        t.setPenWidth(4);
//        t.setColor(Color.RED);
//        t.setDelay(0.01);

        world.setVisible(true);
//
        var painter = new SquarePainter(world, Color.RED, 8);
        painter.fillSquare(200, -100, 100);
        painter.paintSquare(200, -100, 100);

//        drawLogo(t);
//        drawGrid(t);
//        drawFullCircle(t);
//        drawPie(t);
//        drawSquare(t);


//        t.penUp();
//        t.goTo(-250,250);

//        world.saveAs("circle.png");

//        world.dispose();

    }

    private static void drawSquare(Turtle t)
    {
        t.penUp();
        t.goTo(-100, -100);
        t.setHeading(0);

        t.penDown();
        t.forward(200);
        t.turnLeft(90);
        t.forward(200);
        t.turnLeft(90);
        t.forward(200);
        t.turnLeft(90);
        t.forward(200);
        t.turnLeft(90);
    }

    private static void drawLogo(Turtle t)
    {
        t.penUp();
        t.goTo(-200, 200);
        t.turnLeft(90);
        t.drop("logo.png");

        t.turnRight(90);
        t.goTo(0,0);
        t.penDown();
    }


    public static void drawGrid(Turtle t)
    {
        t.penUp();
        t.goTo(-250, 0);
        t.setHeading(0);
        t.setColor(Color.BLACK);
        t.setPenWidth(6);

        t.penDown();
        t.forward(500);
        t.penUp();

        t.goTo(0, 250);

        t.penDown();
        t.setHeading(90);
        t.forward(500);
        t.penUp();

        t.setPenWidth(.5);
        t.setHeading(90);
        for (int i = -250; i <= 500; i+=25)
        {
            t.penUp();
            t.goTo(i, 250);
            t.penDown();
            t.forward(500);
        }

        t.setHeading(0);
        for (int i = 250; i >= -250; i-= 25)
        {
            t.penUp();
            t.goTo( -250, i);
            t.penDown();
            t.forward(500);
        }

        t.penUp();
        t.goTo(-250, 250);
    }

    public static void drawFullCircle(Turtle t)
    {
        t.penUp();
        t.goTo(0, 0);
        double radius = 100;
        double circumference = 2 * Math.PI * radius;
        double lineLength = circumference / 360;

        t.setPenWidth(3);
        t.setColor(Color.RED);

        // full circle
        t.penUp();
        t.turnRight(90);
        t.forward(radius);
        t.turnLeft(90);
        t.penDown();


        for(int degrees = 360; degrees > 0; degrees--)
        {
            t.forward(lineLength);
            t.turnLeft(1);
        }
    }

    public static void drawPie(Turtle t)
    {
        double radius = 100;
        double circumference = 2 * Math.PI * radius;
        double lineLength = circumference / 360;

        // pie
        t.forward(radius);
        t.turnLeft(90);

        for(int degrees = 270; degrees > 0; degrees--)
        {
            t.forward(lineLength);
            t.turnLeft(1);
        }
        t.turnLeft(90);
        t.forward(radius);

        t.penUp();
        t.turnRight(90);
        t.forward(10);
        t.turnRight(90);
        t.forward(10);

        t.setColor(Color.BLUE);
        t.penDown();
        t.forward(radius);
        t.turnLeft(90);

        for(int degrees = 90; degrees > 0; degrees--)
        {
            t.forward(lineLength);
            t.turnLeft(1);
        }
        t.turnLeft(90);
        t.forward(radius);


    }

}