package org.yearup;

import java.util.ArrayList;
import java.util.Collections;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<String> heroes = new ArrayList<>();
        heroes.add("Thor");
        heroes.add("Captain America");
        heroes.add("Deadpool");
        heroes.add("Iron Man");
        heroes.add("Black Widow");
        heroes.add("Thor");
        heroes.add(1, "Spiderman");

        heroes.remove(5);
        heroes.remove("Thor");

        if(heroes.contains("Thor"))
        {
            System.out.println("THOR is STILL IN THE HOUSE!");
        }

        Collections.sort(heroes);

        for (int i = 0; i < heroes.size(); i++)
        {
            // heroes[i]
            String name = heroes.get(i);
            System.out.println(name);
        }

    }
}