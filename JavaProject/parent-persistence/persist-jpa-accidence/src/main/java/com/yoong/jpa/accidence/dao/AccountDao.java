package com.yoong.jpa.accidence.dao;

import com.yoong.jpa.accidence.domain.Account;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * @Desc AccountDao
 * @Author
 * @Date
 * @Version 1.0
 */
@Repository
public class AccountDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void add(Account account) {
        entityManager.persist(account);
    }

    public Account get(Long Id) {
        Account account = entityManager.find(Account.class, Id);
        return account;
    }
}
