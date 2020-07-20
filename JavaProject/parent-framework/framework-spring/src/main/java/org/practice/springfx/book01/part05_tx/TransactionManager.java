package org.practice.springfx.book01.part05_tx;

import org.practice.springfx.book01.service.IQuoteService;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.TransactionInterceptor;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.sql.Statement;

/**
 * @Desc TransactionManager
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年8月20日
 * <p>
 * @Version 1.0
 */
public class TransactionManager {

    private static String mysqlDriver = "com.mysql.cj.jdbc.Driver";

    private static String mysqlFullUrl = "jdbc:mysql://127.0.0.1:3306/mysql?user=root&password=123456&serverTimezone=UTC";

    private static String mysqlUrl = "jdbc:mysql://127.0.0.1:3306/mysql?serverTimezone=UTC";

    private static String userName = "root";

    private static String password = "123456";

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            jdbcTransaction1801();
            springTransaction1901();

            //20.1、编程式事务
            platformTransactionManager200101();
            transactionTemplate200102();
            savepoint200103();

            //20.2、声明式事务
            proxyFactoryBean200202();
            transactionProxyFactoryBean200202();
            beanNameAutoProxyCreator200202();
            xmlSchema200202();

            //20.2.3、注解元数据驱动的声明式事务
            annotation200203();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * TODO: 第十八章、群雄逐鹿下的Java事务
     */
    public static void jdbcTransaction1801() {
        String mysqlInsert = "INSERT INTO `test`(`name`) VALUES ('8888');";
        String mysqlUpdate = "UPDATE `test` SET `name`='Modified' WHERE id=1;";

        java.sql.Connection conn = null;
        try {
            Class.forName(mysqlDriver);
            conn = java.sql.DriverManager.getConnection(mysqlFullUrl);
            System.out.println(com.mysql.cj.jdbc.ConnectionImpl.class);

            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            boolean result = stmt.execute(mysqlInsert);
            System.out.println(result);
            //double aa = 10 / 0;
            boolean result2 = stmt.execute(mysqlUpdate);
            System.out.println(result2);
            conn.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            try {
                conn.rollback();
            } catch (Exception ex2) {
                ex2.printStackTrace();
            }
        }
    }

    /**
     * TODO: 第十九章、Spring事务王国的架构
     */
    public static void springTransaction1901() {
        PlatformTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        TransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(defaultTransactionDefinition);
        dataSourceTransactionManager.commit(transactionStatus);
    }

