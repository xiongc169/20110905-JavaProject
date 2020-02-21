package com.yoong.web.servlet;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Desc FirstServlet
 * @Author
 * @Date
 * @Version 1.0
 */
public class FirstServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Web容器(ServletContext)获取Spring容器(ApplicationContext)的方式
        WebApplicationContext webApplicationContext01 = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        System.out.println(webApplicationContext01);

        ServletContext servletContext = webApplicationContext01.getServletContext();
        System.out.println(servletContext);

        WebApplicationContext webApplicationContext02 = (WebApplicationContext) getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        System.out.println(webApplicationContext02);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
