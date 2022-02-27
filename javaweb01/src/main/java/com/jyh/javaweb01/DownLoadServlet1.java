package com.jyh.javaweb01;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(urlPatterns = "/download1")
public class DownLoadServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取文件名
        String filename = req.getParameter("filename");
        System.out.println(filename);
        //获取文件真实路径
        ServletContext context = getServletContext();
        String path = context.getRealPath("/img/" + filename);
        //使用字节流输入输出
        FileInputStream fip = new FileInputStream(path);
        //设置响应头告诉浏览器用下载的方式打开数据
        resp.setHeader("content-disposition","attachment;filename"+filename);
        ServletOutputStream opt = resp.getOutputStream();
        //设置缓冲区
        byte[] buffer = new byte[1024];
        int len;
        while ((len=fip.read(buffer))!=-1){
            opt.write(buffer,0,len);
        }
        fip.close();
        opt.close();
    }
}
