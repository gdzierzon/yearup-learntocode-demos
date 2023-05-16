package org.yearup;

import org.yearup.models.BankAccount;
import org.yearup.models.Customer;
import org.yearup.models.Employee;
import org.yearup.models.Person;

import java.time.LocalDate;

public class Main
{
    public static void main(String[] args)
    {

        System.out.println();
        System.out.println("-------------------");
        System.out.println("Employees");
        System.out.println("-------------------");
        Employee employee;
        // pass all values into the constructor
        employee = new Employee(123, "Gregor", "Dzierzon", LocalDate.parse("1974-05-22"),
                LocalDate.parse("2019-08-15"), 70000, "Software Engineering");

        // NO NEED TO CALL SETTERS ANYMORE
//        employee.setId(123);
//        employee.setFirstName("Gregor");
//        employee.setLastName("Dzierzon");
//        employee.setBirthDate(LocalDate.parse("1974-05-22"));

//        employee.setHireDate(LocalDate.parse("2019-08-15"));
//        employee.setSalary(70000);
//        employee.setDepartment("Software Engineering");

        System.out.println("Name: " + employee.getFirstName());
        System.out.println("Department: " + employee.getDepartment());
        System.out.println("Salary before raise: " + employee.getSalary());
        employee.earnPayRaise(.05);
        System.out.println("Salary after raise: " + employee.getSalary());

        System.out.println();
        System.out.println("-------------------");
        System.out.println("Customers");
        System.out.println("-------------------");

        Customer customer = new Customer(456, "Joe", "Carter", LocalDate.parse("2002-03-12"), 550);
//        customer.setFirstName("Joe");

        customer.addAccount(new BankAccount("123", 5000));
        customer.addAccount(new BankAccount("456", -50));

        System.out.println(customer.getFirstName() + " has " + customer.getNumberOfBankAccounts() + " bank account(s).");
        System.out.println(customer.getFirstName() + " is high risk: " + customer.isHighRisk());

    }
}