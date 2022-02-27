package com.jyh.javaweb01;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import java.io.*;
import java.util.Random;

@WebServlet(urlPatterns = "/day")
public class HelloServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//        req.getRequestDispatcher("start.html").forward(req,res);

        /*res.setContentType("image/jpeg;charset=utf-8");
        ServletOutputStream os = res.getOutputStream();
        InputStream is = new FileInputStream(new File("C:\\Users\\jiangyiheng\\Desktop\\JavaWeb\\01-Servlet\\src\\main\\webapp\\static\\img\\1.jpg"));
        byte[] buffer= new byte[1024];
        int len;
        while ((len=is.read(buffer))!=-1){
            os.write(buffer,0,len);
        }
        is.close();
        os.close();*/
    }
}
