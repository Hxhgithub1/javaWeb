package com.hxh.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class helloservlet implements Servlet {
    public helloservlet() {
        System.out.println(1);
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println(2);
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
       HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();
        if ("GET".equals(method)) {
            System.out.println("这是get请求");
        }else if ("POST".equals(method)){
            System.out.println("这是post请求");


        }

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println(4);
    }
}
