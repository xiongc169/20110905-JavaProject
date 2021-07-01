package org.dubbo.consumer.starter.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.dubbo.common.starter.facade.CalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/account")
public class AccountController {

    private static SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");

    @DubboReference
    private CalculatorService calculatorService;

    /**
     * http://127.0.0.1:9090/account/getTime
     */
    @ResponseBody
    @RequestMapping("/getTime")
    public String getTime() {
        double add = calculatorService.add(10, 20);
        System.out.println(add);
        return sdFormat.format(new Date());
    }

}
