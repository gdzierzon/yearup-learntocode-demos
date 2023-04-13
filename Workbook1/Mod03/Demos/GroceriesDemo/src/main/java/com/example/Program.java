package com.example;

import java.util.Scanner;

public class Program
{

    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);
        double hourlyRate;
        double weeklyRate;

        System.out.print("Please enter your hourly pay rate: ");
        hourlyRate = userInput.nextDouble();

        weeklyRate = hourlyRate * 40;

        System.out.printf("Your weekly pay is $ %.2f", weeklyRate);

    }
}




