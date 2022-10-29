package com.cy.dao.impl;

import com.cy.dao.OrderDao;
import com.cy.domain.Order;

import java.sql.SQLException;
import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao {

    @Override
    public int saveOrder(Order order) throws SQLException {
        String sql = "insert into t_order(`order_id`,`create_time`,`total_money`,`status`,`user_id`) values(?,?,?,?,?)";
        return update(sql, order.getOrder_id(), order.getCreate_time(), order.getPrice(), order.getStatus(), order.getUser_id());

    }

    @Override
    public List<Order> queryMyOrders(Integer userId) throws SQLException {
        String sql = "select * from t_order where `user_id` = ?";
        return queryForList(Order.class, sql, userId);
    }

    @Override
    public Order queryOrderDetailById(String orderId) throws SQLException {
        String sql = "select * from t_order where `order_id` = ?";
        return queryForOne(Order.class, sql, orderId);
    }

    @Override
    public List<Order> queryAllOrders() throws SQLException {
        String sql = "select * from t_order";
        return queryForList(Order.class, sql);
    }

    @Override
    public int changeOrderStatus(Order order, int status) throws SQLException {
        String sql = "update  t_order set `order_id`=?,`createTime`=?,`total_money`=?,`status`=?,`userId`  where orderId = ?";
        return update(sql, order.getOrder_id(), order.getCreate_time(), order.getPrice(), order.getStatus(), order.getUser_id());
    }
}
