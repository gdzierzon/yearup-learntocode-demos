package org.yearup.data;

import org.yearup.models.Product;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlProductDao implements ProductDao
{
    private DataSource dataSource;

    public MySqlProductDao(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }


    @Override
    public List<Product> listByCategory(int categoryId)
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

            // use WHILE when you expect multiple rows
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

    @Override
    public Product getById(int productId)
    {
        String sql = """
                SELECT productId AS id
                    , productName AS name
                    , unitPrice AS price
                FROM products
                WHERE productId = ?;
                """;

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        )
        {
            statement.setInt(1, productId);

            ResultSet row = statement.executeQuery();

            // use IF when you expect only a single row
            if (row.next())
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

                return product;
            }

        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return null;
    }
}
