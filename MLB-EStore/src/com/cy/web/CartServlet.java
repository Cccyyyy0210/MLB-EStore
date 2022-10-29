package com.cy.web;

import com.cy.domain.Cart;
import com.cy.domain.CartItem;
import com.cy.domain.MLB;
import com.cy.service.MLBService;
import com.cy.service.impl.MLBServiceImpl;
import com.cy.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/cartServlet")
public class CartServlet extends BaseServlet {
    private MLBService mlbService = new MLBServiceImpl();

    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        // 获取请求的参数 商品编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        // 调用mlbService.queryMLBById(id):MLB得到图书的信息
        MLB mlb = mlbService.queryById(id);
        // 把图书信息，转换成为CartItem商品项
        CartItem cartItem = new CartItem(mlb.getId(), mlb.getName(), 1, mlb.getPrice(), mlb.getPrice());
        // 调用Cart.addItem(CartItem);添加商品项
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);

//        System.out.println(cart);
        // 最后一个添加的商品名称
        req.getSession().setAttribute("lastName", cartItem.getName());

        //6、返回购物车总的商品数量和最后一个添加的商品名称
        Map<String, Object> resultMap = new HashMap<String, Object>();

        resultMap.put("totalCount", cart.getTotalCount());
        resultMap.put("lastName", cartItem.getName());

        Gson gson = new Gson();
        String resultMapJsonString = gson.toJson(resultMap);

        resp.getWriter().write(resultMapJsonString);

    }

    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {

        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        MLB mlb = mlbService.queryById(id);

        CartItem cartItem = new CartItem(mlb.getId(), mlb.getName(), 1, mlb.getPrice(), mlb.getPrice());

        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }

        cart.addItem(cartItem);
        req.getSession().setAttribute("lastName", cartItem.getName());

        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }

        cart.deleteItem(id);

        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }

        cart.clear();

        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        int count = WebUtils.parseInt(req.getParameter("count"), 1);

        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }

        cart.updateCount(id, count);

        resp.sendRedirect(req.getHeader("Referer"));
    }
}
