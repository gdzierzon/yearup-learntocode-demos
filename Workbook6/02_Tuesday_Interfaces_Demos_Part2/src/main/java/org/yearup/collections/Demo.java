package org.yearup.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Demo
{
    public static void main(String[] args)
    {
        List<Person> people;

        people = new ArrayList<>();
        people.add(new Person("John"));
        people.add(new Person("Mary"));
        people.add(new Person("David"));
        people.add(new Person("Sarah"));
        people.add(new Person("Michael"));
        people.add(new Person("Jessica"));
        people.add(new Person("Robert"));
        people.add(new Person("Jennifer"));
        people.add(new Person("William"));

        List<String> names = new ArrayList<>();

        Collections.sort(people);

        for(Person person : people)
        {
            System.out.println(person.getName());
        }
    }
}
