package com.yoong.hibernate.accidence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.yoong.hibernate.accidence.domain.Account;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Date;

/**
 * @Desc Hibernate框架简述
 * PS：核心组件：Configuration、SessionFactory、Session、Query、Transaction接口；
 * JavaBean的三种状态：临时状态(transient)、持久化状态(persistent)、脱管状态(detached)；
 * http://www.cnblogs.com/eflylab/archive/2007/01/09/615338.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015-10-28 19:55:26
 * <p>
 * @Version 1.0
 */
public class App {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            hibernateDemo();
            entityManagerDemo();
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
        //Query query = session.createQuery("");

        Account account = new Account();
        account.setAccountId("111111111");
        account.setContactName("name");
        account.setPassword("password");
        account.setMobile("mobile");
        account.setCreateTime(new Date());
        account.setModifyTime(new Date());
        account.setIsDelete(0);
        //注意：Session有多种方法，可以进行增删改查！！！
        session.save(account);

        tx.commit();
        tx.rollback();
    }

    /**
     * jpa查询笔记之CriteriaBuilder类和Predicate类
     * PS：EntityManager em = session.getEntityManagerFactory().createEntityManager();
     * https://blog.csdn.net/qq_41063141/article/details/94408073
     */
    public static void entityManagerDemo() {
        //hibernate.cfg.xml，不给参数就默认加载hibernate.cfg.xml文件
        Configuration cfg = new Configuration().configure();
        //SessionFactory
        SessionFactory sf = cfg.buildSessionFactory();
        //session
        Session session = sf.openSession();
        //Transaction接口
        Transaction tx = (Transaction) session.beginTransaction();
        EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        Account account = new Account();
        account.setAccountId("111111111");
        account.setContactName("name");
        account.setPassword("password");
        account.setMobile("mobile");
        account.setCreateTime(new Date());
        account.setModifyTime(new Date());
        account.setIsDelete(0);
        entityManager.persist(account);
        entityManager.flush();
        transaction.commit();
        System.out.println(account.getId());
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
