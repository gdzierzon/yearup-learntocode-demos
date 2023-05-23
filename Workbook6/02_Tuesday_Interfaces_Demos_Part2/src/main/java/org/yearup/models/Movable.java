package org.yearup.models;

public interface Movable
{
    Point move(int x, int y);
    void goHome();

    default void print()
    {
        System.out.println("Printing the movable object");
    }
}
