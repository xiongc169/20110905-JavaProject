package org.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.web.domain.Account;
import org.web.service.AccountService;

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
    @Qualifier("accountService")
    private AccountService accountService;

    /**
     * http://localhost:8095/hibernate/save
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/save")
    public String save() {
        Account account = new Account();
        account.setAccountId(UUID.randomUUID().toString());
        account.setCreateTime(new Date());
        account.setModifyTime(new Date());
        account.setIsDelete(0);
        accountService.saveAccount(account);
        return format.format(new Date());
    }
}
