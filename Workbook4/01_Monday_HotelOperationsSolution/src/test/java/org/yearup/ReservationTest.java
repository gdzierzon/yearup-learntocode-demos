package org.yearup;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservationTest
{

    @Test
    public void getPrice_should_return139_forKingOnWeekday()
    {
        // arrange
        String roomType = "King";
        int numberOfNights = 1;
        boolean isWeekend = false;
        Reservation reservation = new Reservation(roomType, numberOfNights, isWeekend);
        double expected = 139;

        // act
        double actual = reservation.getPrice();

        // assert
        assertEquals(expected, actual,"Because the reservation is for a King on a weeknight");

    }

    @Test
    public void getPrice_should_return152_90_forKingOnWeekend()
    {
        // arrange
        String roomType = "King";
        int numberOfNights = 1;
        boolean isWeekend = true;
        Reservation reservation = new Reservation(roomType, numberOfNights, isWeekend);
        double expected = 152.9;

        // act
        double actual = reservation.getPrice();

        // assert
        assertEquals(expected, actual,"Because the reservation is for a King on a weekend");

    }

}