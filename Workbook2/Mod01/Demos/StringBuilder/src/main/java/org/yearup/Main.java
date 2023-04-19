package org.yearup;

public class Main
{
    public static void main(String[] args)
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Git, ");
        builder.append("HTML, ");
        builder.insert(5,"Java, ");

        System.out.println(builder.toString());


    }
}