package com.yoong.hibernate.spring.controller.impl;

import com.yoong.hibernate.spring.controller.BaseController;
import com.yoong.hibernate.spring.domain.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.UUID;

/**
 * @Desc HibernateController
 * <p>
 * @Author yoong
 * <p>
 * @Date 2019年3月21日
 * <p>
 * @Version 1.0
 */
@Controller
@RequestMapping("/hibernate")
public class HibernateController extends BaseController {

    @Autowired
    private SessionFactory sessionFactory;

    @PersistenceContext
    private EntityManager entityManager;

    public HibernateController() {
        System.out.println("HibernateController.HibernateController()");
    }

    /**
     * http://127.0.0.1:8080/hibernate/sessionSave
     */
    @ResponseBody
    @RequestMapping("/sessionSave")
    public String sessionSave() {
        Account account = new Account();
        account.setAccountId(UUID.randomUUID().toString());
        account.setCreateTime(new Date());
        account.setModifyTime(new Date());
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(account);
        transaction.commit();
        return "Enter";
    }
}
