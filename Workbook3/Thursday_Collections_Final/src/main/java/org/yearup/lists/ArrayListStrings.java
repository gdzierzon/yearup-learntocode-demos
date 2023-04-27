package org.yearup.lists;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListStrings
{
    public static void main(String[] args)
    {

        ArrayList<String> names = getNames();

        for (int i = 0; i < names.size(); i++)
        {
            String name = names.get(i);
            System.out.println(name);
        }
    }

    public static ArrayList<String> getNames()
    {
        // create the array (container)
        ArrayList<String> names = new ArrayList<>();

        // load the array
        FileInputStream stream;
        Scanner fileScanner = null;
        try
        {
            stream = new FileInputStream("files/names50.txt");
            fileScanner = new Scanner(stream);

            while (fileScanner.hasNext())
            {
                String name = fileScanner.nextLine();
                names.add(name);
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
        return names;
    }

}