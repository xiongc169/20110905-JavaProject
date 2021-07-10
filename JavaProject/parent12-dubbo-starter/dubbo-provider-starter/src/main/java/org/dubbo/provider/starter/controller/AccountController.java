package org.dubbo.provider.starter.controller;

import org.dubbo.provider.starter.core.dao.AccountMapper;
import org.dubbo.provider.starter.core.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/account")
public class AccountController {

    private static SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");

    @Autowired
    private AccountMapper accountMapper;

    /**
     * http://127.0.0.1:9070/account/get
     */
    @ResponseBody
    @RequestMapping("/get")
    public String getTime() {
        long id = 2;
        Account account = accountMapper.selectByPrimaryKey(id);
        System.out.println(account);
        return sdFormat.format(new Date());
    }
}
