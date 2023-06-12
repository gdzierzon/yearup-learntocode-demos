package org.yearup;

import java.sql.*;

public class Main
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        // loop through all cities
        // in the database
        // and display ...
        // 1. Kabul - AFG
        // 2. Qandahar - AFG


        /*
        1 - open a connection to the database
        2 - execute a query (and use the data)
        3 - close the connection
         */


        // 1. open my connection
        Connection connection;
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world"
                                                , "root"
                                                , "P@ssw0rd");

        // 2. build and execute our query
        String sql = " SELECT ID " +
                     "   , Name " +
                     "   , CountryCode " +
                     " FROM city; ";

        // create a statement object from the connection
        Statement statement = connection.createStatement();

        // this executes the query and returns the results
        ResultSet row = statement.executeQuery(sql);

        // loop through the rows
        while(row.next())
        {
            int id = row.getInt("ID");
            String name = row.getString("Name");
            String country = row.getString("CountryCode");

            System.out.printf("%d: %s - %s \n", id, name, country);
        }



        // 3. close the connection
        connection.close();

    }
}