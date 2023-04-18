package org.yearup;

import java.util.Scanner;

public class Main
{
    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args)
    {
        String productCode = "CLTH-KIDS-1299";

        String department = productCode.substring(5,9); //substring here
        System.out.println(department);
//        compareStrings();
//        compareEqualsStrings();
//        compareEqualsIgnoreCaseStrings();
//        stringFunctions();
    }

    public static void compareStrings()
    {
        String word1 = "ABC";
        String word2 = "ABC";
        String word3 = "A" + "B" + "C";

        System.out.println("word1 == word2 : " + word1 == word2);
        System.out.println("word1 == word3 : " + word1 == word3);
    }

    public static void compareEqualsStrings()
    {
        String word1 = "ABC";
        String word2 = "ABC";
        String word3 = "A" + "B" + "C";

        System.out.println("word1.equals(word2) : " + word1.equals(word2));
        System.out.println("word1.equals(word3) : " + word1.equals(word3));
    }

    public static void compareEqualsIgnoreCaseStrings()
    {
        String word1 = "ABC";
        String word2 = "abc";
        String word3 = "A" + "b" + "C";

        System.out.println("word1.equals(word2) : " + word1.equals(word2));
        System.out.println("word1.equals(word3) : " + word1.equals(word3));

        System.out.println("word1.equalsIgnoreCase(word2) : " + word1.equalsIgnoreCase(word2));
        System.out.println("word1.equalsIgnoreCase(word3) : " + word1.equalsIgnoreCase(word3));
    }

    public static void stringFunctions()
    {
        // length
        System.out.println();
        String fullName = "Dana Wyatt";
        int length = fullName.length();
        System.out.println(fullName);
        System.out.println("Length: " + length);

        // trim
        // 1
        System.out.println();
        String username = " danaw     ";
        System.out.println("Before trim: --" + username + "--");
        username = username.trim();
        System.out.println("After trim: --" + username + "--");

        // toUpperCase
        // 2
        System.out.println();
        System.out.println("Before toUpperCase: " + username);
        username = username.toUpperCase();
        System.out.println("After toUpperCase: " + username);

        // chaining methods
        // 3
        System.out.println();
        username = " danaw      ";
        System.out.println("Before trim and toUpperCase: --" + username + "--");
        username = username.trim().toUpperCase();
        System.out.println("After trim and toUpperCase: --" + username + "--");

        // toLowerCase
        // 4
        System.out.println();
        String state = "New Mexico";
        System.out.println("Before toLowerCase: " + state);
        state = state.toLowerCase();
        System.out.println("After toLowerCase: " + state);

        // startsWith
        // 5
        System.out.println();
        String discountCode = "FAIR-15Off";
        System.out.println("Code: " + discountCode);
        if(discountCode.startsWith("FAIR"))
        {
            System.out.println("Begins with 'FAIR'");
        }
        else
        {
            System.out.println("Does not begin with 'FAIR'");
        }

        if(discountCode.startsWith("fair"))
        {
            System.out.println("Begins with 'fair'");
        }
        else
        {
            System.out.println("Does not begin with 'fair'");
        }

        // endsWith
        // 6
        System.out.println();
        System.out.println("Code: " + discountCode);
        discountCode = "SAVE-50";
        if(discountCode.endsWith("-50"))
        {
            System.out.println("Ends with '-50'");
        }
        else
        {
            System.out.println("Does not end with '-50'");
        }

        // charAt
        // 7
        System.out.println();
        String trackingCode = "USA-12981-Y-22";
        char hasShipped = trackingCode.charAt(10);
        System.out.println("Code: " + trackingCode);
        System.out.println("Has shipped: " + hasShipped);

        // indexOf
        // 8
        System.out.println();
        String productCode = "ACME-12213";
        System.out.println("Code: " + productCode);
        int dashPosition = productCode.indexOf("-");
        System.out.println("Position of dash: " + dashPosition);
        int periodPosition = productCode.indexOf(".");
        System.out.println("Period of dash: " + periodPosition);

        // substring
        // 9
        System.out.println();
        System.out.println("Code: " + productCode);
        int dashIndex = productCode.indexOf("-");
        String vendor = productCode.substring(0, dashIndex);
        String productId = productCode.substring(dashIndex + 1);
        System.out.println("Vendor: " + vendor);
        System.out.println("ProductId: " + productId);

        // split
        System.out.println();
        String input = "Dallas|Ft. Worth|Austin";
        System.out.println("Cities: " + input);
        String[] cities = input.split("\\|");
        String city1 = cities[0];
        String city2 = cities[1];
        String city3 = cities[2];
        System.out.println(city1);
        System.out.println(city2);
        System.out.println(city3);

    }
}