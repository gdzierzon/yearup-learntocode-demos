package org.yearup.models;

public interface Cleaner
{
    void clean();

    default void print()
    {
        System.out.println("Object is printing as the cleaner");
    }
}
