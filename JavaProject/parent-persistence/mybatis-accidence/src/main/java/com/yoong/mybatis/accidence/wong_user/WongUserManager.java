package com.yoong.mybatis.accidence.wong_user;

import org.apache.ibatis.datasource.jndi.JndiDataSourceFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import com.yoong.mybatis.accidence.wong_user.dao.AccountMapper;
import com.yoong.mybatis.accidence.wong_user.domain.Account;
import com.yoong.mybatis.accidence.wong_user.domain.AccountExample;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author yoong
 * <br>
 * @desc WongUserManager
 * <br>
 * @date 2018/1/16 16:41
 */
public class WongUserManager {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            wongUserTestByXml();
            wongUserTestByConfig();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void wongUserTestByXml() {
        //1、SqlSessionFactoryBuilder根据配置(xml配置文件、Configuration类)构建SqlSessionFactory；
        //2、SqlSessionFactory构建SqlSession；
        //3、探究已映射的SQL语句
        try {
            String resource = "mybatis-wong_user.xml";
            InputStream iStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(iStream);
            SqlSession session = factory.openSession();
            AccountExample example = new AccountExample();
            // 1、iBatis用法：命名空间+SQL Id
            List<Account> result = session.selectList("com.yoong.mybatis.accidence.wong_user.dao.AccountMapper.selectByExample", example);
            System.out.println(result.size());

            // 2、MyBatis用法：获取映射器
            String accountId = "ac-123456789";
            example.createCriteria().andAccountIdEqualTo(accountId);
            AccountMapper accountMapper = session.getMapper(AccountMapper.class);
            List<Account> result2 = accountMapper.selectByExample(example);
            System.out.println(result2.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void wongUserTestByConfig() {
        //1、SqlSessionFactoryBuilder根据配置(xml配置文件、Configuration类)构建SqlSessionFactory；
        //2、SqlSessionFactory构建SqlSession；
        //3、探究已映射的SQL语句
        try {
            SqlSessionFactory factory = null;
            DataSource dataSource = new JndiDataSourceFactory().getDataSource();
            TransactionFactory transFactory = new JdbcTransactionFactory();
            Environment environment = new Environment("id", transFactory, dataSource);
            Configuration config = new Configuration(environment);
            config.addMappers("");
            factory = new SqlSessionFactoryBuilder().build(config);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
