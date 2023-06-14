package org.yearup;

import org.apache.commons.dbcp2.BasicDataSource;

public class Main
{
    public static void main(String[] args)
    {
        String baseUrl = "jdbc:mysql://localhost:3306/northwind";
        String username = "root";
        String password = "P@ssw0rd";

        BasicDataSource dataSource = new BasicDataSource()
        {{
            setUrl(baseUrl);
            setUsername(username);
            setPassword(password);
        }};

        Application app = new Application(dataSource);
        app.run();
    }

}