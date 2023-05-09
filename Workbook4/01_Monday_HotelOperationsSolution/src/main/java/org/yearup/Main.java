package org.yearup;

public class Main
{
    public static void main(String[] args)
    {
        Employee employee = new Employee(1, "John", "HR", 20, 35);
        displayWork(employee);

        employee.punchIn(10.5);
        employee.punchOut(12);
        displayWork(employee);

        employee.punchTimeCard(13);
        employee.punchTimeCard(20);
        displayWork(employee);


    }

    public static void displayWork(Employee employee)
    {
        System.out.println();
        System.out.println(employee.getName());
        System.out.println("---------------------------------");
        System.out.println("Hours");
        System.out.println("---------------------------------");
        System.out.println("Regular Hours:  " + employee.getRegularHours());
        System.out.println("Overtime Hours: " + employee.getOvertimeHours());
        System.out.println("Total Hours:    " + employee.getHoursWorked());
        System.out.println("---------------------------------");
        System.out.println("Pay");
        System.out.println("---------------------------------");
        System.out.println("Regular Pay:    " + employee.getRegularPay());
        System.out.println("Overtime Pay:   " + employee.getOvertimePay());
        System.out.println("Total Pay:      " + employee.getTotalPay());
    }
}