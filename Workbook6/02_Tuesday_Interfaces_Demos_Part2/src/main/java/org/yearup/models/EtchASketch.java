package org.yearup.models;

public class EtchASketch implements Drawable, Cleaner
{

    @Override
    public void clean()
    {
        System.out.println("Etch-A-Sketch is clean");
    }

    @Override
    public void draw()
    {
        System.out.println("Etch-a-Sketch is drawing on the screen");
    }
}
