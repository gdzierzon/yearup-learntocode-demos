package org.yearup.shapes;

import org.yearup.banking.BankAccount;

public class Main
{
    public static void main(String[] args)
    {
        Rectangle rectangle = new Rectangle(50, 12);
        System.out.println(rectangle.getArea());

//        Shape shape = new Shape();
//        System.out.println(shape.getArea());

        Triangle triangle = new Triangle(10, 5);
        System.out.println(triangle.getArea());

        Shape shape = new Rectangle(5, 35);
        shape.draw();
    }
}