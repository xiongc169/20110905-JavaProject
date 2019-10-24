package com.yoong.practice;

import com.yoong.practice.mybatis.springx.wong_user.dao.AccountMapper;
import com.yoong.practice.mybatis.springx.wong_user.dao.AdminMapper;
import com.yoong.practice.mybatis.springx.wong_user.domain.Account;
import com.yoong.practice.mybatis.springx.wong_user.domain.AccountExample;
import com.yoong.practice.mybatis.springx.wong_user.domain.Admin;
import com.yoong.practice.mybatis.springx.wong_user.domain.AdminExample;
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
            mybatisDemo();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void mybatisDemo() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:mybatis-spring.xml");
        //1、根据 sqlSessionTemplate 构建Mapper接口
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

        //2、容器中配置Mapper接口
        AccountMapper accountMapper2 = (AccountMapper) context.getBean("accountDao");
        List<Account> accounts2 = accountMapper2.selectByExample(example);
        System.out.println(accounts2.size());
    }
}
