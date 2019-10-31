package com.yoong.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yoong.web.domain.Account;
import com.yoong.web.service.AccountService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Desc HibernateController
 * @Author
 * @Date
 * @Version 1.0
 */
@Controller
@RequestMapping("/hibernate")
public class HibernateController {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private AccountService accountService;

    /**
     * http://127.0.0.1:8095/hibernate/getTime
     */
    @ResponseBody
    @RequestMapping("/getTime")
    public String getTime(HttpServletRequest request, HttpServletResponse response) {
        String msg = "HibernateController.getTime() " + format.format(new Date());
        System.out.println(msg);
        return msg;
    }

    /**
     * http://localhost:8095/hibernate/saveByTx
     */
    @ResponseBody
    @RequestMapping("/saveByTx")
    public String saveByTransaction() {
        Account account = new Account();
        account.setAccountId(UUID.randomUUID().toString());
        account.setCreateTime(new Date());
        account.setModifyTime(new Date());
        account.setIsDelete(0);
        accountService.saveAccount(account);
        return format.format(new Date());
    }
}
