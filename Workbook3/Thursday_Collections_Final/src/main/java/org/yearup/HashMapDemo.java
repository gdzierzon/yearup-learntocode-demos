package org.yearup;

import java.util.HashMap;

public class HashMapDemo
{
    public static void main(String[] args)
    {
        // create the map
        HashMap<String, Double> discounts = new HashMap<>();

        // add discount to map
        discounts.put("FALL2022", 0.15);
        discounts.put("NEWYEAR", 0.25);
        discounts.put("SPRING2023", 0.10);
        discounts.put("SCHOOLSOUT", 0.50);
        discounts.put("SUMMER2023", 0.30);

        // prompt the user for a dicount/coupon code
        // find discount & display to user what their discount % is


    }
}
