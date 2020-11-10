package com.hxh.web;

import com.hxh.pojo.User;
import com.hxh.service.UserService;
import com.hxh.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class loginServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (userService.existsUsername(username)){
            //用户名存在判断密码是否正确
            if(userService.login(new User(null,username,password,null))==null){

                request.setAttribute("msg","密码错误，请从新输入");
                request.setAttribute("username",username);
                request.getRequestDispatcher("pages/user/login.jsp").forward(request,response);
            }else {
                request.getRequestDispatcher("pages/user/login_success.jsp").forward(request,response);
            }
        }else{
            //用户名不存在
            request.setAttribute("msg","用户名不存在");
            request.setAttribute("username",username);
            request.getRequestDispatcher("pages/user/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
