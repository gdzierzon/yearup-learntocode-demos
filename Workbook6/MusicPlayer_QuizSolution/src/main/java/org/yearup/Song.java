package org.yearup;

public class Song implements Playable
{
    private final String name;
    private final int length;

    public Song(String name, int length)
    {
        this.name = name;
        this.length = length;
    }

    public String getName()
    {
        return name;
    }

    public int getLength()
    {
        return length;
    }

    @Override
    public void play()
    {
        System.out.println("Playing " + name);
    }

    @Override
    public void stop()
    {
        System.out.println("Stop playing " + name);
    }
}
