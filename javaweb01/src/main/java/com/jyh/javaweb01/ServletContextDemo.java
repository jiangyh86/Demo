package com.jyh.javaweb01;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

//获取文件真实路径
@WebServlet(urlPatterns = "/ServletContextDemo")
public class ServletContextDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //得到ServletContext的对象
        ServletContext servletContext = getServletContext();
        //Web目录资源访问
        System.out.println(servletContext.getRealPath("/a.txt"));
        //E:\Enviroment\apache-tomcat-10.0.16\webapps\ROOT\a.txt
        //Web-INF下的资源目录
        System.out.println(servletContext.getRealPath("/WEB-INF/c.txt"));
        //E:\Enviroment\apache-tomcat-10.0.16\webapps\ROOT\WEB-INF\c.txt
        //访问src或子目录的资源访问
        System.out.println(servletContext.getRealPath("/WEB-INF/classes/com/jyh/b.txt"));
        //E:\Enviroment\apache-tomcat-10.0.16\webapps\ROOT\WEB-INF\classes\com\jyh\b.txt
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
