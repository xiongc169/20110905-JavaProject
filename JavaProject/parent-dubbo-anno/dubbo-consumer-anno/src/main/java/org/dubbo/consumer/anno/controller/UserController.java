package org.dubbo.consumer.anno.controller;

import org.anno.common.facade.CalculatorService;
import org.anno.common.facade.UserService;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;

@Component("userController")
public class UserController {

    @Reference
    public CalculatorService calculator;

    @Reference
    public UserService userDao;
}
