package org.web.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.web.dao.AccountDao;
import org.web.domain.Account;

/**
 * @Desc AccountDaoImpl
 * @Author
 * @Date
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
