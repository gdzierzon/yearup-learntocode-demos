package com.learntocode;

public class MathApp
{
    public static void main(String[] args)
    {
        // find the largest of 2 salaries
        int job1Salary = 150000;
        int job2Salary = 175000;
        int maxSalary = Math.max(job1Salary, job2Salary);
        System.out.println("Max Salary: $" + maxSalary);

        // find the smallest of 2 prices
        int carPrice = 32000;
        int truckPrice = 75000;
        int minPrice = Math.min(carPrice, truckPrice);
        System.out.println("Min Vehicle Price: $" + minPrice);

        // find the area of a circle
        double radius = 7.25;
        double area = Math.PI * Math.pow(radius, 2);
        System.out.println("Circle Area: " + area);

        // find the square root of 5
        double num1 = 5.0;
        double sqrt = Math.sqrt(num1);
        System.out.println("The square root is: " + sqrt);

        // find the distance between 2 points
        int x1 = 5;
        int y1 = 10;
        int x2 = 85;
        int y2 = 50;
        int length = Math.abs(x2 - x1);
        int height = Math.abs(y2 - y1);
        double x2y2 = Math.pow(length, 2) + Math.pow(height, 2);
        double hypotenuse = Math.sqrt(x2y2);
        System.out.println("The hypotenuse is: " + hypotenuse);

        // find the absolute value of a number
        double num2 = -3.8;
        double absoluteValue = Math.abs(num2);
        System.out.println("The absolute value: " + absoluteValue);

        // generate a random number between 0 and 1
        double random = Math.random();
        System.out.println("The random value is: " + random);
    }
}