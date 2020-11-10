package com.hxh.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class context extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getRequestURI());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletConfig().getServletContext();
        System.out.println("username为："+servletContext.getInitParameter( "username"));
        System.out.println(servletContext.getContextPath());
        System.out.println(servletContext.getRealPath("/"));
        System.out.println(servletContext.getResourcePaths("/"));
    }
}
