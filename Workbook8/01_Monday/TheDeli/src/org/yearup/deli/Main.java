package org.yearup.deli;

import org.yearup.common.Calculator;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Welcome to the Deli!");

        Calculator calc = new Calculator();

        calc.add(15);
        calc.add(1.5);
        calc.add(3.5);
        calc.multiply(3);

        System.out.println(calc.getAnswer());

    }
}