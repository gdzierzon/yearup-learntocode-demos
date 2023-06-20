package org.yearup;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.yearup.data.ProductDao;

public class Main
{
    private static ProductDao dao;

    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        dao = context.getBean(ProductDao.class);

        while(true)
        {
            // ask user what they want to do?

            // 1 - list all products
            
            // 2 - add a new product

            // 0 - exit
        }
    }

}