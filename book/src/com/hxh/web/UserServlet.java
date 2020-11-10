package com.hxh.web;

import com.hxh.pojo.User;
import com.hxh.service.UserService;
import com.hxh.service.impl.UserServiceImpl;
import com.hxh.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UserServlet extends BaseServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    UserService userService = new UserServiceImpl();
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");

        User user = WebUtils.copyParamBean(request.getParameterMap(), new User());

        if (userService.existsUsername(user.getUsername())){
            //用户名存在判断密码是否正确
            if(userService.login(user)==null){

                request.setAttribute("msg","密码错误，请从新输入");
                request.setAttribute("username",user.getUsername());
                request.getRequestDispatcher("pages/user/login.jsp").forward(request,response);
            }else {
                request.getRequestDispatcher("pages/user/login_success.jsp").forward(request,response);
            }
        }else{
            //用户名不存在
            request.setAttribute("msg","用户名不存在");
            request.setAttribute("username",user.getUsername());
            request.getRequestDispatcher("pages/user/login.jsp").forward(request,response);
        }
    }
    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        // 1 、 获 取 请 求 的 参 数
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String email = request.getParameter("email");
      String code = request.getParameter("code");

        User user = WebUtils.copyParamBean(request.getParameterMap(), new User());
// 2 、 检 查 验 证 码 是 否 正 确
        if (code.equals("abcde")){
            if (userService.existsUsername(user.getUsername())){
                request.setAttribute("msg","用户名已存在");
                request.setAttribute("username",user.getUsername());
                request.setAttribute("email",user.getEmail());
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
            }else {
                userService.registUser(user);

                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request,response);
            }

        }else {
            System.out.println("验证码"+code+"错误");
            request.setAttribute("msg","验证码错误");
            request.setAttribute("username",user.getUsername());
            request.setAttribute("email",user.getEmail());
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
        }
    }
}
