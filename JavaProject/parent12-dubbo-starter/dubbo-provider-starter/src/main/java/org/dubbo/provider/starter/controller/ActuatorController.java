package org.dubbo.provider.starter.controller;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/actuator")
public class ActuatorController {

    private static SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private HikariDataSource hikariDataSource;

    /**
     * http://127.0.0.1:9070/actuator/getTime
     */
    @ResponseBody
    @RequestMapping("/getTime")
    public String getTime() {
        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        WebApplicationContext ctx02 = (WebApplicationContext) servletContext.getAttribute("org.springframework.web.context.WebApplicationContext.ROOT");
        System.out.println(ctx == ctx02);
        return sdFormat.format(new Date());
    }

}
