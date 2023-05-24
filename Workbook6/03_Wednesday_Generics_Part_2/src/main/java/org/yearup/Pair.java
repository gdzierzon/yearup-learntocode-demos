package org.yearup;

public class Pair<T extends Musician>
{
    // A pair contains two T things
    private T leftThing;
    private T rightThing;

    public Pair(T leftThing, T rightThing)
    {
        this.leftThing = leftThing;
        this.rightThing = rightThing;
    }

    public T getLeftThing()
    {
        return leftThing;
    }

    public T getRightThing()
    {
        return rightThing;
    }

    public void swap()
    {
        T temp = leftThing;
        leftThing = rightThing;
        rightThing = temp;
    }

    public void perform()
    {
        leftThing.perform();
        rightThing.perform();
    }

    @Override
    public String toString()
    {
        return  leftThing + " : " + rightThing;
    }
}
