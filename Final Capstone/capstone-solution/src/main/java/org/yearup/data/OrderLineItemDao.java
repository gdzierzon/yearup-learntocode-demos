package org.yearup.data;

import org.yearup.models.OrderLineItem;

import java.util.List;

public interface OrderLineItemDao
{
    List<OrderLineItem> getByOrderId(int orderId);
    OrderLineItem getById(int orderLineItemId);
    OrderLineItem create(OrderLineItem orderLineItem);
    void update(int orderLineItemId, OrderLineItem orderLineItem);
    void delete(int orderLineItemId);
}
