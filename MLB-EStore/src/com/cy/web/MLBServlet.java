package com.cy.web;

import com.cy.domain.MLB;
import com.cy.domain.Page;
import com.cy.service.MLBService;
import com.cy.service.impl.MLBServiceImpl;
import com.cy.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/manager/mlbServlet")
public class MLBServlet extends BaseServlet {
    MLBService mlbService = new MLBServiceImpl();


    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String name = req.getParameter("name");
        MLB mlb = WebUtils.copyParamToBean(req.getParameterMap(), new MLB());
        mlbService.addMLB(mlb);
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1) + 1;

        resp.sendRedirect(req.getContextPath() + "/manager/mlbServlet?action=page&pageNo=" + pageNo);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String id = req.getParameter("id");
        mlbService.deleteMLBById(WebUtils.parseInt(id, 0));
        resp.sendRedirect(req.getContextPath() + "/manager/mlbServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        MLB mlb = WebUtils.copyParamToBean(req.getParameterMap(), new MLB());
        mlbService.updateMLB(mlb);
        resp.sendRedirect(req.getContextPath() + "/manager/mlbServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }

    protected void getMLB(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MLB mlb = WebUtils.copyParamToBean(req.getParameterMap(), new MLB());
        req.setAttribute("MLB", mlb);
        req.getRequestDispatcher("/pages/manager/mlb_edit.jsp").forward(req, resp);
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        List<MLB> mlbs = mlbService.queryMLBs();
        req.setAttribute("MLBs", mlbs);
        req.getRequestDispatcher("/pages/manager/mlb_manager.jsp").forward(req, resp);

    }

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<MLB> page = mlbService.page(pageNo, pageSize);
        page.setUrl("manager/mlbServlet?action=page");
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/manager/mlb_manager.jsp").forward(req, resp);
    }
}
