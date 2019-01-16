package org.practice.mybatis.wong_user;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.practice.mybatis.wong_user.domain.Account;
import org.practice.mybatis.wong_user.domain.AccountExample;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author yoong
 * <br>
 * @desc WongUserManager
 * <br>
 * @date 2019/1/16 16:41
 */
public class WongUserManager {

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        // 1 构建SqlSessionFactory（从xml配置文件、Configuration类构建）
        // 2 构建SqlSession（从SqlSessionFactory构建）
        // 3 探究已映射的SQL语句
        try {
            wongUserTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 2018-6-1
     */
    private static void wongUserTest() {
        try {
            String resource = "mybatis-wong_user.xml";
            InputStream iStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(iStream);
            SqlSession session = factory.openSession();

            AccountExample example = new AccountExample();
            List<Account> result = session.selectList("org.practice.mybatis.wong_user.dao.AccountMapper.selectByExample", example);
            System.out.println(result.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
