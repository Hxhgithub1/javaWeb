package com.hxh.web;

import com.hxh.pojo.User;
import com.hxh.service.UserService;
import com.hxh.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1 、 获 取 请 求 的 参 数
         String username = request.getParameter("username");
         String password = request.getParameter("password");
         String email = request.getParameter("email");
         String code = request.getParameter("code");
// 2 、 检 查 验 证 码 是 否 正 确
        if (code.equals("abcde")){
            if (userService.existsUsername(username)){
                request.setAttribute("msg","用户名已存在");
                request.setAttribute("username",username);
                request.setAttribute("email",email);
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
            }else {
                userService.registUser(new User(null,username,password,email));

                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request,response);
            }

        }else {
            System.out.println("验证码"+code+"错误");
            request.setAttribute("msg","验证码错误");
            request.setAttribute("username",username);
            request.setAttribute("email",email);
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
