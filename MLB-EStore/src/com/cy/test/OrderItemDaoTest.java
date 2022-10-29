package com.cy.test;

import com.cy.dao.OrderItemDao;
import com.cy.dao.impl.OrderItemDaoImpl;
import com.cy.domain.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class OrderItemDaoTest {
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();

    @Test
    public void saveOrderItem() throws SQLException {
        orderItemDao.saveOrderItem(new OrderItem(null, "NY渔夫帽纽约洋基队", 1, new BigDecimal(439), new BigDecimal(439), "1234567890"));
        orderItemDao.saveOrderItem(new OrderItem(null, "软顶棒球帽波士顿队/米黄色", 2, new BigDecimal(299), new BigDecimal(598), "1234567890"));
        orderItemDao.saveOrderItem(new OrderItem(null, "灯芯绒棒球帽波士顿红袜队/酒红色", 1, new BigDecimal(339), new BigDecimal(339), "1234567890"));
    }
}