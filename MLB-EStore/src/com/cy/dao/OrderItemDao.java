package com.cy.dao;

import com.cy.domain.OrderItem;

import java.sql.SQLException;

public interface OrderItemDao {
    //保存订单中的商品
    public int saveOrderItem(OrderItem orderItem) throws SQLException;

}
