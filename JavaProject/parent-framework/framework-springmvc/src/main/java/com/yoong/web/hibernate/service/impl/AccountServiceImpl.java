package com.yoong.web.hibernate.service.impl;

import com.yoong.web.hibernate.dao.AccountDao;
import com.yoong.web.hibernate.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.yoong.web.hibernate.entity.Account;

/**
 * @Desc AccountServiceImpl.java
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年8月20日
 * <p>
 * @Version 1.0
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    @Transactional
    public Account saveAccount(Account account) {
        account = accountDao.saveAccount(account);
        Integer div = 10 / 0;
        account = accountDao.saveAccount(account);
        return account;
    }
}
