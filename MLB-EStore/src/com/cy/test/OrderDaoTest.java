package com.cy.test;

import com.cy.dao.OrderDao;
import com.cy.dao.impl.OrderDaoImpl;
import com.cy.domain.Order;
import org.junit.Test;

import java.math.BigDecimal;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class OrderDaoTest {
    private OrderDao orderDao = new OrderDaoImpl();

    @Test
    public void saveOrder() throws SQLException {
        orderDao.saveOrder(new Order("1234567890", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), new BigDecimal(1376), 0, 2));

    }

    @Test
    public void queryMyOrders() throws SQLException {
        System.out.println(orderDao.queryMyOrders(2));

    }

    @Test
    public void queryOrderDetailById() {

    }

    @Test
    public void queryAllOrders() {
    }

    @Test
    public void changeOrderStatus() {
    }
}