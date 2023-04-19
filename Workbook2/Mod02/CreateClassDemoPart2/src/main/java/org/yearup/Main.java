package org.yearup;

import java.time.LocalDate;

public class Main
{
    public static void main(String[] args)
    {
        int age;
        LocalDate newBirthday = LocalDate.parse("2003-04-08");

        Person joe = new Person(20, "Joseph", newBirthday);
        Person gabrielle = new Person();

        gabrielle.setAge(18);
        gabrielle.setName("Gabrielle");
        gabrielle.setBirthday(LocalDate.parse("2005-03-13"));

        System.out.println(joe.getAge());
        System.out.println(joe.getName());
        System.out.println(joe.getBirthday());
        joe.workout("running");

        System.out.println();
        joe.haveABirthday();
        System.out.println(joe.getAge());
        joe.workout("bench press");

        String name = "gregor";

        name.toUpperCase();


    }
}