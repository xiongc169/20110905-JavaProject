package org.anno.consumer.controller;

import org.anno.service.CalculatorService;
import org.anno.service.UserService;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;

@Component("userController")
public class UserController {

    @Reference
    public CalculatorService calculator;

    @Reference
    public UserService userDao;
}
