package org.yearup;

public class Employee
{
    // static class variables
    private static final int REGULAR_HOURS = 40;
    private static final double OVERTIME_RATE = 1.5;

    // private variables
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;

    // helper variables
    private boolean isClockedIn;
    private double timeIn;

    // constructors
    public Employee()
    {
    }

    public Employee(int employeeId, String name, String department, double payRate, double hoursWorked)
    {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    // getters and setters
    public int getEmployeeId()
    {
        return employeeId;
    }

    public void setEmployeeId(int employeeId)
    {
        this.employeeId = employeeId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDepartment()
    {
        return department;
    }

    public void setDepartment(String department)
    {
        this.department = department;
    }

    public double getPayRate()
    {
        return payRate;
    }

    public void setPayRate(double payRate)
    {
        this.payRate = payRate;
    }

    public double getHoursWorked()
    {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked)
    {
        this.hoursWorked = hoursWorked;
    }

    // derived getters
    public double getRegularHours()
    {
        if(hoursWorked > REGULAR_HOURS)
        {
            return REGULAR_HOURS;
        }

        return  hoursWorked;
    }

    public double getOvertimeHours()
    {
        if(hoursWorked > REGULAR_HOURS)
        {
            return hoursWorked - REGULAR_HOURS;
        }

        return 0;
    }

    public double getRegularPay()
    {
        return getRegularHours() * payRate;
    }

    public double getOvertimePay()
    {
        return  getOvertimeHours() * payRate *  OVERTIME_RATE;
    }

    public double getTotalPay()
    {
        return getRegularPay() + getOvertimePay();
    }

    // methods
    public void punchIn(double time)
    {
        isClockedIn = true;
        timeIn = time;
    }

    public void punchOut(double time)
    {
        if(time > timeIn)
        {
            double timeWorked = time - timeIn;
            hoursWorked += timeWorked;

            isClockedIn = false;
            timeIn = 0;
        }
        else
        {
            throw new RuntimeException("Time out must be AFTER time in:\n   Time in: " + timeIn + "\n   Time out: " + time);
        }
    }

    public void punchTimeCard(double time)
    {
        if(!isClockedIn)
        {
            isClockedIn = true;
            timeIn = time;
        }
        else if(time > timeIn)
        {
            double timeWorked = time - timeIn;
            hoursWorked += timeWorked;

            isClockedIn = false;
            timeIn = 0;
        }
        else
        {
            throw new RuntimeException("Time out must be AFTER time in:\n   Time in: " + timeIn + "\n   Time out: " + time);
        }
    }
}
