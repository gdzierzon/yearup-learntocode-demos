package org.yearup.application;

import org.yearup.data.ProductDao;

import java.util.Scanner;

public class Application
{
    private Scanner userInput = new Scanner(System.in);

    private ProductDao productDao;

    public Application(ProductDao productDao)
    {
        this.productDao = productDao;
    }

    public void run()
    {
        while(true)
        {
            String choice = getSelection();

            switch (choice)
            {
                case "1":
                    displayProducts();
                    break;
                case "2":
                    displayProductDetails();
                    break;
                case "0":
                    System.out.println("goodbye");
                    return;
            }
        }
    }

    private String getSelection()
    {
        System.out.println();
        System.out.println("What do you want?");
        System.out.println("1) List Products by CategoryID");
        System.out.println("2) Display Product Details");
        System.out.print("Please make a selection: ");
        return userInput.nextLine().strip();
    }

    private void displayProducts()
    {
        System.out.println();
        System.out.print("Enter a category id: ");
        int categoryId = userInput.nextInt();
        userInput.nextLine();

        var products = productDao.listByCategory(categoryId);

        for(var product : products)
        {
            System.out.printf("%d: %s \n", product.getId(), product.getName());
        }
    }

    private void displayProductDetails()
    {
        System.out.println();
        System.out.print("Enter a product id: ");
        int productId = userInput.nextInt();
        userInput.nextLine();

        // get the product FROM THE DAO
        var product = productDao.getById(productId);

        System.out.println();
        System.out.println("ID: " + product.getId());
        System.out.println("Name: " + product.getName());
        System.out.println("Price: $" + product.getPrice());
        System.out.println();
    }

}
