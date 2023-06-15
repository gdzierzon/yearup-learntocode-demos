package org.yearup;

import org.apache.commons.dbcp2.BasicDataSource;
import org.yearup.application.Application;
import org.yearup.data.MySqlProductDao;
import org.yearup.data.ProductDao;

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

        ProductDao productDao = new MySqlProductDao(dataSource);

        Application app = new Application(productDao);
        app.run();
    }

}