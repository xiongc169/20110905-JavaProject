package org.practice.spring.transaction;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @Desc App4SpringTrans
 * @Author
 * @Date
 * @Version 1.0
 */
public class App4SpringTx {

    public static void main(String[] args) {

        PlatformTransactionManager tManager = new DataSourceTransactionManager();
        TransactionDefinition tDefinition = new DefaultTransactionDefinition();
        TransactionStatus tStatus = tManager.getTransaction(tDefinition);
        tManager.commit(tStatus);

        String mysqlDriver = "com.mysql.cj.jdbc.Driver";
        String mysqlUrl = "jdbc:mysql://127.0.0.1:3306/mysql?user=root&password=123456&serverTimezone=UTC";
        String mysqlInsert = "INSERT INTO `test`(`name`) VALUES ('8888');";
        String mysqlUpdate = "UPDATE `test` SET `name`='Modified' WHERE id=1;";

        Connection conn = null;
        try {
            Class.forName(mysqlDriver);
            conn = DriverManager.getConnection(mysqlUrl);
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            boolean result = stmt.execute(mysqlInsert);
            System.out.println(result);
//            System.out.println(10 / 0);
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
}
