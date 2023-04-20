package org.yearup;

public class WhileDemo
{
    public static void main(String[] args)
    {
        int counter = 1;
        while(counter <= 10)
        {
            System.out.println(counter);
            counter++;
        }

        for(int count = 1;
            count <= 10;
            count++)
        {
            System.out.println("count: " + count);
        }
    }
}
