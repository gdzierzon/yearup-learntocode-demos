package org.yearup;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashMapCraftsDemo
{
    public static void main(String[] args)
    {
        HashMap<String, Integer> supplies = new HashMap<>();

        supplies.put("Scissors", 10);
        supplies.put("Markers", 20);
        supplies.put("Rulers", 5);
        supplies.put("Brushes", 5);


//        supplies.remove("Brushes");
//
        int currentMarkers = supplies.get("Markers");
        supplies.put("Markers", currentMarkers + 5);

        System.out.println(supplies.get("Markers"));

        Set<String> keys = supplies.keySet();

        System.out.println();
        System.out.println("All Keys");
        System.out.println("---------------");
        for(String key : keys)
        {
            System.out.println(key);
        }
    }
}
