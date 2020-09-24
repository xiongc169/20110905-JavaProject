package com.yoong.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yoong.springboot.config.AuthConfig;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Desc UserController.java
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年9月20日
 * <p>
 * @Version 1.0
 */
@EnableAutoConfiguration
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AuthConfig config;

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS");

    /**
     * http://localhost:8085/user/login
     * 失败：@Controller + @EnableAutoConfiguration
     * 成功：@Controller + @EnableAutoConfiguration + @ComponentScan
     * 成功：@SpringBootApplication
     * 成功：@Controller + @SpringBootApplication
     * <p>
     * 失败：@Controller + @EnableAutoConfiguration
     */
    @ResponseBody
    @RequestMapping("/login")
    public String login(String name) {
        String msg = String.format("%s: Hello %s %s", format.format(new Date()), name, config.getUserName());
        System.out.println(msg);
        return msg;
    }

    /**
     * http://localhost:8085/user/register?userName=name01&password=password01
     */
    @ResponseBody
    @RequestMapping("/register")
    public String register(@RequestBody AuthConfig authConfig) {
        String msg = String.format("%s: Hello %s %s", format.format(new Date()), authConfig.getUserName(), authConfig.getPassword());
        System.out.println(msg);
        return msg;
    }

    /**
     * http://localhost:8085/user/logout?userName=name01&password=password01
     */
    @ResponseBody
    @RequestMapping("/logout")
    public String logout(AuthConfig authConfig) {
        String msg = String.format("%s: Hello %s %s", format.format(new Date()), authConfig.getUserName(), authConfig.getPassword());
        System.out.println(msg);
        return msg;
    }
}
