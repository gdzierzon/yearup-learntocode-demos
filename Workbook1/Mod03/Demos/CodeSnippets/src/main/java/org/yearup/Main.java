package org.yearup;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        // create scanner to collect user input
        // Scanner is a type (complex type - that can read data streams)
        // variable name is userInput
        // create a Scanner object that scans keyboard input (System.in)
        Scanner userInput = new Scanner(System.in);

        int radius;
        double area;

        System.out.print("Enter the radius: ");
        radius = userInput.nextInt();

        area = Math.PI * Math.pow(radius, 2);

        System.out.printf("The area is %.2f", area);
    }
}

