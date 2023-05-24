package org.yearup;

import java.util.Arrays;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        IntegerPair pair = new IntegerPair(15, 25);

        System.out.println("Number pair");
        System.out.println(pair);
        pair.swap();
        System.out.println(pair);

        System.out.println();
        Pair<String> heroes = new Pair<>("Spiderman", "Thor");
        System.out.println("Pair of Heroes");
        System.out.println(heroes);
        heroes.swap();
        System.out.println(heroes);

        System.out.println();
        Pair<String> dynamicDuo = new Pair<>("Batman", "Robin");
        System.out.println("Dynamic Duo");
        System.out.println(dynamicDuo);
        dynamicDuo.swap();
        System.out.println(dynamicDuo);

        System.out.println();
        Pair<Car> cars = new Pair<>(new Car("Ford", "Mustang"), new Car("Chevy", "Camaro"));
        System.out.println("Muscle Cars");
        System.out.println(cars);
        cars.swap();
        System.out.println(cars);


        display("Gregor", 49);
        display("Square", "(side * side)");

        List<Integer> numbers = Arrays.asList(1,13,17,18,52);
        int middleNumber = getMiddle(numbers);
        System.out.println(middleNumber);
    }

    public static <T> void display(String message, T value)
    {
        System.out.println(message + ": " + value);
    }

    public static <T> T getMiddle(List<T> value)
    {
        if(value.size() == 0) return null;

        int middle = value.size() / 2;
        return value.get(middle);
    }
}