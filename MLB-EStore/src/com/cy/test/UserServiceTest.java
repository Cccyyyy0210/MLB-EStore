package com.cy.test;

import com.cy.domain.User;
import com.cy.service.UserService;
import com.cy.service.impl.UserServiceImpl;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class UserServiceTest {
    UserService userService = new UserServiceImpl();

    @Test
    public void registUser() throws SQLException {
        userService.registUser(new User(null, "wp0225", "123456", "22698742@qq.com"));
        userService.registUser(new User(null, "wl1124", "123456", "12320457@qq.com"));
    }

    @Test
    public void login() throws SQLException {
        System.out.println(userService.login(new User(null, "zyt0921", "123456", null)));

    }

    @Test
    public void existsUsername() {

    }
}