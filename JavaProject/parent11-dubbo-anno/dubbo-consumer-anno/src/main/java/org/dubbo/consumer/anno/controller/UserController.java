package org.dubbo.consumer.anno.controller;

import org.dubbo.common.anno.facade.CalculatorService;
import org.dubbo.common.anno.facade.UserService;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;

@Component("userController")
public class UserController {

    @Reference
    public CalculatorService calculator;

    @Reference
    public UserService userDao;
}
