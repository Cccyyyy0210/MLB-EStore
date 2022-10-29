package com.cy.service;

import com.cy.domain.User;

import java.sql.SQLException;

public interface UserService {
    //用户注册
    public void registUser(User user) throws SQLException;

    //用户登录
    public User login(User user) throws SQLException;

    //检查用户名是否可用
    public boolean existsUsername(String username) throws SQLException;
}
