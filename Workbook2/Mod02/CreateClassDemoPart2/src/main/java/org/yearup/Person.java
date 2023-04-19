package org.yearup;

import java.time.LocalDate;

public class Person
{
    // instance variables
    private int age;
    private String name;
    private LocalDate birthday;

    // constructors
    public Person(int age, String name, LocalDate birthday)
    {
        this.age = age;
        this.name = name;
        this.birthday = birthday;
    }

    public Person()
    {

    }

    // properties (getters/setters)
    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        if(age >=0 && age <= 100)
        {
            this.age = age;
        }
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public LocalDate getBirthday()
    {
        return birthday;
    }

    public void setBirthday(LocalDate birthday)
    {
        this.birthday = birthday;
    }

    // methods
    public void haveABirthday()
    {
//        age = age + 1;
//        age += 1;
        age++;
        System.out.println("YAY - it's another birthday party for " + name);
    }

    public void workout(String exercise)
    {
        System.out.println("Working out: " + exercise);
        if(age > 65)
        {
            System.out.println("Be careful... you know what happened last time");
        }
        else if(age >= 21)
        {
            System.out.println("You still got it man - keep going");
        }
        else
        {
            System.out.println("Enjoy it while you can");
        }
    }
}
