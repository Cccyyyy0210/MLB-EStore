package com.cy.dao.impl;

import com.cy.dao.MLBDao;
import com.cy.domain.MLB;

import java.awt.print.Book;
import java.sql.SQLException;
import java.util.List;

public class MLBDaoImpl extends BaseDao implements MLBDao {
    @Override
    public int addMLB(MLB mlb) throws SQLException {
        String sql = "insert into t_mlb(`name`, `description`, `price`, `sales`, `stock`, `img_path`)values (?,?,?,?,?,?)";
        return update(sql, mlb.getName(), mlb.getDescription(), mlb.getPrice(), mlb.getSales(), mlb.getStock(), mlb.getImgPath());
    }

    @Override
    public int deleteMLBById(Integer id) throws SQLException {
        String sql = "delete from t_mlb where id = ?";
        return update(sql, id);
    }

    @Override
    public int updateMLB(MLB mlb) throws SQLException {
        String sql = "update t_mlb set `name`=?, `description`=?, `price`=?, `sales`=?, `stock`=?, img_path=? where id = ?";
        return update(sql, mlb.getName(), mlb.getDescription(), mlb.getPrice(), mlb.getSales(), mlb.getStock(), mlb.getImgPath(), mlb.getId());

    }

    @Override
    public MLB queryMLBById(Integer id) throws SQLException {
        String sql = "select `id`, `name`, `description`, `price`, `sales`, `stock`, img_path from t_mlb where id = ?";
        return queryForOne(MLB.class, sql, id);
    }

    @Override
    public List<MLB> queryMLBs() throws SQLException {
        String sql = "select `id`, `name`, `description`, `price`, `sales`, `stock`, img_path from t_mlb";
        return queryForList(MLB.class, sql);
    }

    @Override
    public Integer queryForPageTotalCount() throws SQLException {
        String sql = "select count(*) from t_mlb";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<MLB> queryForPageItems(int begin, int pageSize) throws SQLException {
        String sql = "select  `id`, `name`, `description`, `price`, `sales`, `stock`, `img_path` img_Path from t_mlb limit ?,?";
        return queryForList(MLB.class, sql, begin, pageSize);
    }

    @Override
    public Integer queryForPageTotalCountByPrice(int min, int max) throws SQLException {
        String sql = "select count(*) from t_mlb where price between ? and ?";
        Number count = (Number) queryForSingleValue(sql, min, max);
        return count.intValue();
    }

    @Override
    public List<MLB> queryForPageItemsByPrice(int begin, int pageSize, int min, int max) throws SQLException {
        String sql = "select  `id`, `name`, `description`, `price`, `sales`, `stock`, `img_path` img_Path from t_mlb where price between ? and ?  order by price limit ?,? ";
        return queryForList(MLB.class, sql, min, max, begin, pageSize);
    }
}
