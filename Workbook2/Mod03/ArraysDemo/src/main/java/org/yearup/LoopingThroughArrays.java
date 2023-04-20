package org.yearup;

import java.util.Arrays;

public class LoopingThroughArrays
{
    public static void main(String[] args)
    {
        int[] scores = {97, 100, 88, 89, 92, 99, 82, 79, 100, 95};
        int[] numbers = {1,2};
        numbers = resize(numbers, 4);

        displayNumbers(scores);
        Arrays.sort(scores);
        System.out.println();
        displayNumbers(scores);
        System.out.println();
        displayNumbers(numbers);
    }

    public static void displayNumbers(int[] numbers)
    {
        for(int i = 0; i < numbers.length; i++)
        {
            System.out.println(numbers[i]);
        }

    }

    public static int[] resize(int[] numbers, int newSize)
    {
        int[] newArray = new int[newSize];

//        for (int i = 0; i < numbers.length; i++)
//        {
//            newArray[i] = numbers[i];
//        }
        System.arraycopy(numbers,0,newArray,0,numbers.length);

        return newArray;
    }

    public static int sum(int[] numbers)
    {
        // create my variable that will hold the answer
        int sum = 0;

        // calculate
        for (int i = 0; i < numbers.length; i++)
        {
            sum += numbers[i];
//            sum = sum + numbers[i];
        }

        // your return statement
        return sum;
    }
}
