package org.yearup.arrays;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ArrayStrings
{
    public static void main(String[] args)
    {

        String[] names = getNames();

        for (int i = 0; i < names.length; i++)
        {
            String name = names[i];
            System.out.println(name);
        }

    }

    public static String[] getNames()
    {
        // create the array (container)
        String[] names = new String[10];

        // load the array
        FileInputStream stream;
        Scanner fileScanner = null;
        try
        {
            stream = new FileInputStream("files/names10.txt");
            fileScanner = new Scanner(stream);

            int index = 0;
            while (fileScanner.hasNext())
            {
                String name = fileScanner.nextLine();
                names[index] = name;
                index++;
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
