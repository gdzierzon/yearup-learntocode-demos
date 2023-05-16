package org.yearup.models;

import java.time.LocalDate;
import java.time.Period;

public class Employee extends Person
{
    private LocalDate hireDate;
    private double salary;
    private String department;

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
