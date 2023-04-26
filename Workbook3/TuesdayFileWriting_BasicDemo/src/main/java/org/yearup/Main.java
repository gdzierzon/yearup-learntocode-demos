package org.yearup;

import java.io.FileWriter;
import java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {
        FileWriter fileWriter = null;

        try
        {
            // 1 - open the file for writing
            // by default - this will overwrite the existing file
            fileWriter = new FileWriter("logs/log.txt");

            // if you want to open the file and append instead
            // use the overloaded constructor - true = append
            // fileWriter = new FileWriter("logs/log.txt", true);

            // 2 - write to the file
            for (int i = 0; i < 5; i++)
            {
                fileWriter.write("test\n");
                fileWriter.flush();
            }

        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            // 3 - close the file
            // this will throw an exception if fileWriter is null, or if it is not open
            try
            {
                fileWriter.close();
            }
            catch(Exception ex)
            {
                // swallow the exception
            }
        }
    }
}