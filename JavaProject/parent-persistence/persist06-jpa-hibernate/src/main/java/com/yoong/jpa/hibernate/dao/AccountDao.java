package com.yoong.jpa.hibernate.dao;

import com.yoong.jpa.hibernate.domain.Account;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
