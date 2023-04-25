package org.yearup;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Scanner;

public class WritingDemo
{
    public static void main(String[] args) throws Exception
    {

        //********* READING A FILE **********
        // 1 - open the file
        FileInputStream fileStream = new FileInputStream("logs/log.txt");
        Scanner fileScanner = new Scanner(fileStream);

        // 2 - read all lines of the file
        while (fileScanner.hasNext())
        {
            String line = fileScanner.nextLine();
            System.out.println(line);
        }

        // 3 - close the stream
        fileScanner.close();


        //********* WRITING TO A FILE **********
        // 1 - open the file for writing
        FileWriter fileWriter = new FileWriter("logs/log.txt");

        // 2 - write to the file
        fileWriter.write("Write a line of text\n");
        fileWriter.flush();

        // 3 - close the stream
        fileWriter.close();
    }
}
