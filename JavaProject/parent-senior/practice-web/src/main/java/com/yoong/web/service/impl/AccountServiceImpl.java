package com.yoong.web.service.impl;

import com.yoong.web.dao.AccountDao;
import com.yoong.web.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.yoong.web.domain.Account;

/**
 * @Desc AccountServiceImpl
 * @Author
 * @Date
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
