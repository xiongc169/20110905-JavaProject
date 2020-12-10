package com.yoong.jdbc;

import java.sql.*;
import java.util.Enumeration;
import java.util.Scanner;

/**
 * @Desc AppJdbc
 * <p>
 * @Author zhiTongChe
 * <p>
 * @Date 2012-08-28 09:55:26
 * <p>
 * @Version 1.0
 */
public class AppJdbc {

    private static String driverName = "com.mysql.cj.jdbc.Driver";
    private static String mysqlUrl = "jdbc:mysql://127.0.0.1:3306/wong_user?serverTimezone=UTC";
    private static String userName = "root";
    private static String pwd = "123456";

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            //Class.forName
            classForName();

            //Statement, SQL拼接，会发生SQL注入
            statementDemo();

            //PreparedStatement, 预编译SQL，提高执行效率，防止SQL注入
            preparedStatementDemo();

            //CallableStatement, 调用存储过程
            callableStatementDemo();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Class.forName
     */
    public static void classForName() throws Exception {
        Enumeration<Driver> beforeDriverList = DriverManager.getDrivers();
        Class driverClazz = Class.forName(driverName);
        Enumeration<Driver> afterDriverList = DriverManager.getDrivers();

        Class appClazz = Class.forName("com.yoong.jdbc.AppTrans");
        System.out.println(appClazz);
    }

    /**
     * Statement
     * Connection\Statement\ResultSet都是java定义的接口，具体的实现类由具体的数据库厂商提供。如MySQL，实现类ConnectionImpl\StatementImpl\ResultSetImpl，在mysql-connector-java.jar包中。
     * 创建 Statement: a.执行静态SQL语句，通常通过Statement实例实现；
     * b.执行动态SQL语句，通常通过PreparedStatement实例实现；
     * c.执行数据库存储过程，通常通过CallableStatement实例实现；
     */
    public static void statementDemo() {
        String sql = "select * from `account`";
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();//输入：13 or 1=1
        if (id != null) {
            sql = sql + "where id =" + id;
        }

        Connection conn = null;
        Statement stmt = null;
        ResultSet results = null;
        try {
            // 1、加载驱动：com.mysql.cj.jdbc.Driver
            Class clazz = Class.forName(driverName);
            //DriverManager.registerDriver(com.mysql.cj.jdbc.Driver);
            // 2、创建连接 Connection
            conn = DriverManager.getConnection(mysqlUrl, userName, pwd);
            // 3、创建 Statement
            stmt = conn.createStatement();
            // 4、执行SQL
            results = stmt.executeQuery(sql);
            while (results.next()) {
                String column1 = results.getString(2);
                System.out.println(column1);
            }

            boolean executeResult = stmt.execute(sql);
            if (executeResult) {
                ResultSet result02 = stmt.getResultSet();
                while (result02.next()) {
                    String column1 = result02.getString(2);
                    System.out.println(column1);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            close(conn, stmt, results);
        }
    }

    /**
     * PreparedStatement
     */
    public static void preparedStatementDemo() {
        String sql = "select * from `account` where id = ?";
        Scanner scanner = new Scanner(System.in);
        //输入：13 or 1=1
        //输入：13' or '1'='1
        String id = scanner.nextLine();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet results = null;
        try {
            // 1、加载驱动：com.mysql.cj.jdbc.Driver
            Class clazz = Class.forName(driverName);
            // 2、创建连接 Connection
            conn = DriverManager.getConnection(mysqlUrl, userName, pwd);
            // 3、创建 Statement
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, id);
            // 4、执行SQL
            String preparedSql = stmt.toString();
            System.out.println(preparedSql);
            results = stmt.executeQuery();
            while (results.next()) {
                String column1 = results.getString(2);
                System.out.println(column1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            close(conn, stmt, results);
        }
    }

    /**
     * CallableStatement
     */
    public static void callableStatementDemo() {
        String procName = "CALL getName()";
        Connection conn = null;
        CallableStatement stmt = null;
        ResultSet results = null;
        try {
            // 1、加载驱动：com.mysql.cj.jdbc.Driver
            Class clazz = Class.forName(driverName);
            // 2、创建连接 Connection
            conn = DriverManager.getConnection(mysqlUrl, userName, pwd);
            // 3、创建 Statement
            stmt = conn.prepareCall(procName);
            // 4、执行SQL
            results = stmt.executeQuery();
            while (results.next()) {
                String column1 = results.getString(2);
                System.out.println(column1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            close(conn, stmt, results);
        }
    }

    private static void close(Connection conn, Statement stmt, ResultSet results) {
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
