package com.yoong.practice.mybatis.springx.wong_user.service;

import com.yoong.practice.mybatis.springx.wong_user.dao.AccountMapper;
import com.yoong.practice.mybatis.springx.wong_user.dao.AdminMapper;
import com.yoong.practice.mybatis.springx.wong_user.domain.Account;
import com.yoong.practice.mybatis.springx.wong_user.domain.AccountExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
