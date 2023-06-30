package org.yearup.data;

import org.yearup.models.Order;

import java.util.List;

public interface OrderDao
{
    List<Order> getByUserId(int userId );
    Order getById(int orderId);
    Order create(Order order);
    void update(int orderId, Order order);
    void delete(int orderId);
}
