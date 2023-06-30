package org.yearup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.yearup.models.*;
import org.yearup.data.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("orders")
@PreAuthorize("isAuthenticated()")
public class OrdersController
{
    private OrderDao orderDao;
    private OrderLineItemDao orderLineItemDao;
    private ShoppingCartDao shoppingCartDao;
    private UserDao userDao;
    private ProfileDao profileDao;

    @Autowired
    public OrdersController(OrderDao orderDao, OrderLineItemDao orderLineItemDao, ShoppingCartDao shoppingCartDao, UserDao userDao, ProfileDao profileDao)
    {
        this.orderDao = orderDao;
        this.orderLineItemDao = orderLineItemDao;
        this.shoppingCartDao = shoppingCartDao;
        this.userDao = userDao;
        this.profileDao = profileDao;
    }

    @PostMapping()
    public Order create(Principal principal)
    {
        try
        {
            String userName = principal.getName();
            User user = userDao.getByUserName(userName);
            Profile profile = profileDao.getByUserId(user.getId());

            ShoppingCart cart = shoppingCartDao.getByUserId(user.getId());

            if(cart.getItems().size() == 0)
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Your Cart is empty.");

            // create the new order
            Order order = new Order(0, user.getId(), LocalDate.now(), profile.getAddress(), profile.getCity(), profile.getState(), profile.getZip(), cart.getTotal());
            order = orderDao.create(order);

            // convert each cart item into an order line item
            for (var item : cart.getItems().values())
            {
                OrderLineItem lineItem = new OrderLineItem(0, order.getOrderId(), item.getProductId(), item.getProduct().getPrice(), item.getQuantity(), item.getDiscountPercent());
                lineItem = orderLineItemDao.create(lineItem);

                order.addItem(lineItem);
            }

            // clear cart after converting to order
            shoppingCartDao.clearCart(user.getId());

            return order;
        }
        catch(Exception ex)
        {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "There was an error creating your order.");
        }
    }

    @GetMapping()
    public List<Order> getOrderList(Principal principal)
    {
        try
        {
            String userName = principal.getName();
            User user = userDao.getByUserName(userName);

            return orderDao.getByUserId(user.getId());
        }
        catch(Exception ex)
        {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Oops... our bad.");
        }
    }

    @GetMapping("{orderId}")
    public Order getOrderDetails(@PathVariable int orderId, Principal principal)
    {
        try
        {
            String userName = principal.getName();
            User user = userDao.getByUserName(userName);

            Order order = orderDao.getById(orderId);

            if (order == null)
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The Order ID was not found.");

            if (order.getUserId() != user.getId())
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This is an invalid Order ID for the current user.");

            List<OrderLineItem> items = orderLineItemDao.getByOrderId(order.getOrderId());
            order.setLineItems(items);

            return order;
        }
        catch(Exception ex)
        {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Oops... our bad.");
        }
    }
}
