package com.cy.service.impl;

import com.cy.dao.OrderDao;
import com.cy.dao.impl.OrderDaoImpl;
import com.cy.domain.Cart;
import com.cy.domain.Order;
import com.cy.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {
        return null;
    }

    @Override
    public List<Order> myOrders(Integer userId) {
        return null;
    }

    @Override
    public Order orderDetails(String orderId) {
        return null;
    }

    @Override
    public List<Order> allOrders() {
        return null;
    }

    @Override
    public int sendOrder(String orderId) {
        return 0;
    }

    @Override
    public int receiveOrder(String orderId) {
        return 0;
    }
}
