package com.yoong.jpa.api;

import com.yoong.jpa.api.dao.AccountDao;
import com.yoong.jpa.api.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @Desc AppHibernateJpa
 * <p>
 * @Author yoong
 * <p>
 * @Date 2019-10-29
 * <p>
 * @Version 1.0
 */
public class AppHibernateJpa {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            hibernateJpa();
            hibernateJpaSpring();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * JPA（二）：HellWord工程
     * https://www.cnblogs.com/yy3b2007com/p/9078123.html
     */
    public static void hibernateJpa() {
        //创建EntityManagerFactory
        //persistenceUnitName 需要与 META-INF/persistence.xml 文件中的持久化单元名称一致，否则报错：javax.persistence.PersistenceException: No Persistence provider for EntityManager named Jpa_helloworld1
        String persistenceUnitName = "Jpa_helloworld";
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Account account = new Account();
        account.setAccountId("accountId-001");
        account.setCreateTime(new Timestamp(new Date().getTime()));
        account.setModifyTime(new Timestamp(new Date().getTime()));
        account.setIsDelete(0);
        entityManager.persist(account);
        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    public static void hibernateJpaSpring() {
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
