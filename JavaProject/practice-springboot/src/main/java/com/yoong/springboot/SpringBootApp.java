package com.yoong.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yoong
 *
 * @desc SpringBootApplication.java
 *
 * @date 2018年9月20日
 *
 */
//@SpringBootApplication
//@Configuration
@EnableAutoConfiguration
//@ComponentScan(basePackages = "com.yoong.*")
@Controller
public class SpringBootApp {

    /**
     * 入口函数
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootApp.class, args);
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
