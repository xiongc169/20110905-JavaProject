package com.yoong.mybatis.api.wong_user;

import com.yoong.mybatis.api.wong_user.dao.AccountMapper;
import com.yoong.mybatis.api.wong_user.dao.CustomerMapper;
import com.yoong.mybatis.api.wong_user.domain.Account;
import com.yoong.mybatis.api.wong_user.domain.AccountExample;
import com.yoong.mybatis.api.wong_user.domain.Customer;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Desc MyBatis官方文档(中文)
 * http://www.mybatis.org/mybatis-3/zh/getting-started.html
 * 学习总结(一)——MyBatis快速入门
 * http://www.cnblogs.com/xdp-gacl/p/4261895.html
 * <br>
 * @Author Administrator
 * <br>
 * @Date 2018/1/16 16:41
 * <br>
 * @Version 1.0
 */
public class WongUserManager {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            //MyBatis缓存、事务
            //MyBatis-Spring缓存、事务
            wongUserTestByXml();
            wongUserTestByAPI();
            wongUserTestAssociation();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void wongUserTestByXml() {
        //1、SqlSessionFactoryBuilder根据配置(xml配置文件、Configuration类)构建SqlSessionFactory
        //2、SqlSessionFactory构建SqlSession
        //3、探究已映射的SQL语句
        try {
            String resource = "mybatis-wong_user.xml";
            InputStream iStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(iStream);
            SqlSession session = factory.openSession();
            AccountExample example = new AccountExample();
            example.createCriteria().andAccountIdEqualTo("8");
            // 1、iBatis用法：命名空间+SQL Id
            List<Account> result = session.selectList("com.yoong.mybatis.api.wong_user.dao.AccountMapper.selectByExample", example);
            System.out.println("result.size: " + result.size());
            //缓存，生效
            List<Account> result2 = session.selectList("com.yoong.mybatis.api.wong_user.dao.AccountMapper.selectByExample", example);
            System.out.println("result2.size: " + result2.size());

            // 2、MyBatis用法：获取映射器
            String accountId = "ac-123456789";
            example.createCriteria().andAccountIdEqualTo(accountId);
            AccountMapper accountMapper = session.getMapper(AccountMapper.class);
            List<Account> result5 = accountMapper.selectByExample(example);
            System.out.println("result5.size: " + result5.size());
            //缓存，生效
            List<Account> result6 = accountMapper.selectByExample(example);
            System.out.println("result6.size: " + result6.size());

            //事务
            session.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void wongUserTestByAPI() {
        //1、SqlSessionFactoryBuilder根据配置(xml配置文件、Configuration类)构建SqlSessionFactory；
        //2、SqlSessionFactory构建SqlSession；
        //3、探究已映射的SQL语句
        try {
            PooledDataSource dataSource = new PooledDataSource();
            dataSource.setDriver("com.mysql.cj.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/wong_user?serverTimezone=UTC");
            dataSource.setUsername("root");
            dataSource.setPassword("123456");
            TransactionFactory transFactory = new JdbcTransactionFactory();
            Environment environment = new Environment("id", transFactory, dataSource);
            Configuration config = new Configuration(environment);
            //config.addMapper(AccountMapper.class);
            config.addMappers("com.yoong.mybatis.accidence.wong_user.dao");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(config);

            SqlSession sqlSession = factory.openSession();
            AccountExample example = new AccountExample();
            List<Account> result = sqlSession.selectList("com.yoong.mybatis.accidence.wong_user.dao.AccountMapper.selectByExample", example);
            System.out.println("result.size: " + result.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * parameterType
     * resultMap、resultType
     * 一级缓存、二级缓存
     * association、collection标签
     * 插件
     */
    private static void wongUserTestAssociation() {
        try {
            String resource = "mybatis-wong_user.xml";
            InputStream iStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(iStream);
            SqlSession session = factory.openSession();

            // 2、MyBatis用法：获取映射器
            AccountMapper accountMapper = session.getMapper(AccountMapper.class);
            //parameterType
            Account condition = new Account();
            condition.setAccountId("8");
            List<Account> conditionResult = accountMapper.selectByCondition(condition);
            System.out.println("conditionResult: " + conditionResult);

            //resultMap、resultType
            Account accountType = accountMapper.selectTypeById(57l);
            System.out.println("accountType: " + accountType);
            Account accountMap = accountMapper.selectMapById(57l);
            System.out.println("accountMap: " + accountMap);

            //一级缓存
            Account account = accountMapper.selectByCustomerId(9l);
            System.out.println("account: " + account);
            Account account01 = accountMapper.selectByCustomerId(9l);
            System.out.println("account01: " + account01);
            List<Account> accountList = accountMapper.selectAllByCustomerId(9l);
            System.out.println("accountList: " + accountList);

            //association、collection标签
            CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
            Customer customer = customerMapper.selectById(9l);
            System.out.println("customer: " + customer);
            Account account02 = customerMapper.selectAccountById(57l);
            System.out.println("account02: " + account02);

            //事务
            session.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
