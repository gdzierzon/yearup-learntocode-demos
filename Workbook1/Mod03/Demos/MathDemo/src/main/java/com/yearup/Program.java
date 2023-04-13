package com.yearup;

public class Program
{
    public static void main(String[] args)
    {
        // DON'T USE MAGIC NUMBERS
        int answer2 = 13 + 2;
        System.out.println("14 + 2 = " + answer2);

        // counting birds on the wire
        int birdsOnTheWire = 13;
        int newBirds = 2;
        int totalBirdsOnTheWire = birdsOnTheWire + newBirds;

        System.out.println(birdsOnTheWire + " + " + newBirds + " = " + totalBirdsOnTheWire);

        // Integer Division
        int numberOfCookies = 55;
        int numberOfStudents = 20;
        int cookiesPerStudent = numberOfCookies / numberOfStudents; // <- gives the answer - but the remainder is ignored
        // + - / * %
        //int numberOfCookiesRemaining = numberOfCookies - (cookiesPerStudent * numberOfStudents);
        int numberOfCookiesRemaining = numberOfCookies % numberOfStudents; // <- give us the remainder - but the answer is ignored


        System.out.println("Cookies Per Student: " + cookiesPerStudent);
        System.out.println("Remaining Cookies: " + numberOfCookiesRemaining);

        // floating point division
        double numberOfCookies2 = 55;
        double numberOfStudents2 = 20;
        double cookiesPerStudent2 = numberOfCookies2 / numberOfStudents2;

        System.out.println(cookiesPerStudent2);

        // Math class
        System.out.println(Math.PI);
        double width = 5;
        double areaOfSquare = Math.pow(width,2);

        System.out.println(areaOfSquare);





    }
}
