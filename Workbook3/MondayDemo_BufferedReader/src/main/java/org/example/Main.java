package org.example;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        // open the file stream (fileReader
        FileReader fileReader = new FileReader("products.csv");
        // create a Buffered Reader
        BufferedReader reader = new BufferedReader(fileReader);

        // skip the first line
        reader.readLine();

        // read each line
        String line = reader.readLine();
        while(line != null)
        {
            // 1. split the line on the pipe |
            String[] columns = line.split("\\|");

            // 2. create variables for each column
            String sku = columns[0];
            String name = columns[1];
            double price = Double.parseDouble(columns[2]);
            String department = columns[3];

            // 3. create a new product with values from the row
            Product product = new Product(sku, name, price, department);

            // 4. use the product
            System.out.println(product.getName() + " - $" + product.getPrice());


            line = reader.readLine();
        }

        // close the reader
        reader.close();
    }
}