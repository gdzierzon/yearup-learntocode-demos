package org.yearup.models;

import java.time.LocalDate;
import java.time.Period;

public class Employee extends Person
{
    private LocalDate hireDate;
    private double salary;
    private String department;

    // the employee class accepts all values for PERSON
    // AND the variables needed for Employee
    public Employee(int id, String firstName, String lastName, LocalDate birthDate,
                    LocalDate hireDate, double salary, String department)
    {
        // call to super constructor MUST be the first line
        // pass the variables through to Person
        super(id, firstName, lastName, birthDate);

        this.hireDate = hireDate;
        this.salary = salary;
        this.department = department;

        System.out.println("Log... Employee constructor");
    }


    public LocalDate getHireDate()
    {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate)
    {
        this.hireDate = hireDate;
    }

    public double getSalary()
    {
        return salary;
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
    }

    public String getDepartment()
    {
        return department;
    }

    public void setDepartment(String department)
    {
        this.department = department;
    }

    public int getMonthsEmployed()
    {
        LocalDate today = LocalDate.now();
        Period period = hireDate.until(today);
        return period.getMonths();
    }

    public void earnPayRaise(double percent)
    {
        salary += salary * percent;
    }
}
