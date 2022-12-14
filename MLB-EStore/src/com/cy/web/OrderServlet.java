package com.cy.web;

import com.cy.domain.Cart;
import com.cy.domain.Order;
import com.cy.domain.User;
import com.cy.service.OrderService;
import com.cy.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/orderServlet")
public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();

    /**
     * 生成订单
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        // 先获取Cart购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        // 获取Userid
        User loginUser = (User) req.getSession().getAttribute("user");

        if (loginUser == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            return;
        }

//        System.out.println(cart);
        Integer userId = loginUser.getId();
//        调用orderService.createOrder(Cart,Userid);生成订单
        String orderId = orderService.createOrder(cart, userId);

//        req.setAttribute("orderId", orderId);
        // 请求转发到/pages/cart/checkout.jsp
//        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req, resp);

        req.getSession().setAttribute("orderId", orderId);

        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
    }

    protected void myOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {

        // 获取Userid
        User loginUser = (User) req.getSession().getAttribute("user");

        if (loginUser == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            return;
        }

        Integer userId = loginUser.getId();

        List<Order> orders = orderService.myOrders(userId);

        req.getSession().setAttribute("orders", orders);

        resp.sendRedirect(req.getContextPath() + "/pages/order/order.jsp");
    }

    protected void orderDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {

        String orderId = req.getParameter("orderId");

        Order order = orderService.orderDetails(orderId);

        req.getSession().setAttribute("order", order);

        resp.sendRedirect(req.getContextPath() + "/pages/order/order.jsp");
    }

    protected void allOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {

        List<Order> allOrders = orderService.allOrders();

        req.getSession().setAttribute("allOrders", allOrders);

        resp.sendRedirect(req.getContextPath() + "/pages/order/order.jsp");
    }

    protected void sendOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {

        String orderId = req.getParameter("orderId");

        orderService.sendOrder(orderId);

        resp.sendRedirect(req.getContextPath() + "/pages/order/order.jsp");
    }

    protected void receiveOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {

        String orderId = req.getParameter("orderId");

        orderService.receiveOrder(orderId);

        resp.sendRedirect(req.getContextPath() + "/pages/order/order.jsp");
    }
}
