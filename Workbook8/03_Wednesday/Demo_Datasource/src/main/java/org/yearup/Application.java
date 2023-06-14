package org.yearup;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Application
{

    private DataSource dataSource;

    public Application(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    public void run()
    {
        displayProducts(3);
        System.out.println();
        displayProducts(4);
    }

    private void displayProducts(int categoryId)
    {
        var products = getProductsByCategory(categoryId);

        for(var product : products)
        {
            System.out.printf("%s - $%.2f \n", product.getName(), product.getPrice());
        }
    }
    private List<Product> getProductsByCategory(int categoryId)
    {
        List<Product> products = new ArrayList<>();

        String sql = """
                SELECT productId AS id
                    , productName AS name
                    , unitPrice AS price
                FROM products
                WHERE categoryId = ?;
                """;

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        )
        {
            statement.setInt(1, categoryId);

            ResultSet row = statement.executeQuery();

            while (row.next())
            {
                int id = row.getInt("id");
                String name = row.getString("name");
                BigDecimal price = row.getBigDecimal("price");

                Product product = new Product()
                {{
                    setId(id);
                    setName(name);
                    setPrice(price);
                }};

                products.add(product);
            }

        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return products;
    }
}
