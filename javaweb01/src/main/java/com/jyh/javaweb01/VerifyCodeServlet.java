package com.jyh.javaweb01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(urlPatterns = "/code")
public class VerifyCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //定义验证码大小
        int width=500;
        int height=200;
        //创建一个内存中缓冲图片对象
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //绘制图片  获得画笔
        Graphics g = image.getGraphics();
        g.setColor(Color.white);
        g.fillRect(0,0,width,height);
       //可以添加边框
        g.setColor(Color.magenta);
        g.drawRect(0,0,width-2,height-2);
        String s = "sdfdsfdsfsfDSAFDSFGS345F53SD4F35DS44DS1V2DS423G4S1D23FD4S53F4fs4d53f4s53";
        Random random = new Random();
        g.setFont(new Font("Arial", Font.BOLD, 50));
        for (int i = 1; i < 5; i++) {
            int index = random.nextInt(s.length());
            char c = s.charAt(index);
            g.drawString(String.valueOf(c),width/5*i,height/2);
        }

        //绘制干扰线
        g.setColor(Color.black);
        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }
        //输出到页面
        ImageIO.write(image,"jpg",resp.getOutputStream());
    }
}
