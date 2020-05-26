package com.yoong.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Desc SpringBootApplication.java
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年9月20日
 * <p>
 * @Version 1.0
 */
@SpringBootApplication
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan(basePackages = "com.yoong.*")
//@Controller
//@EnableJms
public class SpringBootApp {

    private static SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        System.out.println(sdFormat.format(new Date()) + " SpringBootApp Start...");
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(SpringBootApp.class, args);
        System.out.println(sdFormat.format(new Date()) + " SpringBootApp Finished");
    }

    /**
     * http://localhost:8085/app/home
     * 成功：@Controller + @EnableAutoConfiguration
     * 成功：@Controller + @EnableAutoConfiguration + @ComponentScan
     * 失败：@SpringBootApplication
     * 成功：@Controller + @SpringBootApplication
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/app/home")
    public String home() {
        return "Hello World!";
    }
}
