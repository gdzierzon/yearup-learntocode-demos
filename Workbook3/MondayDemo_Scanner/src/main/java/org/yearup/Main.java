package org.yearup;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main
{
    // I need to specify that the method (potentially) throws an exception
    public static void main(String[] args) throws Exception
    {
        // scanner that reads from System.in Stream
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the file you want to read: ");
        String fileName = scanner.nextLine();

        System.out.println();

        // Read from a file
        // 1. open file and convert to a stream
        FileInputStream fileStream = new FileInputStream(fileName);
        // 1b. create scanner from stream
        Scanner fileScanner = new Scanner(fileStream);

        // 2. read the lines in the file
        while(fileScanner.hasNextLine())
        {
            String line = fileScanner.nextLine();
            System.out.println(line);
        }

        // 3. close the scanner - releases the lock on the file
        fileScanner.close();
    }
}