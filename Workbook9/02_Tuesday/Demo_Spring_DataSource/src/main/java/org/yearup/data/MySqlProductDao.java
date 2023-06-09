package org.yearup.data;

import org.yearup.models.Product;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;
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

    @Override
    public Product create(Product product)
    {
        String sql = """
                INSERT INTO products
                (
                    ProductName
                    , UnitPrice
                    , CategoryID
                )
                VALUES (?, ?, ?);
                """;
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        )
        {
            statement.setString(1, product.getName());
            statement.setBigDecimal(2, product.getPrice());
            statement.setInt(3, product.getCategoryId());

            statement.executeUpdate();

            // auto incremented keys are returned in a ResultSet
            try(ResultSet key = statement.getGeneratedKeys())
            {
                if(key.next())
                {
                    // get the first (and only) column value
                    // this is the new productId - that was generated by the db
                    int productId = key.getInt(1);
                    return getById(productId);
                }
            }
            catch(Exception ignored){}

        }
        catch (SQLException ex)
        {

        }

        return null;
    }

    @Override
    public void update(int productId, Product product)
    {

        String sql = """
                UPDATE products
                SET ProductName = ?
                    , UnitPrice = ?
                    , CategoryID = ?
                WHERE productId = ?;
                """;
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        )
        {
            statement.setString(1, product.getName());
            statement.setBigDecimal(2, product.getPrice());
            statement.setInt(3, product.getCategoryId());
            statement.setInt(4, productId);

            statement.executeUpdate();

        }
        catch (SQLException ex)
        {

        }
    }

    @Override
    public void delete(int productId)
    {

        String sql = """
                DELETE FROM products
                WHERE productId = ?;
                """;
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        )
        {
            statement.setInt(1, productId);

            statement.executeUpdate();

        }
        catch (SQLException ex)
        {

        }
    }
}
