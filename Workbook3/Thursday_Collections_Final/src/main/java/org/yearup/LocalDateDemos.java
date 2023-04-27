package org.yearup;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalDateDemos
{
    public static void main(String[] args)
    {
        LocalDate date = LocalDate.now();
        System.out.println("Today is: " + date);

        LocalTime time = LocalTime.now();
        System.out.println("The current time is: " + time);

        LocalDateTime rightNow = LocalDateTime.now();
        System.out.println("Right now, it is: " + rightNow);


        System.out.println();
        System.out.println("DATE PARTS");
        System.out.println("-------------------------------");
        System.out.println("Day of Week: " + date.getDayOfWeek());
        System.out.println("Day of Month: " + date.getDayOfMonth());
        System.out.println("Day of Year: " + date.getDayOfYear());
        System.out.println("Month Name: " + date.getMonth());
        System.out.println("Month Value: " + date.getMonthValue());
        System.out.println("Year: " + date.getYear());

        System.out.println();
        System.out.println("TIME PARTS");
        System.out.println("-------------------------------");
        System.out.println("Hour: " + time.getHour());
        System.out.println("Minute: " + time.getMinute());
        System.out.println("Second: " + time.getSecond());
        System.out.println("Nanosecond: " + time.getNano());


        System.out.println();
        System.out.println("FORMATTED DATE");
        System.out.println("-------------------------------");

        System.out.println("Today is (no format): " + rightNow);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, MMM dd, yyyy HH:mm:ss");
        String formattedDate = rightNow.format(formatter);
        System.out.println("Today is (formatted): " + formattedDate);

        formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        formattedDate = rightNow.format(formatter);
        System.out.println("Today is (formatted): " + formattedDate);



    }
}
