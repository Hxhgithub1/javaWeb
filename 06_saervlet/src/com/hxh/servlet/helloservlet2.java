package com.hxh.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class helloservlet2 extends HttpServlet {


    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doget方法");
        ServletConfig config = getServletConfig();
        System.out.println(config.getInitParameter("username"));
        System.out.println(config.getInitParameter("url"));
        System.out.println(config.getServletContext());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("dopost方法");

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
//        System.out.println(config.getInitParameter("username"));
//        System.out.println(config.getInitParameter("url"));
//        System.out.println(config.getServletContext());

    }
}
