package com.cy.service;

import com.cy.domain.MLB;
import com.cy.domain.Page;


import java.sql.SQLException;
import java.util.List;

public interface MLBService {
    public void addMLB(MLB mlb) throws SQLException;

    public void deleteMLBById(Integer id) throws SQLException;

    public void updateMLB(MLB mlb) throws SQLException;

    public MLB queryById(Integer id) throws SQLException;

    public List<MLB> queryMLBs() throws SQLException;

    Page<MLB> page(int pageNo, int pageSize) throws SQLException;

    Page<MLB> pageByPrice(int pageNo, int pageSize, int min, int max) throws SQLException;
}
