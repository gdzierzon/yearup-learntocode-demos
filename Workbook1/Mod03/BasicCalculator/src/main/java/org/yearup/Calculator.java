package org.yearup;

import java.util.Scanner;

public class Calculator
{

    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);

        // variables
        String operation;
        double num1;
        double num2;

        // get user input
        System.out.print("What operation do you want to perform (add, subtract, multiply, divide)? ");
        operation = userInput.nextLine();

        System.out.print("Enter the first number: ");
        num1 = userInput.nextDouble();
        userInput.nextLine();

        System.out.print("Enter the second number: ");
        num2 = userInput.nextDouble();
        userInput.nextLine();

        // perform calculation
        if(operation.equalsIgnoreCase("add"))
        {
            add(num1, num2);
        }
        else if(operation.equalsIgnoreCase("subtract"))
        {
            subtract(num1, num2);
        }
        else if(operation.equalsIgnoreCase("multiply"))
        {
            multiply(num1, num2);
        }
        else if(operation.equalsIgnoreCase("divide"))
        {
            divide(num1, num2);
        }
        else
        {
            System.out.println("Please select a valid option.");
            System.exit(1);
        }

    }

    public static void add(double number1, double number2)
    {
        double answer = number1 + number2;
        System.out.printf("%.2f + %.2f = %.2f", number1, number2, answer);
    }

    public static void subtract(double number1, double number2)
    {
        double answer = number1 - number2;
        System.out.printf("%.2f + %.2f = %.2f", number1, number2, answer);
    }

    public static void multiply(double number1, double number2)
    {
        double answer = number1 * number2;
        System.out.printf("%.2f + %.2f = %.2f", number1, number2, answer);
    }

    public static void divide(double number1, double number2)
    {
        double answer = number1 / number2;
        System.out.printf("%.2f + %.2f = %.2f", number1, number2, answer);
    }
}
