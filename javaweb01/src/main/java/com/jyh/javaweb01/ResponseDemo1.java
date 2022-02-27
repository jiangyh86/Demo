package com.jyh.javaweb01;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(urlPatterns = "/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("responseDemo1");
        //设置状态码302，重定向
        response.setStatus(302);
        //page>request>session>application
        request.setAttribute("msg","hello response");//重定向无法携带参数
        //可以写相对路径"responseDemo2",/开头的是绝对路径
        //request.getRequestDispatcher("responseDemo2").forward(request,response);//可以携带参数
//        response.setHeader("location","/responseDemo2");
        //设置响应头
        //response.setHeader("location","https://www.baidu.com");
        //等同于重定向,可以跨域，而request的forward是无法跨域的
        //response.sendRedirect("https://www.baidu.com");
        response.setHeader("Refresh","5; URL=https://www.baidu.com");
    }
}
