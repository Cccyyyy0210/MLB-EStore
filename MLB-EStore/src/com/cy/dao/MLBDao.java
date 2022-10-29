package com.cy.dao;

import com.cy.domain.MLB;

import java.sql.SQLException;
import java.util.List;

public interface MLBDao {
    public int addMLB(MLB mlb) throws SQLException;

    public int deleteMLBById(Integer id) throws SQLException;

    public int updateMLB(MLB mlb) throws SQLException;

    public MLB queryMLBById(Integer id) throws SQLException;

    public List<MLB> queryMLBs() throws SQLException;

    Integer queryForPageTotalCount() throws SQLException;

    List<MLB> queryForPageItems(int begin, int pageSize) throws SQLException;

    Integer queryForPageTotalCountByPrice(int min, int max) throws SQLException;

    List<MLB> queryForPageItemsByPrice(int begin, int pageSize, int min, int max) throws SQLException;
}
