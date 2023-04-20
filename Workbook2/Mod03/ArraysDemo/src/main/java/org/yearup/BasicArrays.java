package org.yearup;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class BasicArrays
{
    public static void main(String[] args)
    {
        int[] numbers = new int[6];
        numbers[0] = 5;
        numbers[1] = 15;
        numbers[2] = 25;
        numbers[3] = 35;
        numbers[4] = 45;
        numbers[5] = 55;

        System.out.println(numbers[3]);
        System.out.println(numbers.length);
        System.out.println(numbers[numbers.length - 1]);

        String name = "gregor";
        System.out.println("Name length: " + name.length());


        int[] scores = {97, 100, 88, 89, 92, 99};
        String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

        Scanner scanner = new Scanner(System.in);
        int[] myNumbers = new int[5];
        for (int i = 0; i < myNumbers.length; i++)
        {
            System.out.print("Enter a number: ");
            int number = scanner.nextInt();

            myNumbers[i] = number;
        }

    }
}