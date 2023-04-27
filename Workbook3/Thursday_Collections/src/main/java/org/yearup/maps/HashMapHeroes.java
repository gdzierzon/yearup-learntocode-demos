package org.yearup.maps;

import org.yearup.models.Hero;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HashMapHeroes
{
    public static void main(String[] args)
    {

        HashMap<String, Hero> heroes = loadHeroes();

        // loop through all books?
    }

    public static HashMap<String, Hero> loadHeroes()
    {
        // create the map (container)
        HashMap<String, Hero> heroes = new HashMap<>();

        // load the array
        FileInputStream stream;
        Scanner fileScanner = null;
        try
        {
            stream = new FileInputStream("files/marvel.csv");
            fileScanner = new Scanner(stream);

            fileScanner.nextLine();

            while (fileScanner.hasNext())
            {
                String line = fileScanner.nextLine();

                // split line into fields
                String[] columns = line.split("\\|");
                String name = columns[0];
                String civilianName = columns[1];
                String power = columns[2];

                // create book and add to the ArrayList
                Hero hero = new Hero(name, civilianName, power );
                heroes.put(name, hero);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("There was an error loading the file");
        }
        finally
        {
            // close the stream
            if(fileScanner != null)
            {
                fileScanner.close();
            }
        }

        // return the array
        return heroes;
    }

    public static void findHero(ArrayList<Hero> heroes, String name)
    {

    }
}
