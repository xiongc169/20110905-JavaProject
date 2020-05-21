package com.yoong.jpa.spring.controller;

import com.yoong.jpa.spring.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.util.Date;

@Controller
@RequestMapping("/jpa")
public class JPAController {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * http://127.0.0.1:8520/jpa/greet
     */
    @ResponseBody
    @RequestMapping("/greet")
    @Transactional
    public void greet() {
        Account account = new Account();
        account.setAccountId("accountId-002");
        account.setCreateTime(new Timestamp(new Date().getTime()));
        account.setModifyTime(new Timestamp(new Date().getTime()));
        entityManager.persist(account);
        System.out.println("Hello");
    }
}
