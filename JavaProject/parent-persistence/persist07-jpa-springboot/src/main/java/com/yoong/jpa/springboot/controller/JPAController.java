package com.yoong.jpa.springboot.controller;

import com.yoong.jpa.springboot.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletContext;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Enumeration;

@Controller
@RequestMapping("/jpa")
public class JPAController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ServletContext servletContext;

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
        account.setIsDelete(0);
        entityManager.persist(account);
        entityManager.flush();//持久化persist()之后，必须调用flush()方法
        System.out.println("Hello");

        Enumeration<String> attributeNames = servletContext.getAttributeNames();
        System.out.println(attributeNames);
    }
}
