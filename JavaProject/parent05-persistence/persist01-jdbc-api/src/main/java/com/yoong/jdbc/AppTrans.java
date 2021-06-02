package com.yoong.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @Desc AppTrans
 * <p>
 * @Author zhiTongChe
 * <p>
 * @Date 2012-08-28 09:55:26
 * <p>
 * @Version 1.0
 */
public class AppTrans {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            jdbcTransactionTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void jdbcTransactionTest() {
        String mysqlDriver = "com.mysql.cj.jdbc.Driver";
        String mysqlUrl = "jdbc:mysql://127.0.0.1:3306/yoong_rehearsal?user=root&password=111111&serverTimezone=UTC";
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
            //System.out.println(10 / 0);
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
