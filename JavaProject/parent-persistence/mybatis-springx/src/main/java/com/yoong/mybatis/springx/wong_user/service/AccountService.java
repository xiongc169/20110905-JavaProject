package com.yoong.mybatis.springx.wong_user.service;

import com.yoong.mybatis.springx.wong_user.dao.AccountMapper;
import com.yoong.mybatis.springx.wong_user.dao.AdminMapper;
import com.yoong.mybatis.springx.wong_user.domain.Account;
import com.yoong.mybatis.springx.wong_user.domain.AccountExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private AdminMapper adminMapper;

    public void getAccounts() {
        AccountExample example = new AccountExample();
        example.createCriteria().andAccountIdEqualTo("ac-123456789");
        List<Account> accounts = accountMapper.selectByExample(example);
        System.out.println(accounts.size());
    }

    @Transactional
    public void insertAccounts() {
        Account account1 = new Account();
        account1.setAccountId("accountId-01");
        int effectRows1 = accountMapper.insert(account1);
        System.out.println(effectRows1);

        double div = 100 / 0;
        System.out.println(div);

        Account account2 = new Account();
        account2.setAccountId("accountId-02");
        int effectRows2 = accountMapper.insert(account2);
        System.out.println(effectRows2);
    }
}
