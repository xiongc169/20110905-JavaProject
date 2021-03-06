package com.yoong.jpa.api.dao;

import com.yoong.jpa.api.domain.Account;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AccountDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void add(Account account) {
        //EntityTransaction transaction = entityManager.getTransaction();
        //transaction.begin();
        entityManager.persist(account);
        //transaction.commit();
    }

    public Account get(Long Id) {
        Account account = entityManager.find(Account.class, Id);
        return account;
    }
}
