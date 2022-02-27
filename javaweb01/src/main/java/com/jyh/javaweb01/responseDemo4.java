package com.jyh.javaweb01;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(urlPatterns = "/responseDemo4")
public class responseDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream opt = resp.getOutputStream();
        resp.setContentType("text/html;charset=utf-8");
        String s="<h1>cdsjcdskjv</h1></br><script>alert('你好-responseDemo4');</script>";
        opt.write(s.getBytes(StandardCharsets.UTF_8));
        opt.flush();
        opt.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req, resp);
    }
}
