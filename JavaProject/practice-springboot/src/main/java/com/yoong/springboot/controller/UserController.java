package com.yoong.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yoong.springboot.config.AuthConfig;

/**
 * @author yoong
 *
 * @desc http://127.0.0.1:8080/user/login
 *
 * @date 2018年9月20日
 *
 */
@EnableAutoConfiguration
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AuthConfig config;

    /**
     * http://localhost:8085/user/login
     * 失败：@Controller + @EnableAutoConfiguration
     * 成功：@Controller + @EnableAutoConfiguration + @ComponentScan
     * 成功：@SpringBootApplication
     * 成功：@Controller + @SpringBootApplication
     *
     * 失败：@Controller + @EnableAutoConfiguration
     *
     * @param name
     * @return
     */
    @ResponseBody
    @RequestMapping("/login")
    public String login(String name) {
        return "Hello " + name + config.getUserName();
    }

}
