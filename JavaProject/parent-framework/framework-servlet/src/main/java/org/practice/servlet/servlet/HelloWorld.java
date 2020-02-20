package org.practice.servlet.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Desc Servlet 实例
 * PS：部署到Tomcat时，web.xml中<servlet-class>配置为类的全路径名；
 * https://www.runoob.com/servlet/servlet-first-example.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2012年2月19日14:58:32
 * <p>
 * @Version 1.0
 */
public class HelloWorld extends HttpServlet {

    private String message;

    public void init() throws ServletException {
        // 执行必需的初始化
        message = "Hello, ";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应内容类型
        response.setContentType("text/html");
        String name = request.getParameter("name");

        // 实际的逻辑是在这里
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + name + "</h1>");
    }

    public void destroy() {
        // 什么也不做
    }
}
