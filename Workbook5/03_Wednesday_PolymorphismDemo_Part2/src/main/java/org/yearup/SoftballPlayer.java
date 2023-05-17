package org.yearup;

public class SoftballPlayer extends Person
{
    public SoftballPlayer(String name)
    {
        super(name);
    }

    @Override
    public void play()
    {
        System.out.println(getName() + " is playing SOFTBALL!!!");
    }

    public void stretch()
    {
        System.out.println(getName() + " is stretching...");
    }
}
