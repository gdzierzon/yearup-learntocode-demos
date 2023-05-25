package org.yearup.application;

import org.yearup.datastorage.ProductManager;
import org.yearup.models.Product;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Store
{
    Scanner input = new Scanner(System.in);

    List<Product> inventory;

    public Store()
    {
        inventory = ProductManager.loadProducts();
    }

    public void run()
    {

        while(true)
        {
            displayHome();
            String choice = promptString("Please select an option: ");

            switch (choice)
            {
                case "1":
                    displayAllProducts();
                    break;
                case "2":
                    displayByCategory();
                    break;
                case "3":
                    displayMostExpensive();
                    break;
                case "4":
                    displayAveragePrice();
                    break;
                case "0":
                    System.out.println("Good bye");
                    return;
                default:
                    System.out.println("Please select a valid option.");
                    break;
            }

        }
    }

    public String promptString(String message)
    {
        System.out.print(message);
        return input.nextLine().strip();
    }

    public void displayHome()
    {
        System.out.println();
        System.out.println("What do you want to do?");
        System.out.println("  1) Display All Products");
        System.out.println("  2) Filter by Category");
        System.out.println("  3) Most Expensive Product");
        System.out.println("  4) Average Price");
        System.out.println("  0) Exit");
    }

    public void displayAllProducts()
    {
        System.out.println();
        System.out.println("All Products");
        System.out.println("-".repeat(65));

//        for(Product product : inventory)
//        {
//            System.out.println(product);
//        }

        inventory.forEach( product -> {
            System.out.println(product.toString());
        });
    }

    public void displayByCategory()
    {
        System.out.println();
        System.out.println("Filter By Category");
        System.out.println("-".repeat(65));

        displayAllCategories();
        String category = promptString("Enter a category name: ");

        List<Product> filteredList;
        filteredList = inventory.stream()
                                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                                .toList();

        System.out.println("-".repeat(65));
        filteredList.forEach(p -> System.out.println(p.toString()));
    }

    public void displayAllCategories()
    {
        // 1 get ONLY the categories - convert a product into a String
        // 2 remove duplicates
        // 3 sort
        List<String> categories = inventory.stream()
                                           .map(p -> p.getCategory())
                                           .distinct()
                                           //.sorted() // regular sort order
                                           .sorted(Comparator.reverseOrder()) // hint to sort reverse
                                           .toList();

        categories.forEach(c -> System.out.println(" - " + c));
    }

    public void displayMostExpensive()
    {
        System.out.println();
        System.out.println("Most Expensive Product");
        System.out.println("-".repeat(65));

        // 1 get all prices
        // 2 sort prices
        // 3 get the highest price

        // find the highest price
        var price = inventory.stream()
                             //.mapToDouble(Product::getPrice)
                             .map(p -> p.getPrice()) // this is the lambda expression version
                             .sorted(Comparator.reverseOrder())
                             .findFirst()// this gets the first element (if there is one) so it is an Optional<Double>
                             .get();// converts the Optional<Double> to Double

        inventory.stream()
                 .filter(p -> p.getPrice() == price)
                 .forEach(p -> System.out.println(p.toString()));
    }

    public void displayAveragePrice()
    {
//        double sum = 0.0;
//
//        for(Product product: inventory)
//        {
//            sum += product.getPrice();
//        }

        var total = inventory.stream()
                .mapToDouble(Product::getPrice)
                .reduce(
                        0.0,
                        (price, sum) -> sum + price
                );

        double average = total / inventory.size();

        System.out.printf("The average price is: $ %.2f \n", average);
    }
}
