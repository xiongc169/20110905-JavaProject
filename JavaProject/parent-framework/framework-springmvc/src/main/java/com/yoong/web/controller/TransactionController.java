package com.yoong.web.controller;

import com.yoong.web.hibernate.dao.AccountDao;
import com.yoong.web.hibernate.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.UUID;

/**
 * @Desc 《精通Spring 4.x企业应用开发实战》陈雄华 林开雄 文建国 著  Chap 11.4
 * <p>
 * @Author yoong
 * <p>
 * @Date 2016-7-11
 * <p>
 * @Version 1.0
 */
@Controller
@RequestMapping("/tx")
public class TransactionController {

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    private AccountDao accountDao;

    /**
     * http://localhost:7095/tx/insert
     */
    @ResponseBody
    @RequestMapping("/insert")
    public void insertAccount() {

        Object object = transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                Account account = null;
                try {
                    account = new Account();
                    account.setAccountId(UUID.randomUUID().toString());
                    account.setCreateTime(new Date());
                    account.setModifyTime(new Date());
                    account.setIsDelete(0);
                    accountDao.saveAccount(account);
                    double aa = 10 / 0;
                } catch (Exception ex) {
                    transactionStatus.setRollbackOnly();
                }
            }
        });
        System.out.println(object);
    }
}
