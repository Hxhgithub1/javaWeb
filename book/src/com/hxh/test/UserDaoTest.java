package com.hxh.test;

import com.hxh.dao.UserDao;
import com.hxh.dao.impl.UserDaoImpl;
import com.hxh.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {
    //ctrl+shift+t 生成测试代码
    UserDao userDao =new UserDaoImpl();
    @Test
    public void queryUserByUsername() {

        //System.out.println(userDao.queryUserByUsername("admin"));
        if (userDao.queryUserByUsername("admin1234") == null) {
            System.out.println("用户名可用！");
        } else {
            System.out.println("用户名已存在！");
        }

    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if (userDao.queryUserByUsernameAndPassword("admin", "admin") == null) {
            System.out.println("用户名或密码错误，登录失败");
        } else {
            System.out.println("查询成功");
        }
    }

    @Test
    public void saveUser() {
        System.out.println( userDao.saveUser(new User(null,"wzg168", "123456", "wzg168@qq.com")) );

    }
}