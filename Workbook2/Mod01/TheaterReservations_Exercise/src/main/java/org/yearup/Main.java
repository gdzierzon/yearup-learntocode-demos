package org.yearup;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);

        String fullName;
        String firstName;
        String lastName;
        LocalDate reservationDate;
        int numberOfTickets;
        String dateInput;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");

        // get user input
        System.out.println();
        System.out.print("Please enter your name: ");
        fullName = userInput.nextLine();

        System.out.print("What date will you be coming (mm/dd/yyyy)? ");
        dateInput = userInput.nextLine();
        reservationDate = LocalDate.parse(dateInput, formatter);

        System.out.print("How many tickets would you like? ");
        numberOfTickets = userInput.nextInt();

        String[] names = fullName.split(" ");
        firstName = names[0];
        lastName = names[1];
        String ticketText = numberOfTickets > 1 ? "tickets" : "ticket";

        System.out.println();
        System.out.printf("%d %s reserved for %s under %s, %s", numberOfTickets, ticketText, reservationDate, lastName, firstName);
    }
}