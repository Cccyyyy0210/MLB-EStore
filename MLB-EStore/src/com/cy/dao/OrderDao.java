package com.cy.dao;

import com.cy.domain.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderDao {
    public int saveOrder(Order order) throws SQLException;

    List<Order> queryMyOrders(Integer userId) throws SQLException;

    Order queryOrderDetailById(String orderId) throws SQLException;

    List<Order> queryAllOrders() throws SQLException;

    public int changeOrderStatus(Order order, int status) throws SQLException;
}
