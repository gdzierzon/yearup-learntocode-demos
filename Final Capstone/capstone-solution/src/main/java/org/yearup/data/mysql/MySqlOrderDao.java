package org.yearup.data.mysql;

import org.springframework.stereotype.Component;
import org.yearup.models.Order;
import org.yearup.data.OrderDao;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class MySqlOrderDao extends MySqlDaoBase implements OrderDao
{
    public MySqlOrderDao(DataSource dataSource)
    {
        super(dataSource);
    }

    @Override
    public List<Order> getByUserId(int userId)
    {
        List<Order> orders = new ArrayList<>();

        String sql = "SELECT order_id " +
                    "   , user_id" +
                    "   , date" +
                    "   , address" +
                    "   , city" +
                    "   , state" +
                    "   , zip " +
                    "   , shipping_amount " +
                    " FROM orders " +
                    " WHERE user_id = ? " +
                    " ORDER BY date DESC " +
                    "   , order_id DESC; ";


        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);

            ResultSet row = statement.executeQuery();

            while (row.next())
            {
                Order order = mapRow(row);
                orders.add(order);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return orders;
    }

    @Override
    public Order getById(int orderId)
    {
        String sql = "SELECT order_id " +
                "   , user_id" +
                "   , date" +
                "   , address" +
                "   , city" +
                "   , state" +
                "   , zip " +
                "   , shipping_amount " +
                " FROM orders " +
                " WHERE order_id = ?; ";


        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, orderId);

            ResultSet row = statement.executeQuery();

            while (row.next())
            {
                Order order = mapRow(row);
                return order;
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Order create(Order order)
    {
        String sql = "INSERT INTO orders(user_id, date, address, city, state, zip, shipping_amount) " +
            " VALUES (?, ?, ?, ?, ?, ?, ?);";

        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, order.getUserId());
            statement.setDate(2, Date.valueOf(order.getOrderDate()));
            statement.setString(3, order.getAddress());
            statement.setString(4, order.getCity());
            statement.setString(5, order.getState());
            statement.setString(6, order.getZip());
            statement.setBigDecimal(7, order.getShippingAmount());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                // Retrieve the generated keys
                ResultSet generatedKeys = statement.getGeneratedKeys();

                if (generatedKeys.next()) {
                    // Retrieve the auto-incremented ID
                    int orderId = generatedKeys.getInt(1);

                    // get the newly inserted category
                    return getById(orderId);
                }
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void update(int orderId, Order order)
    {
        String sql = "UPDATE orders " +
                " SET user_id = ?" +
                "   , date = ? " +
                "   , address = ? " +
                "   , city = ? " +
                "   , state = ? " +
                "   , zip = ? " +
                "   , shipping_amount = ? " +
                " WHERE order_id = ?;";

        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, order.getUserId());
            statement.setDate(2, Date.valueOf(order.getOrderDate()));
            statement.setString(3, order.getAddress());
            statement.setString(4, order.getCity());
            statement.setString(5, order.getZip());
            statement.setBigDecimal(6, order.getShippingAmount());
            statement.setInt(7, orderId);

            statement.executeUpdate();

        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int orderId)
    {
        String sql = "DELETE FROM orders " +
                " WHERE order_id = ?;";

        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, orderId);

            statement.executeUpdate();

        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    private Order mapRow(ResultSet row) throws SQLException
    {
        int orderId = row.getInt("order_id");
        int userId = row.getInt("user_id");
        LocalDate date = row.getDate("date").toLocalDate();
        String address = row.getString("address");
        String city = row.getString("city");
        String state = row.getString("state");
        String zip = row.getString("zip");
        BigDecimal shippingAmount = row.getBigDecimal("shipping_amount");

        Order order = new Order()
        {{
            setOrderId(orderId);
            setUserId(userId);
            setOrderDate(date);
            setAddress(address);
            setCity(city);
            setState(state);
            setZip(zip);
            setShippingAmount(shippingAmount);
        }};

        return order;
    }
}
