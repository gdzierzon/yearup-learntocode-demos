package org.yearup.data.mysql;

import org.springframework.stereotype.Component;
import org.yearup.models.Product;
import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;
import org.yearup.data.ShoppingCartDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MySqlShoppingCartDao extends MySqlDaoBase implements ShoppingCartDao
{
    public MySqlShoppingCartDao(DataSource dataSource)
    {
        super(dataSource);
    }


    @Override
    public boolean hasProduct(int userId, int productId)
    {
        return getQuantity(userId, productId) > 0;
    }

    @Override
    public int getQuantity(int userId, int productId)
    {
        String sql = "SELECT quantity " +
                "FROM shopping_cart " +
                "WHERE user_id = ? " +
                "   AND product_id = ?;";

        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            statement.setInt(2, productId);

            ResultSet row = statement.executeQuery();

            // check if there are any rows
            if(row.next()) return row.getInt("quantity");
        }
        catch (SQLException e)
        {
        }

        return 0;
    }

    @Override
    public ShoppingCart addProduct(int userId, int productId)
    {
        return addProduct(userId, productId, 1);
    }

    @Override
    public ShoppingCart addProduct(int userId, int productId, int quantity)
    {
        if(hasProduct(userId, productId))
        {
            int currentQuantity = getQuantity(userId, productId);
            return updateProductQuantity(userId, productId, currentQuantity + 1);
        }

        String sql = "INSERT INTO shopping_cart (user_id, product_id, quantity) " +
                "VALUES (?,?,?)";

        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            statement.setInt(2, productId);
            statement.setInt(3, quantity);

            statement.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return getByUserId(userId);
    }

    @Override
    public ShoppingCart updateProductQuantity(int userId, int productId, int quantity)
    {
        if(quantity <= 0)
        {
            return removeProduct(userId, productId);
        }

        String sql = "UPDATE shopping_cart " +
                "SET quantity = ? " +
                "WHERE user_id = ?" +
                "   AND product_id = ?;";

        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, quantity);
            statement.setInt(2, userId);
            statement.setInt(3, productId);

            statement.executeUpdate();
        }
        catch (SQLException e)
        {
        }

        return getByUserId(userId);
    }

    @Override
    public ShoppingCart removeProduct(int userId, int productId)
    {
        String sql = "DELETE FROM shopping_cart " +
                     "WHERE user_id = ?" +
                     "   AND product_id = ?;";

        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            statement.setInt(2, productId);

            statement.executeUpdate();
        }
        catch (SQLException e)
        {
        }

        return getByUserId(userId);
    }

    @Override
    public ShoppingCart clearCart(int userId)
    {
        String sql = "DELETE FROM shopping_cart " +
                     "WHERE user_id = ?;";

        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);

            statement.executeUpdate();
        }
        catch (SQLException e)
        {
        }

        return getByUserId(userId);
    }

    @Override
    public ShoppingCart getByUserId(int userId)
    {
        ShoppingCart cart = new ShoppingCart();

        String sql = "SELECT p.* " +
                     "   , c.quantity " +
                     "FROM products AS p " +
                     "INNER JOIN shopping_cart as c " +
                     "   ON p.product_id = c.product_id " +
                     "WHERE c.user_id = ?; ";

        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);

            ResultSet row = statement.executeQuery();

            while (row.next())
            {
                Product product = MySqlProductDao.mapRow(row);
                int quantity = row.getInt("quantity");
                var item = new ShoppingCartItem()
                {{
                    setProduct(product);
                    setQuantity(quantity);
                }};

                cart.add(item);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return cart;
    }
}
