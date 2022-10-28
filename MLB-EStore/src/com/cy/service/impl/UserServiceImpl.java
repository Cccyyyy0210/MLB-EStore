package com.cy.service.impl;

import com.cy.dao.UserDao;
import com.cy.dao.impl.UserDaoImpl;
import com.cy.domain.User;
import com.cy.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        //查询数据库登录
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());

    }

    @Override
    public boolean existsUsername(String username) {
        if (userDao.queryUserByUsername(username) == null) {
            // 等于null,说明没查到用户，即该用户名可用
            return false;
        }

        return true;
    }
}
