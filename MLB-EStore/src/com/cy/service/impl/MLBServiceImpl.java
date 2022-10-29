package com.cy.service.impl;

import com.cy.dao.MLBDao;
import com.cy.dao.impl.MLBDaoImpl;
import com.cy.domain.MLB;
import com.cy.domain.Page;
import com.cy.service.MLBService;

import java.sql.SQLException;
import java.util.List;

public class MLBServiceImpl implements MLBService {
    private MLBDao mlbDao = new MLBDaoImpl();

    @Override
    public void addMLB(MLB mlb) throws SQLException {
        mlbDao.addMLB(mlb);
    }

    @Override
    public void deleteMLBById(Integer id) throws SQLException {
        mlbDao.deleteMLBById(id);
    }

    @Override
    public void updateMLB(MLB mlb) throws SQLException {
        mlbDao.updateMLB(mlb);
    }

    @Override
    public MLB queryById(Integer id) throws SQLException {
        return mlbDao.queryMLBById(id);
    }

    @Override
    public List<MLB> queryMLBs() throws SQLException {
        return mlbDao.queryMLBs();
    }

    @Override
    public Page<MLB> page(int pageNo, int pageSize) throws SQLException {
        Page<MLB> page = new Page<MLB>();


        Integer pageTotalCount = mlbDao.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);

        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal++;
        }

        page.setPageTotal(pageTotal);
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);


        int begin = (page.getPageNo() - 1) * pageSize;
        List<MLB> items = mlbDao.queryForPageItems(begin, pageSize);
        page.setItems(items);
        return page;
    }

    @Override
    public Page<MLB> pageByPrice(int pageNo, int pageSize, int min, int max) throws SQLException {
        Page<MLB> page = new Page<MLB>();


        Integer pageTotalCount = mlbDao.queryForPageTotalCountByPrice(min, max);
        page.setPageTotalCount(pageTotalCount);

        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal++;
        }

        page.setPageTotal(pageTotal);
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);


        int begin = (page.getPageNo() - 1) * pageSize;
        List<MLB> items = mlbDao.queryForPageItemsByPrice(begin, pageSize, min, max);
        page.setItems(items);
        return page;
    }
}
