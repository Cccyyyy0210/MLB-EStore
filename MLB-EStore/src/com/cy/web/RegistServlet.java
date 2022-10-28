package com.cy.web;

import com.cy.domain.User;
import com.cy.service.UserService;
import com.cy.service.impl.UserServiceImpl;
import com.cy.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

@WebServlet("/registServlet")
public class RegistServlet extends BaseServlet{
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String repwd = req.getParameter("repwd");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());

        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);

        //2.检查验证码是否正确
        if (token != null && token.equalsIgnoreCase(code)) {
            if (userService.existsUsername(username)) {
                req.setAttribute("msg", "用户名不可用");
                req.setAttribute("username", username);
                req.setAttribute("email", email);
                req.setAttribute("password", password);
                req.setAttribute("repwd", repwd);
                req.setAttribute("code", code);
//                System.out.println("用户名[" + username + "]不可用");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                userService.registUser(user);
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }

        } else {
            req.setAttribute("msg", "验证码错误");
            req.setAttribute("username", username);
            req.setAttribute("email", email);
            req.setAttribute("password", password);
            req.setAttribute("repwd", repwd);
            req.setAttribute("code", code);
//            System.out.println("验证码[" + code + "]错误！");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }

    }
    //查询用户名是否可用
    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        boolean exitsUsername = userService.existsUsername(username);
        Map<String, Object> resultMap = new HashMap<String, Object>();

        resultMap.put("exitsUsername", exitsUsername);

        Gson gson = new Gson();
        String json = gson.toJson(resultMap);

        resp.getWriter().write(json);
    }
}