    /**
     * TODO: 20.1.1、使用 PlatformTransactionManager 进行编程式事务管理
     */
    public static void platformTransactionManager200101() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource(mysqlUrl, userName, password);

        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        defaultTransactionDefinition.setIsolationLevel(TransactionDefinition.ISOLATION_DEFAULT);
        defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(driverManagerDataSource);
        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(defaultTransactionDefinition);
        try {
            String querySql = "UPDATE `test` SET `name` = 'Modified' WHERE `id` = 1;";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(driverManagerDataSource);
            jdbcTemplate.execute(querySql);
            //transactionStatus.setRollbackOnly();
        } catch (Exception ex) {
            ex.printStackTrace();
            dataSourceTransactionManager.rollback(transactionStatus);
        }
        dataSourceTransactionManager.commit(transactionStatus);
        System.out.println("Finished PlatformTransactionManager");
    }

    /**
     * TODO: 20.1.2、使用 TransactionTemplate 进行编程式事务管理
     */
    public static void transactionTemplate200102() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(mysqlUrl, userName, password);
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);
        TransactionTemplate transactionTemplate = new TransactionTemplate(dataSourceTransactionManager);

        String querySql = "UPDATE `test` SET `name` = 'Modified' WHERE `id` = 1;";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                jdbcTemplate.execute(querySql);
                //transactionStatus.setRollbackOnly();
                System.out.println("Finished Execute");
            }
        });
        System.out.println("Finished TransactionTemplate");
    }

    /**
     * TODO: 20.1.3、编程创建基于 Savepoint 的嵌套事务
     */
    public static void savepoint200103() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(mysqlUrl, userName, password);
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);
        TransactionTemplate transactionTemplate = new TransactionTemplate(dataSourceTransactionManager);

        String querySql = "UPDATE `test` SET `name` = 'Modified' WHERE `id` = 1;";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                jdbcTemplate.execute(querySql);
                Object savepoint = transactionStatus.createSavepoint();
                try {
                    String querySql01 = "UPDATE `test` SET `name` = 'savepoint' WHERE `id` = 15;";
                    jdbcTemplate.execute(querySql01);
                    double div = 100 / 0;
                } catch (Exception ex) {
                    //如果不回滚到Savepoint，则 querySql01 也会执行生效
                    transactionStatus.rollbackToSavepoint(savepoint);
                    String querySql02 = "UPDATE `test` SET `name` = 'savepoint' WHERE `id` = 16;";
                    jdbcTemplate.execute(querySql02);
                } finally {
                    transactionStatus.releaseSavepoint(savepoint);
                }
                System.out.println("Finished Execute");
            }
        });
        System.out.println("Finished Savepoint");
    }

    /**
     * TODO: 20.2、声明式事务管理
     * PS：ProxyFactoryBean + TransactionInterceptor
     */
    public static void proxyFactoryBean200202() {
        ProxyFactory proxyFactory = new ProxyFactory();
        //proxyFactory.setTarget(null);
        //proxyFactory.addAdvice(null);
        //Object proxy = proxyFactory.getProxy();

        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        //proxyFactoryBean.setTarget(null);
        //proxyFactoryBean.setInterceptorNames("");
        //Object proxy02 = proxyFactoryBean.getObject();

        TransactionInterceptor transactionInterceptor = new TransactionInterceptor();

        //有事务
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("book01/tx/spring200202a-proxyfactory.xml");
        IQuoteService quoteServiceImpl = (IQuoteService) applicationContext.getBean("quoteService");
        quoteServiceImpl.updateAccount();
        System.out.println("Finished CommonBean");

        //没有事务
        IQuoteService quoteServiceProxy = (IQuoteService) applicationContext.getBean("proxyFactoryBean");
        quoteServiceProxy.updateAccount();
        System.out.println("Finished ProxyFactoryBean");
    }

    /**
     * TODO: 20.2、声明式事务管理
     * PS：TransactionProxyFactoryBean
     */
    public static void transactionProxyFactoryBean200202() {
        //有事务
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("book01/tx/spring200202b-txproxyfactory.xml");
        IQuoteService quoteServiceImpl = (IQuoteService) applicationContext.getBean("quoteService");
        quoteServiceImpl.updateAccount();
        System.out.println("Finished CommonBean");

        //没有事务
        IQuoteService quoteServiceProxy = (IQuoteService) applicationContext.getBean("transactionProxyFactoryBean");
        quoteServiceProxy.updateAccount();
        System.out.println("Finished TransactionProxyFactoryBean");
    }

    /**
     * TODO: 20.2、声明式事务管理
     * PS：BeanNameAutoProxyCreator + TransactionInterceptor
     */
    public static void beanNameAutoProxyCreator200202() {
        //有事务
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("book01/tx/spring200202c-autoproxycreator.xml");
        IQuoteService quoteServiceImpl = (IQuoteService) applicationContext.getBean("quoteService");
        quoteServiceImpl.updateAccount();
        System.out.println("Finished BeanNameAutoProxyCreator");
    }

    /**
     * TODO: 20.2、声明式事务管理
     * PS：XML Schema
     */
    public static void xmlSchema200202() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("book01/tx/spring200202d-xml.xml");
        IQuoteService quoteServiceImpl = (IQuoteService) applicationContext.getBean("quoteService");
        quoteServiceImpl.updateAccount();
        System.out.println("Finished Xml Schema");
    }

    /**
     * TODO: 20.2、声明式事务管理
     * PS：注解
     */
    public static void annotation200203() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("book01/tx/spring200203-annotation.xml");
        IQuoteService quoteServiceImpl = (IQuoteService) applicationContext.getBean("quoteService");
        quoteServiceImpl.updateAccount();
        System.out.println("Finished Annotation");
    }
}
