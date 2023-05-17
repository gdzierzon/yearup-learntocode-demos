package org.yearup;

public class Child extends Person
{
    public Child(String name)
    {
        super(name);
    }

    @Override
    public void play()
    {
        System.out.println(getName() + " is eating sand :(");
    }

}
