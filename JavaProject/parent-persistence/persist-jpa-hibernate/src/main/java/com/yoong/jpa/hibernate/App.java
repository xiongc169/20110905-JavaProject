package com.yoong.jpa.hibernate;

import com.yoong.jpa.hibernate.dao.AccountDao;
import com.yoong.jpa.hibernate.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @Desc App
 * @Author
 * @Date
 * @Version 1.0
 */
public class App {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            jpaDemo();
            jpaSpring();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * JPA（二）：HellWord工程
     * https://www.cnblogs.com/yy3b2007com/p/9078123.html
     */
    public static void jpaDemo() {
        // 创建EntityManagerFactory
        String persistenceUnitName = "Jpa-helloword";
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Account account = new Account();
        account.setAccountId("accountId-001");
        account.setCreateTime(new Timestamp(new Date().getTime()));
        account.setModifyTime(new Timestamp(new Date().getTime()));
        entityManager.persist(account);
        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    public static void jpaSpring() {
        //PersistenceAnnotationBeanPostProcessor persistenceAnnotationBeanPostProcessor = new PersistenceAnnotationBeanPostProcessor();
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath*:spring.xml"});
        AccountDao accountDao = (AccountDao) context.getBean("accountDao");
        Account account = new Account();
        account.setAccountId("accountId-001");
        accountDao.add(account);

        Account account1 = accountDao.get(1l);
        System.out.println(account1.getAccountId());
        account1 = accountDao.get(1l);
        System.out.println(account1.getAccountId());
    }
}
