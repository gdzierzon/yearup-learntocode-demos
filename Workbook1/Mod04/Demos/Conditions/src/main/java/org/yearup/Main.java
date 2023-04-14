package org.yearup;

import java.util.Scanner;

public class Main
{
    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args)
    {
        String shape;

        System.out.print("What shape do you want to analyze (circle, square, rectangle, triangle)? ");
        shape = userInput.nextLine();

        System.out.println();

        if(shape.equalsIgnoreCase("circle"))
        {
            calculateCircle();
        }
        else if(shape.equalsIgnoreCase("square"))
        {
            calculateSquare();
        }
        else if(shape.equalsIgnoreCase("rectangle"))
        {
            calculateRectangle();
        }
        else if(shape.equalsIgnoreCase("triangle"))
        {
            calculateTriangle();
        }
        else
        {
            System.out.println("Please select a valid shape \n    circle\n    square\n    rectangle\n    triangle");
            System.out.println();
            System.out.println("Good Bye");
            System.exit(1);
        }
    }

    public static void calculateCircle()
    {
        double radius;
        double area;
        double circumference;

        System.out.print("Enter the circle radius: ");
        radius = userInput.nextDouble();

        area = Math.PI * Math.pow(radius, 2);
        circumference = 2 * Math.PI * radius;

        System.out.printf("A Circle with a radius of %.2f has ...\n", radius);
        System.out.printf("... an area of %.2f \n", area);
        System.out.printf("... a circumference of %.2f \n", circumference);
    }

    public static void calculateSquare()
    {
        double length;
        double area;
        double perimeter;

        System.out.print("Enter the length of each side: ");
        length = userInput.nextDouble();

        area = Math.pow(length, 2);
        perimeter = length * 4;

        System.out.printf("A Square with a side length of %.2f has ...\n", length);
        System.out.printf("... an area of %.2f \n", area);
        System.out.printf("... a perimeter of %.2f \n", perimeter);
    }

    public static void calculateRectangle()
    {
        double width;
        double length;
        double area;
        double perimeter;

        System.out.print("Enter the width of the rectangle: ");
        width = userInput.nextDouble();

        System.out.print("Enter the length of the rectangle: ");
        length = userInput.nextDouble();

        area = length * width;
        perimeter = (length * 2) + (width * 2);

        System.out.printf("A Rectangle with a width of %.2f and a length of %.2f has ...\n", width, length);
        System.out.printf("... an area of %.2f \n", area);
        System.out.printf("... a perimeter of %.2f \n", perimeter);
    }

    public static void calculateTriangle()
    {
        double base;
        double height;
        double area;
        double perimeter;

        System.out.print("Enter the base of the triangle: ");
        base = userInput.nextDouble();

        System.out.print("Enter the height of the triangle: ");
        height = userInput.nextDouble();

        area = (height * base) / 2;

        // calculate the hypotenuse (pythagorean theorem => a^2 + b^2 = c^2)
        double a2 = Math.pow(base,2);
        double b2 = Math.pow(height,2);
        double c2 = a2 + b2;
        double hypotenuse = Math.sqrt(c2);
        perimeter = height + base + hypotenuse;

        System.out.printf("A Triangle with a base of %.2f and a height of %.2f has ...\n", base, height);
        System.out.printf("... an area of %.2f \n", area);
        System.out.printf("... a hypotenuse of %.2f \n", hypotenuse);
        System.out.printf("... a perimeter of %.2f \n", perimeter);
    }
}