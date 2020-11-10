package com.hxh.service.impl;

import com.hxh.dao.UserDao;
import com.hxh.dao.impl.UserDaoImpl;
import com.hxh.pojo.User;
import com.hxh.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
       return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());

    }

    @Override
    public boolean existsUsername(String username) {
        if (userDao.queryUserByUsername(username)==null){

            return false;
        }
        return true;
    }
}
