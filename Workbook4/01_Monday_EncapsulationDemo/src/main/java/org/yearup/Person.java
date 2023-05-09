package org.yearup;

public class Person
{
    // ALL variables should be private
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
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

    // derived property
    // there is NO direct backing variable
    public String getFullName()
    {
        return firstName + " " + lastName;
    }
}
