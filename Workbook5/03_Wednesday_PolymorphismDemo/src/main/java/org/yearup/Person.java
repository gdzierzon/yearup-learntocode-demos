package org.yearup;

public class Person
{
    private String name;

    public Person(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void play()
    {
        System.out.println(name + " is playing...");
    }

    public void sleep()
    {
        System.out.println(name + " is now sleeping...");
    }

    public void eat()
    {
        System.out.println(name + " is eating...");
    }
}
