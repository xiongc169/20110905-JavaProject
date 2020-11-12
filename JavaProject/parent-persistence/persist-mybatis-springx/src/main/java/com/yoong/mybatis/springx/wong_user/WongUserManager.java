package com.yoong.mybatis.springx.wong_user;

import com.alibaba.druid.pool.xa.DruidXADataSource;
import com.yoong.mybatis.springx.wong_user.dao.AccountMapper;
import com.yoong.mybatis.springx.wong_user.dao.AdminMapper;
import com.yoong.mybatis.springx.wong_user.distributedTx.MyXid;
import com.yoong.mybatis.springx.wong_user.domain.Account;
import com.yoong.mybatis.springx.wong_user.domain.AccountExample;
import com.yoong.mybatis.springx.wong_user.domain.Admin;
import com.yoong.mybatis.springx.wong_user.domain.AdminExample;
import com.yoong.mybatis.springx.wong_user.service.AccountService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.XAConnection;
import javax.sql.XADataSource;
import javax.transaction.xa.XAException;
import javax.transaction.xa.XAResource;
import javax.transaction.xa.Xid;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

/**
 * @Desc WongUserManager
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
//            sqlSessionTemplateDemo();
//            mapperFactoryDemo();
//            mapperScannerDemo();
            transactionDemo();
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

    /**
     * 事务
     */
    public static void transactionDemo() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:mybatis-spring.xml");
        AccountService accountService = (AccountService) context.getBean("accountService");
        accountService.insertAccounts();
        System.out.println("Finished");
    }

    /**
     * 分布式事务
     * http://www.gaodaima.com/40332.html
     * https://blog.csdn.net/weixin_34175509/article/details/92063248
     */
    public static void xaTransactionDemo() {
        XADataSource xaDS = null;
        XAConnection xaCon = null;
        XAResource xaRes = null;
        Xid xid = null;
        Connection con = null;
        Statement stmt = null;
        int ret;
        try {
            xaDS = new DruidXADataSource();
            xaCon = xaDS.getXAConnection();
            xaRes = xaCon.getXAResource();
            con = xaCon.getConnection();
            stmt = con.createStatement();
            xid = new MyXid(100, new byte[]{0x01}, new byte[]{0x02});
            xaRes.start(xid, XAResource.TMNOFLAGS);
            stmt.executeUpdate("insert into test_table values (100)");
            xaRes.end(xid, XAResource.TMSUCCESS);
            ret = xaRes.prepare(xid);
            if (ret == XAResource.XA_OK) {
                xaRes.commit(xid, false);
            }
        } catch (XAException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
                if (xaCon != null) {
                    xaCon.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}
