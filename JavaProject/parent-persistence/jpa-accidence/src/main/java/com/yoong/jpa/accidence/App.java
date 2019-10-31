package com.yoong.jpa.accidence;

import com.yoong.jpa.accidence.dao.AccountDao;
import com.yoong.jpa.accidence.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void jpaDemo() {
        // 创建EntityManagerFactory
        String persistenceUnitName = "Jpa-helloword";
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Account account = new Account();
        account.setAccountId("accountId-001");
        entityManager.persist(account);
        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    public static void jpaSpring() {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath*:spring.xml"});
        AccountDao accountDao = (AccountDao) context.getBean("accountDao");
        Account account = new Account();
        account.setAccountId("accountId-001");
        accountDao.add(account);
    }
}
