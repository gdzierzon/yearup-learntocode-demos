package org.yearup;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.yearup.application.Application;
import org.yearup.data.MySqlProductDao;
import org.yearup.data.ProductDao;

public class Main
{
    public static void main(String[] args)
    {

        // read the connection string information from the configuration file
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        BasicDataSource dataSource = context.getBean(BasicDataSource.class);

        ProductDao productDao = new MySqlProductDao(dataSource);

        Application app = new Application(productDao);
        app.run();
    }

}