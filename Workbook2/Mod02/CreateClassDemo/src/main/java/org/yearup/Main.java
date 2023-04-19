package org.yearup;

import java.time.LocalDate;

public class Main
{
    public static void main(String[] args)
    {
        int age;
        LocalDate newBirthday = LocalDate.parse("2003-04-08");

        Person joe = new Person(20, "Joseph", newBirthday);

        // can't access joe.age directly because age is private
//        joe.age = 20;
//        joe.setAge(20);
//        joe.setName("Joseph");
//        joe.setBirthday(newBirthday);

        System.out.println(joe.getAge());
        System.out.println(joe.getName());
        System.out.println(joe.getBirthday());

    }
}