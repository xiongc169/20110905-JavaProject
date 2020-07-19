package org.practice.springfx.book01.part05_tx;

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

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
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

            platformTransactionManager200101();
            transactionTemplate200102();
            savepoint200103();
            declareTransaction200201();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * TODO: 第十八章、群雄逐鹿下的Java事务
     */
    private static void jdbcTransaction1801() {
        String mysqlInsert = "INSERT INTO `test`(`name`) VALUES ('8888');";
        String mysqlUpdate = "UPDATE `test` SET `name`='Modified' WHERE id=1;";

        Connection conn = null;
        try {
            Class.forName(mysqlDriver);
            conn = DriverManager.getConnection(mysqlFullUrl);
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
        PlatformTransactionManager tManager = new DataSourceTransactionManager();
        TransactionDefinition tDefinition = new DefaultTransactionDefinition();
        TransactionStatus tStatus = tManager.getTransaction(tDefinition);
        tManager.commit(tStatus);
    }

    /**
     * TODO: 第二十章、使用Spring进行事务管理
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
    }

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
                System.out.println("Finished Execute");
            }
        });
        System.out.println("Finished TransactionTemplate");
    }

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

    public static void declareTransaction200201() {
        TransactionInterceptor transactionInterceptor = new TransactionInterceptor();
    }
}
