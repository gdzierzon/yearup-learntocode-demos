package org.yearup.data.mysql;

import org.springframework.stereotype.Component;
import org.yearup.models.OrderLineItem;
import org.yearup.data.OrderLineItemDao;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class MySqlOrderLineItemDao extends MySqlDaoBase implements OrderLineItemDao
{
    public MySqlOrderLineItemDao(DataSource dataSource)
    {
        super(dataSource);
    }

    @Override
    public List<OrderLineItem> getByOrderId(int orderId)
    {
        List<OrderLineItem> lineItems = new ArrayList<>();

        String sql = "SELECT order_line_item_id " +
                "   , order_id " +
                "   , product_id " +
                "   , sales_price " +
                "   , quantity " +
                "   , discount " +
                " FROM order_line_items " +
                " WHERE order_id = ?; ";


        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, orderId);

            ResultSet row = statement.executeQuery();

            while (row.next())
            {
                OrderLineItem lineItem = mapRow(row);
                lineItems.add(lineItem);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return lineItems;
    }

    @Override
    public OrderLineItem getById(int orderLineItemId)
    {
        String sql = "SELECT order_line_item_id " +
                "   , order_id " +
                "   , product_id " +
                "   , sales_price " +
                "   , quantity " +
                "   , discount " +
                " FROM order_line_items " +
                " WHERE order_line_item_id = ?; ";


        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, orderLineItemId);

            ResultSet row = statement.executeQuery();

            while (row.next())
            {
                OrderLineItem lineItem = mapRow(row);
                return lineItem;
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public OrderLineItem create(OrderLineItem orderLineItem)
    {
        String sql = "INSERT INTO order_line_items(order_id, product_id, sales_price, quantity, discount) " +
                " VALUES (?,?,?,?,?);";

        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, orderLineItem.getOrderId());
            statement.setInt(2, orderLineItem.getProductId());
            statement.setBigDecimal(3, orderLineItem.getSalesPrice());
            statement.setInt(4, orderLineItem.getQuantity());
            statement.setBigDecimal(5, orderLineItem.getDiscount());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                // Retrieve the generated keys
                ResultSet generatedKeys = statement.getGeneratedKeys();

                if (generatedKeys.next()) {
                    // Retrieve the auto-incremented ID
                    int id = generatedKeys.getInt(1);

                    // get the newly inserted category
                    return getById(id);
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
    public void update(int orderLineItemId, OrderLineItem orderLineItem)
    {
        String sql = "UPDATE order_line_items " +
                " SET order_id = ? " +
                "   , product_id = ? " +
                "   , sales_price = ? " +
                "   , quantity = ? " +
                "   , discount = ? " +
                " WHERE order_line_item_id = ?;";

        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, orderLineItem.getOrderId());
            statement.setInt(2, orderLineItem.getProductId());
            statement.setBigDecimal(3, orderLineItem.getSalesPrice());
            statement.setInt(4, orderLineItem.getQuantity());
            statement.setBigDecimal(5, orderLineItem.getDiscount());
            statement.setInt(6, orderLineItemId);

            statement.executeUpdate();

        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int orderLineItemId)
    {
        String sql = "DELETE FROM order_line_items " +
                    " WHERE order_line_item_id = ?;";

        try (Connection connection = getConnection())
        {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, orderLineItemId);

            statement.executeUpdate();

        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    private OrderLineItem mapRow(ResultSet row) throws SQLException
    {
        int lineItemId = row.getInt("order_line_item_id");
        int orderId = row.getInt("order_id");
        int productId = row.getInt("product_id");
        BigDecimal salesPrice = row.getBigDecimal("sales_price");
        int quantity = row.getInt("quantity");
        BigDecimal discount = row.getBigDecimal("discount");

        OrderLineItem lineItem = new OrderLineItem()
        {{
            setOrderLineItemId(lineItemId);
            setOrderId(orderId);
            setProductId(productId);
            setSalesPrice(salesPrice);
            setQuantity(quantity);
            setDiscount(discount);
        }};

        return lineItem;
    }
}
