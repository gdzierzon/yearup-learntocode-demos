package org.yearup;

import java.util.Scanner;

public class BasicCalculator
{
    public static void main(String[] args)
    {
        Scanner myScanner = new Scanner(System.in);

        String option;
        double number1;
        double number2;
        double answer;

        System.out.print("What do you want to do (add, subtract, multiply, divide): ");
        option = myScanner.nextLine();

        System.out.println("What is the first number? ");
        number1 = myScanner.nextDouble();

        System.out.println("What is the second number? ");
        number2 = myScanner.nextDouble();

        if(option.equalsIgnoreCase("add"))
        {
            // do the math for addition +
            answer = number1 + number2;
            // print() - print to screen
            // println() - print to screen AND add a new line
            // printf() - print to screen AND format - will call the String.format()
            System.out.printf("%.0f + %.1f = %.2f\n",  number1, number2, answer);
        }
        else if(option.equalsIgnoreCase("subtract"))
        {
            System.out.println(" subtract the numbers ");
        }
        else if(option.equalsIgnoreCase("multiply")) // MULTIPLY
        {

        }
        else if(option.equalsIgnoreCase("divide"))
        {

        }
        else
        {
            System.out.println("Please select a valid option");
            System.exit(1);
        }
    }
}

