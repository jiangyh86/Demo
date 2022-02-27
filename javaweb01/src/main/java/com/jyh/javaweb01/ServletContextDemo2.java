package com.jyh.javaweb01;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * ServletContext主要作用
 * 通过ServletContext获取MIME类型
 * 共享数据
 * 获取服务器的真实路径 getRealPath();
 */
@WebServlet(urlPatterns = "/demo2")
public class ServletContextDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        //MIME image/jpeg
        String filename="a.c";
        String type = servletContext.getMimeType(filename);
        System.out.println(type);//text/x-c
    }
}
