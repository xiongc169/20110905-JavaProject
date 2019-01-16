package org.practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 */
public class App {
    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            JdbcTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @description JDBC 连接 MySQL
     * @date 2018年6月1日
     * @version 1.0
     */
    private static void JdbcTest() {
        String driverName = "com.mysql.cj.jdbc.Driver";
        String mysqlUrl = "jdbc:mysql://127.0.0.1:3306/wong_user?serverTimezone=UTC";
        String userName = "root";
        String pwd = "123456";
        String sql = "select * from `account`";

        Connection conn = null;
        Statement stmt = null;
        ResultSet results = null;
        try {
            // 1、加载驱动
            Class.forName(driverName);
            // 2、创建连接 Connection
            conn = DriverManager.getConnection(mysqlUrl, userName, pwd);
            /*
             * 3、创建 Statement；
             * a.执行静态SQL语句，通常通过Statement实例实现；
             * b.执行动态SQL语句，通常通过PreparedStatement实例实现；
             * c.执行数据库存储过程，通常通过CallableStatement实例实现；
             */
            stmt = conn.createStatement();
            // 4、执行SQL
            results = stmt.executeQuery(sql);
            while (results.next()) {
                String column1 = results.getString(2);
                System.out.println(column1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (results != null) {
                    results.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
