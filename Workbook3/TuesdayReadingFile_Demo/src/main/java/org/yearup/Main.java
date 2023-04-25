package org.yearup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        FileInputStream fileStream;
        Scanner fileScanner = null;

        FileWriter fileWriter = null;

        try
        {
            // 1 open file - for reading
            fileStream = new FileInputStream("data/products.csv");
            fileScanner = new Scanner(fileStream);
            // open file for WRITING
            fileWriter = new FileWriter("data/prices.txt");

            // skip first line (header row)
            fileScanner.nextLine();

            // 2 process the file - read all rows
            // loop
            while (fileScanner.hasNext())
            {
                String line = fileScanner.nextLine();
                String[] columns = line.split("\\|");
                double price = Double.parseDouble(columns[2]);

                // write the price to the new file
                fileWriter.write(price + "\n");
                System.out.println(price);
            }

        }
        catch(IOException e)
        {
            System.out.println("There was a problem with opening/closing the file.");
            System.out.println(e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println("A general error has occurred:");
            System.out.println(e.getMessage());
        }
        finally
        {
            // clean up code
            if(fileScanner != null)
            {
                // 3 close the stream
                fileScanner.close();
                try
                {
                    fileWriter.close();
                }catch (Exception ex){}
            }
        }

        System.out.println("The end...");
    }
}