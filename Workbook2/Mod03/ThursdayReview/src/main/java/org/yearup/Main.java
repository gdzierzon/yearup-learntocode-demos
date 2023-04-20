package org.yearup;

public class Main
{
    public static void main(String[] args)
    {
        Hotel hilton = new Hotel();
        Hotel marriott = new Hotel("Courtyard",4, 129.99);

        System.out.println(hilton.getName());
        System.out.println(marriott.getName());
    }
}