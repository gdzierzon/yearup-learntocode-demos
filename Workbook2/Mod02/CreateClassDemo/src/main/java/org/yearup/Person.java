package org.yearup;

import java.time.LocalDate;

public class Person
{
    private int age;
    private String name;
    private LocalDate birthday;

    // constructor
    public Person(int age, String name, LocalDate birthday)
    {
        this.age = age;
        this.name = name;
        this.birthday = birthday;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        if(age >=0 && age <= 100)
        {
            this.age = age;
        }
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public LocalDate getBirthday()
    {
        return birthday;
    }

    public void setBirthday(LocalDate birthday)
    {
        this.birthday = birthday;
    }
}
