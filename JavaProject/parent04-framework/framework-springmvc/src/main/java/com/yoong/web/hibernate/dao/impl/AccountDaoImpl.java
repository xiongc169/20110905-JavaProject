package com.yoong.web.hibernate.dao.impl;

import com.yoong.web.hibernate.dao.AccountDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.yoong.web.hibernate.entity.Account;

/**
 * @Desc AccountDaoImpl.java
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年8月20日
 * <p>
 * @Version 1.0
 */
@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Account saveAccount(Account account) {
        Session session = null;
        try {
            //session = sessionFactory.getCurrentSession();
            session = sessionFactory.openSession();
            session.saveOrUpdate(account);
            session.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return account;
    }
}
