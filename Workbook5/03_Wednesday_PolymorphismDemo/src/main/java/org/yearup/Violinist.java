package org.yearup;

// extends = IS-A
public class Violinist extends Person
{
    public Violinist(String name)
    {
        super(name);
    }

    @Override
    public void play()
    {
        System.out.println(getName() + " is playing a beautiful sonata.");
    }
}
