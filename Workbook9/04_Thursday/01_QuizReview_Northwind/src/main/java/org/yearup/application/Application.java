package org.yearup.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.yearup.data.ProductDao;
import org.yearup.models.Product;

import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class Application implements CommandLineRunner
{
    private Scanner userInput = new Scanner(System.in);

    private ProductDao productDao;

    @Autowired
    public Application(ProductDao productDao)
    {
        this.productDao = productDao;
    }

    @Override
    public void run(String... args) throws Exception
    {

        while(true)
        {
            System.out.print("Enter a product name: ");
            String name = userInput.nextLine();

            if(name.equalsIgnoreCase("exit"))
            {
                System.out.println("good bye");
                return;
            }

            try
            {
                var products = productDao.searchByName(name);

                for(var product: products)
                {
                    System.out.println(product.getName());
                }
            }
            catch (Exception ex)
            {
                System.out.println("something went wrong - try again");
                System.out.println();
            }
        }

    }


}
