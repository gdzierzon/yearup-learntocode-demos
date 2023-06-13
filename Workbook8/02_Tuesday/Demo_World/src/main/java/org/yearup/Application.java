package org.yearup;

import org.yearup.models.City;
import org.yearup.models.Country;
import org.yearup.utilities.Logger;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application
{
    private static final String dbUrl = "jdbc:mysql://localhost:3306/world";
    private static final String username = "root";
    private static final String password = "P@ssw0rd";

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
                    displayCities();
                    break;
                case "3":
                    addCity();
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
        System.out.println("3) Add a City");
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

    private List<Country> getCountries() throws  SQLException
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

    public void displayCities()
    {
        System.out.println();
        System.out.print("Please enter the country code: ");
        String countryCode = userInput.nextLine().strip().toUpperCase();

        var cities = listCitiesByCountry(countryCode);

        for(var city : cities)
        {
            System.out.printf("%-5d %-25s %-15.2f \n", city.getId(), city.getName(), city.getPopulation());
        }

    }

    private List<City> listCitiesByCountry_statement(String countryCode)
    {
        List<City> cities = new ArrayList<>();

        String sql = "SELECT id \n" +
                "   , name \n" +
                "   , countryCode \n" +
                "   , district \n" +
                "   , population \n" +
                " FROM city \n" +
                " WHERE countryCode = '" + countryCode + "';";

        System.out.println();
        System.out.println(sql);
        System.out.println();

        // 1 - get and open the connection
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","P@ssw0rd");
            Statement statement = connection.createStatement();
        )
        {
            // 2 - execute the sql
            ResultSet row = statement.executeQuery(sql);

            while(row.next())
            {
                int id = row.getInt(1);
                String name = row.getString(2);
                String country = row.getString(3);
                String district = row.getString(4);
                double population = row.getDouble(5);

                City city = new City(){{
                    setId(id);
                    setName(name);
                    setCountryCode(country);
                    setDistrict(district);
                    setPopulation(population);
                }};

                cities.add(city);
            }


            // 3 - close the connection
            // no need to close the connection - because the try block auto-closes it
        }
        catch (SQLException ex)
        {
            Logger.logError(ex);
        }


        return cities;
    }

    private List<City> listCitiesByCountry(String countryCode)
    {
        List<City> cities = new ArrayList<>();

        String sql = "SELECT id \n" +
                    "   , name \n" +
                    "   , countryCode \n" +
                    "   , district \n" +
                    "   , population \n" +
                    " FROM city \n" +
                    " WHERE countryCode = ?;";

        System.out.println();
        System.out.println(sql);
        System.out.println();

        // 1 - get and open the connection
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","P@ssw0rd");
            PreparedStatement statement = connection.prepareStatement(sql);
        )
        {
            // 2 - execute the sql
            statement.setString(1,countryCode);
            ResultSet row = statement.executeQuery();

            while(row.next())
            {
                int id = row.getInt(1);
                String name = row.getString(2);
                String country = row.getString(3);
                String district = row.getString(4);
                double population = row.getDouble(5);

                City city = new City(){{
                    setId(id);
                    setName(name);
                    setCountryCode(country);
                    setDistrict(district);
                    setPopulation(population);
                }};

                cities.add(city);
            }


            // 3 - close the connection
            // no need to close the connection - because the try block auto-closes it
        }
        catch (SQLException ex)
        {
            Logger.logError(ex);
        }


        return cities;
    }

    public void addCity()
    {
        String name;
        String country;
        String district;
        double population;

        System.out.println();
        System.out.println("Add City");
        System.out.println("------------");

        System.out.print("Enter the city name: ");
        name = userInput.nextLine().strip();
        System.out.print("Enter the country code: ");
        country = userInput.nextLine().strip();
        System.out.print("Enter the district name: ");
        district = userInput.nextLine().strip();
        System.out.print("Enter the population: ");
        population = userInput.nextDouble();
        userInput.nextLine();

        // start inserting data here

        String sql = """
                INSERT INTO city
                (
                    name
                    , countryCode
                    , district
                    , population
                )
                VALUES (?, ?, ?, ?);
                """;

        try(Connection connection = DriverManager.getConnection(dbUrl, username, password);
            PreparedStatement statement = connection.prepareStatement(sql)
            )
        {
            statement.setString(1, name);
            statement.setString(2, country);
            statement.setString(3, district);
            statement.setDouble(4, population);

            statement.executeUpdate();

            System.out.println();
            System.out.printf("%s was added to the database. \n", name);
        }
        catch(SQLException ex)
        {
            Logger.logError(ex);
        }

    }
}
