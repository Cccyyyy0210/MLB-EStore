package com.cy.service;

import com.cy.domain.User;

public interface UserService {
    //用户注册
    public void registUser(User user);
    //用户登录
    public User login(User user);
    //检查用户名是否可用
    public boolean existsUsername(String username);
}
