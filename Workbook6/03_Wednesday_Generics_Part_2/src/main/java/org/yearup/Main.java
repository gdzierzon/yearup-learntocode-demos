package org.yearup;


public class Main
{
    public static void main(String[] args)
    {
        Pair<Musician> duet = new Pair<>(new Vocalist(), new Cellist());
        System.out.println(duet.toString());
        duet.perform();


    }

}