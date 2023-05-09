package org.yearup;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class WriteToLogDemo
{
    public static void main(String[] args)
    {
        logMessage("Gregor is long winded");
    }

    public static void logMessage(String message)
    {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        String fileName = "logs/" + date.toString() + ".log";
        FileWriter fileWriter;
        // PrintWriter uses a BufferedWriter
        // but gives more flexibility - like println and printf
        PrintWriter writer = null;

        try
        {
            // open the log file and append a line
            fileWriter = new FileWriter(fileName, true);
            writer = new PrintWriter(fileWriter);

            writer.printf("%s %s %s \n", date, time, message);
        }
        catch (IOException e)
        {
            // swallow exception
        }
        finally
        {
            if(writer != null)
            {
                writer.close();
            }
        }

    }
}
