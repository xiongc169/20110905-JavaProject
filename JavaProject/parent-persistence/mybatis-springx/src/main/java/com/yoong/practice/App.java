package com.yoong.practice;

import com.yoong.practice.mybatis.springx.wong_user.dao.AccountMapper;
import com.yoong.practice.mybatis.springx.wong_user.dao.AdminMapper;
import com.yoong.practice.mybatis.springx.wong_user.domain.Account;
import com.yoong.practice.mybatis.springx.wong_user.domain.AccountExample;
import com.yoong.practice.mybatis.springx.wong_user.domain.Admin;
import com.yoong.practice.mybatis.springx.wong_user.domain.AdminExample;
import com.yoong.practice.mybatis.springx.wong_user.service.AccountService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            sqlSessionTemplateDemo();
            mapperFactoryDemo();
            mapperScannerDemo();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 由sqlSessionTemplate构建Mapper接口
     */
    public static void sqlSessionTemplateDemo() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:mybatis-spring.xml");
        SqlSessionTemplate sqlSessionTemplate = (SqlSessionTemplate) context.getBean("sqlSessionTemplate");
        AccountMapper accountMapper = sqlSessionTemplate.getMapper(AccountMapper.class);
        AccountExample example = new AccountExample();
        example.createCriteria().andAccountIdEqualTo("ac-123456789");
        List<Account> accounts = accountMapper.selectByExample(example);
        System.out.println(accounts.size());

        AdminMapper adminMapper = sqlSessionTemplate.getMapper(AdminMapper.class);
        AdminExample example2 = new AdminExample();
        example2.createCriteria().andAdminNameEqualTo("123456789");
        List<Admin> admins = adminMapper.selectByExample(example2);
        System.out.println(admins.size());
    }

    /**
     * 容器中配置单个Mapper接口
     */
    public static void mapperFactoryDemo() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:mybatis-spring.xml");
        AccountExample example = new AccountExample();
        example.createCriteria().andAccountIdEqualTo("ac-123456789");
        AccountMapper accountMapper = (AccountMapper) context.getBean("accountDao");
        List<Account> accounts = accountMapper.selectByExample(example);
        System.out.println(accounts.size());
        System.out.println("Finished");
    }

    /**
     * 容器中配置多个Mapper接口
     */
    public static void mapperScannerDemo() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:mybatis-spring.xml");
        AccountService accountService = (AccountService) context.getBean("accountService");
        accountService.getAccounts();
        System.out.println("Finished");
    }
}
