package com.cy.test;

import com.cy.dao.MLBDao;
import com.cy.dao.impl.MLBDaoImpl;
import com.cy.domain.MLB;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class MLBDaoTest {
    MLBDao mlbDao = new MLBDaoImpl();

    @Test
    public void addMLB() throws SQLException {
        mlbDao.addMLB(new MLB(null, "男女帽子复古老花硬顶棒球帽", "休闲春季新款纽约洋基队浅蓝色", new BigDecimal(362), 100, 100, "static/img/mlb6.jpg"));
    }

    @Test
    public void deleteMLBById() throws SQLException {
        mlbDao.deleteMLBById(6);
    }

    @Test
    public void updateMLB() throws SQLException {
        mlbDao.updateMLB(new MLB(7, "男女帽子复古老花硬顶棒球帽", "牛年春夏新款纽约洋基队/天蓝色", new BigDecimal(362), 100, 100, "static/img/mlb.jpg"));

    }

    @Test
    public void queryMLBById() throws SQLException {
        System.out.println(mlbDao.queryMLBById(1));
    }

    @Test
    public void queryMLBs() throws SQLException {
        List<MLB> MLBlist = mlbDao.queryMLBs();
        for (MLB mlb : MLBlist) {
            System.out.println(mlb);
        }

    }

    @Test
    public void queryForPageTotalCount() {
    }

    @Test
    public void queryForPageItems() {
    }

    @Test
    public void queryForPageTotalCountByPrice() {
    }

    @Test
    public void queryForPageItemsByPrice() {
    }
}