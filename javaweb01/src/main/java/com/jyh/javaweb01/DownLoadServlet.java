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

@WebServlet(urlPatterns = "/download")
public class DownLoadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //获取请求的参数，文件的名称
        String filename = req.getParameter("filename");
        //获取字节流输入输出流
        //先通过ServletContext找到文件路径
        System.out.println(filename);
        ServletContext context = getServletContext();
        String realPath = context.getRealPath("/img/" + filename);
        //用字节流输入
        System.out.println(realPath);
        FileInputStream fis = new FileInputStream(realPath);
        //设置响应头的打开方式,告诉浏览器用下载的方式打开数据
        resp.setHeader("content-disposition","attachment;filename"+filename);
        ServletOutputStream opt = resp.getOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len=fis.read(buffer))!=-1){
            opt.write(buffer,0,len);
        }
       fis.close();
        opt.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
