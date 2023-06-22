package org.yearup;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.yearup.application.Application;
import org.yearup.data.MySqlProductDao;
import org.yearup.data.ProductDao;

@SpringBootApplication
public class Main
{
    public static void main(String[] args)
    {
        SpringApplication.run(Main.class, args);

    }

}