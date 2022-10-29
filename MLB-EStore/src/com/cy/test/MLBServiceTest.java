package com.cy.test;

import com.cy.domain.MLB;
import com.cy.service.MLBService;
import com.cy.service.impl.MLBServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class MLBServiceTest {
    MLBService mlbService = new MLBServiceImpl();

    @Test
    public void addMLB() throws SQLException {
        // mlbDao.addMLB(new MLB(null,"男女帽子复古老花硬顶棒球帽","休闲春季新款纽约洋基队浅蓝色",new BigDecimal(362),100,100,"static/img/mlb6.jpg"));

        mlbService.addMLB(new MLB(null, "复古NYLA遮阳防晒渔夫帽", "牛年春夏新款纽约洋基队/天蓝色", new BigDecimal(469), 100, 100, "static/img/mlb7.jpg"));
    }

    @Test
    public void deleteMLBById() throws SQLException {
        mlbService.deleteMLBById(11);
    }

    @Test
    public void updateMLB() throws SQLException {
        mlbService.updateMLB(new MLB(9, "复古遮阳防晒渔夫帽", "牛年春夏新款纽约洋基队/天蓝色", new BigDecimal(469), 100, 100, "static/img/mlb7.jpg"));

    }

    @Test
    public void queryById() throws SQLException {
        System.out.println(mlbService.queryById(12));
    }

    @Test
    public void queryMLBs() throws SQLException {
        List<MLB> list = mlbService.queryMLBs();
        for (MLB mlb : list) {
            System.out.println(mlb);
        }
    }

    @Test
    public void page() {
    }

    @Test
    public void pageByPrice() {
    }
}