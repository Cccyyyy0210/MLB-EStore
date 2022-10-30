package com.cy.service;

import com.cy.domain.Cart;
import com.cy.domain.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderService {
    public String createOrder(Cart cart, Integer userId) throws SQLException;

    List<Order> myOrders(Integer userId) throws SQLException;

    Order orderDetails(String orderId) throws SQLException;

    List<Order> allOrders() throws SQLException;

    int sendOrder(String orderId) throws SQLException;

    int receiveOrder(String orderId) throws SQLException;
}
