package com.yoong.hibernate.accidence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.yoong.hibernate.accidence.domain.Account;

import java.util.Date;

/**
 * Hibernate API
 *
 * @author chaoxiong
 * @version 2015-10-28 19:55:26
 * @desc Hibernate框架简述
 * http://www.cnblogs.com/eflylab/archive/2007/01/09/615338.html
 */
public class App {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            hibernateDemo();
            hbm2ddl();
            hbm2ddlByAnnotation();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void hibernateDemo() {
        //hibernate.cfg.xml，不给参数就默认加载hibernate.cfg.xml文件
        Configuration cfg = new Configuration().configure();
        //SessionFactory
        SessionFactory sf = cfg.buildSessionFactory();
        //session
        Session session = sf.openSession();
        //Transaction接口
        Transaction tx = (Transaction) session.beginTransaction();

        Account account = new Account();
        account.setAccountId("111111111");
        account.setContactName("name");
        account.setPassword("password");
        account.setMobile("mobile");
        account.setCreateTime(new Date());
        account.setModifyTime(new Date());
        account.setIsDelete(0);
        session.save(account);

        tx.commit();
    }

    /**
     * 【SSH进阶之路】Hibernate搭建开发环境+简单实例（二）
     * PS：将hbm生成ddl，即hbm2ddl
     * http://blog.csdn.net/jiuqiyuliang/article/details/39380465
     */
    public static void hbm2ddl() {
        try {
            Configuration cfg = new Configuration().configure();
            //SchemaExport export = new SchemaExport(cfg);
            //export.create(true, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 【SSH进阶之路】Hibernate搭建开发环境+简单实例（三）
     * PS：将hbm生成ddl，即hbm2ddl
     * https://blog.csdn.net/jiuqiyuliang/article/details/40153905
     */
    public static void hbm2ddlByAnnotation() {
        try {
            //默认读取hibernate.cfg.xml文件
            //Configuration cfg = new AnnotationConfiguration().configure();
            //SchemaExport export = new SchemaExport(cfg);
            //export.create(true, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
