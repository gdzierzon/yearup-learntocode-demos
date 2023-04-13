package com.yearup;

public class TypeCasting
{
    public static void main(String[] args)
    {
        long bigNumber;
        int smallNumber;

        bigNumber = 2147483649L;
        smallNumber = (int)bigNumber;

        System.out.println(smallNumber);

    }
}
