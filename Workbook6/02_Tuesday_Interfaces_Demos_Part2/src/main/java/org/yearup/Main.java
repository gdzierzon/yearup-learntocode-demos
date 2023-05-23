package org.yearup;

import org.yearup.models.*;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<Movable> movables = new ArrayList<>();
        movables.add(new RobotVacuum());
        movables.add(new Robot(new Point(10,50)));
        movables.add(new Car());

        Cleaner cleaner = new RobotVacuum();
        cleaner.print();


        for(Movable movable : movables)
        {
            movable.move(10, 20);
            movable.print();
        }

        System.out.println();
        for(Movable movable : movables)
        {
            movable.move(10, 20);
            movable.print();
        }
    }
}