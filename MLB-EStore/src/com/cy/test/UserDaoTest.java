package com.cy.test;

import com.cy.dao.UserDao;
import com.cy.dao.impl.UserDaoImpl;
import com.cy.domain.User;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() throws SQLException {
        if (userDao.queryUserByUsername("gcy0210") == null) {
            System.out.println("用户名可用！");
        } else {
            System.out.println("用户名已存在！");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() throws SQLException {
        if (userDao.queryUserByUsernameAndPassword("gcy0210", "123456") == null) {
            System.out.println("用户名或密码错误，登录失败");
        } else {
            System.out.println("查询成功");
        }
    }

    @Test
    public void saveUser() throws SQLException {
        System.out.println(userDao.saveUser(new User(null, "gyj0308", "123456", "2269855413@qq.com")));

    }
}