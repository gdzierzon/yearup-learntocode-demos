package org.yearup.application;

import org.yearup.data.ProductDao;
import org.yearup.models.Product;

import java.math.BigDecimal;
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
                case "3":
                    addProduct();
                    break;
                case "4":
                    updateProduct();
                    break;
                case "5":
                    deleteProduct();
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
        System.out.println("3) Add a Product");
        System.out.println("4) Update a Product");
        System.out.println("5) Delete a Product");
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
            System.out.printf("%d: %s (%d)\n", product.getId(), product.getName(), product.getUnitsInStock() );
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

        printProduct(product);
    }

    private void printProduct(Product product)
    {
        System.out.println();
        System.out.println("ID: " + product.getId());
        System.out.println("Name: " + product.getName());
        System.out.println("Category: " + product.getCategoryId());
        System.out.printf("Price: $%.2f \n", product.getPrice());
        System.out.println("Stock: " + product.getUnitsInStock());
        System.out.println("On Order: " + product.getUnitsOnOrder());
        System.out.println();
    }


    private void addProduct()
    {
        System.out.println();
        System.out.print("Enter a product name: ");
        String name = userInput.nextLine().strip();

        System.out.print("Enter a product price: ");
        BigDecimal price = new BigDecimal(userInput.nextLine().strip());

        System.out.print("Enter a categoryId: ");
        int categoryId = userInput.nextInt();
        userInput.nextLine();

        Product product = new Product()
        {{
            setName(name);
            setPrice(price);
            setCategoryId(categoryId);
        }};

        // insert product to the database
        var newProduct = productDao.create(product);

        printProduct(newProduct);
    }

    private void updateProduct()
    {
        System.out.println();
        System.out.print("Enter a product id: ");
        int productId = userInput.nextInt();
        userInput.nextLine();

        // get the product FROM THE DAO
        var product = productDao.getById(productId);

        printProduct(product);

        System.out.println();
        System.out.print("Enter the new product name: ");
        String name = userInput.nextLine().strip();

        System.out.print("Enter the new product price: ");
        BigDecimal price = new BigDecimal(userInput.nextLine().strip());

        System.out.print("Enter the new categoryId: ");
        int categoryId = userInput.nextInt();
        userInput.nextLine();

        // set the values
        product.setName(name);
        product.setPrice(price);
        product.setCategoryId(categoryId);


        // update product to the database
        productDao.update(productId, product);

        // get the updated product from the database
        product = productDao.getById(productId);

        // display the new product
        printProduct(product);
    }

    private void deleteProduct()
    {
        System.out.println();
        System.out.print("Enter a product id: ");
        int productId = userInput.nextInt();
        userInput.nextLine();
        // get the product FROM THE DAO
        var product = productDao.getById(productId);

        printProduct(product);

        System.out.println();
        System.out.print("Are you sure? (y/n) ");
        String answer = userInput.nextLine().strip();


        if(answer.equalsIgnoreCase("y"))
        {
            // update product to the database
            productDao.delete(productId);

            System.out.println(product.getName() + " has been deleted.");
        }

    }

}
