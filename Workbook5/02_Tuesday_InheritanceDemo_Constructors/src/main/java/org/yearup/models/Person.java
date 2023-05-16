package org.yearup.models;

import java.time.LocalDate;
import java.time.Period;

public class Person
{
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    public Person(int id, String firstName, String lastName, LocalDate birthDate)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        System.out.println("Log... Person constructor");
    }


    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate)
    {
        this.birthDate = birthDate;
    }

    public int getAge()
    {
        LocalDate today = LocalDate.now();
        Period period = birthDate.until(today);
        return period.getYears();
    }
}
