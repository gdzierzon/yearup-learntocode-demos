package org.yearup;

import org.yearup.models.Country;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application
{
    private Scanner userInput = new Scanner(System.in);

    public void run() throws SQLException
    {
        System.out.println("Welcome to THE WORLD!!!");
        System.out.println();

        while(true)
        {
            String choice = getSelection();
            System.out.println();

            switch (choice)
            {
                case "1":
                    displayCountries();
                    break;
                case "2":
                    System.out.println("cities");
                    break;
                case "0":
                    System.out.println("Come again");
                    return;
            }
        }
    }

    private String getSelection()
    {
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println("1) Display all Countries");
        System.out.println("2) Search Cities by Country");
        System.out.println("0) Exit");
        System.out.print("Please make your selection: ");

        return userInput.nextLine().strip();
    }

    public void displayCountries() throws SQLException
    {
        var countries = getCountries();

        for(var country : countries)
        {
            System.out.printf("%s - %s \n", country.getCode(), country.getName());
        }
    }

    public List<Country> getCountries() throws  SQLException
    {
        List<Country> countries = new ArrayList<>();

        // 1 - open connection
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root","P@ssw0rd");

        // 2 - build and execute query
        String sql = "SELECT code " +
                    "   , name " +
                    "   , continent " +
                    "   , region " +
                    "   , surfaceArea " +
                    "   , indepYear " +
                    "   , gnpOld " +
                    " FROM country; ";

        Statement statement = connection.createStatement();

        ResultSet row = statement.executeQuery(sql);

        while(row.next())
        {
            String code = row.getString("code");
            String name = row.getString("name");
            String continent = row.getString("continent");
            int independenceYear = row.getInt("indepYear");
            boolean hasIndependenceYear = !row.wasNull();
            BigDecimal gnpOld = row.getBigDecimal("gnpOld");

            // add each country to the list
            // create a new Country
            Country country = new Country()
            {{
                // use object initializer setters
                setCode(code);
                setName(name);
                setContinent(continent);
                if(hasIndependenceYear) {
                    setIndependenceYear(independenceYear);
                }
                setGnpOld(gnpOld);
            }};

            countries.add(country);
        }

        // 3 - close the connection
        row.close();
        statement.close();
        connection.close();

        return countries;
    }
}
