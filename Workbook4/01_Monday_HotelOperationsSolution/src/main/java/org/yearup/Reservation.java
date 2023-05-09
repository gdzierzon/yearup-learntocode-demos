package org.yearup;

public class Reservation
{
    // static class variables
    private static final String KING = "King";
    private static final String DOUBLE = "Double";
    private static final double KING_PRICE = 139;
    private static final double DOUBLE_PRICE = 124;
    private static final double WEEKEND_RATE_INCREASE = 1.1;

    // instance variables
    private String roomType;
    private int numberOfNights;
    private boolean isWeekend;

    // constructors
    public Reservation()
    {
    }

    public Reservation(String roomType, int numberOfNights, boolean isWeekend)
    {
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.isWeekend = isWeekend;
    }

    // getters and setters
    public String getRoomType()
    {
        return roomType;
    }

    public void setRoomType(String roomType)
    {
        this.roomType = roomType;
    }

    public int getNumberOfNights()
    {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights)
    {
        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekend()
    {
        return isWeekend;
    }

    public void setWeekend(boolean weekend)
    {
        isWeekend = weekend;
    }

    // derived getters
    // calculate price based on room type and is weekend
    public double getPrice()
    {
        double price = roomType.equalsIgnoreCase(KING) ? KING_PRICE : DOUBLE_PRICE;

        if(isWeekend)
        {
            price *= WEEKEND_RATE_INCREASE;
        }

        return price;
    }

    // calculate the reservation total
    public double getReservationTotal()
    {
        return getPrice() * numberOfNights;
    }
}
