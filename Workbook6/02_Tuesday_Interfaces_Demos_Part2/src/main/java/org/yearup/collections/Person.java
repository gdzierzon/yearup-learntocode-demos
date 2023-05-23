package org.yearup.collections;

public class Person implements Comparable<Person>
{
    private String name;

    public Person(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public int compareTo(Person o)
    {
        //this = current person
        // o = the person to compare to
        // is "this" person less than "o" person return -1
        // if they are equal return 0
        // if "this" is greater than "o" then return +1
        return -this.name.compareTo(o.name);
    }
}
