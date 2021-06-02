package com.yoong.jdbc;

import java.sql.*;

/**
 * @Desc MySQL JDBC URL中几个重要参数说明
 * http://www.cnblogs.com/yokoboy/archive/2013/03/01/2939315.html
 * <p>
 * @Author zhiTongChe
 * <p>
 * @Date 2012-08-28 09:55:26
 * <p>
 * @Version 1.0
 */
public class DBManager {

    // sql server驱动类
    private static String sqlServerDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String sqlServerURL = "jdbc:sqlserver://localhost:1433;DatabaseName=Northwind;user=sa;password=111111";

    // mysql驱动类
    private static String mySqlDriver = "com.mysql.jdbc.Driver";
    private static String mySqlURL = "jdbc:mysql://127.0.0.1:3306/yoong_rehearsal?user=root&password=123456&serverTimezone=UTC";

    // mycat连接串
    private static String myCatURL = "jdbc:mysql://127.0.0.1:8066/TESTDB?user=root&password=123456";

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        Connection dbConn = null;
        try {
            //Sql Server脚本
            String northWindSql = "select * from Categories";
            String northWindInsert = "INSERT INTO Categories(CategoryName,Description,Picture) VALUES('CategoryName', 'Description', 'Picture')";
            //MySQL脚本
            String mySql = "select * from `user`";
            String mysqlInsert = "INSERT INTO `test`(`name`) VALUES ('8888');";
            String myCatSql = "select * from travelrecord";

            //操作MySQL数据库
            dbConn = getConnection(mySqlDriver, mySqlURL);
            executeQuery(dbConn, mySql);
            exeInsert(dbConn, mysqlInsert);

            //操作SQL Server数据库
            String sql = "select * from [Employees]";
            dbConn = getConnection(sqlServerDriver, sqlServerURL);
            exeInsert(dbConn, sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Connection getConnection(String driver, String url) {
        Connection dbConn = null;
        try {
            Class.forName(driver);
            dbConn = DriverManager.getConnection(url);
            return dbConn;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("数据库连接异常");
        }
        return dbConn;
    }

    public static void executeQuery(Connection conn, String sql) throws Exception {
        try {
            // 1、执行静态SQL语句。通常通过Statement实例实现。
            // 2、执行动态SQL语句。通常通过PreparedStatement实例实现。
            // 3、执行数据库存储过程。通常通过CallableStatement实例实现。
            if (conn != null) {
                Statement stmt = conn.createStatement();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                CallableStatement cstmt = conn.prepareCall("{CALL demoSp(?, ?)}");
                ResultSet rs = stmt.executeQuery("select * from [Employees] where userName = ? ");
                ResultSet rs02 = pstmt.executeQuery();
                while (rs.next()) {
                    // 列是从左到右编号的，并且从列1开始
                    String host = rs.getString(1);
                    String user = rs.getString(2);
                    System.out.println(host + "  " + user);
                }
                if (rs != null) { // 关闭记录集
                    try {
                        rs.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (stmt != null) { // 关闭声明
                    try {
                        stmt.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("数据库连接异常");
        }
    }

    public static void exeInsert(Connection conn, String sql) throws Exception {
        try {
            // 1、执行静态SQL语句。通常通过Statement实例实现。
            // 2、执行动态SQL语句。通常通过PreparedStatement实例实现。
            // 3、执行数据库存储过程。通常通过CallableStatement实例实现。
            if (conn != null) {
                Statement stmt = conn.createStatement();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                boolean rs = pstmt.execute();
                if (stmt != null) { // 关闭声明
                    try {
                        stmt.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("数据库连接异常");
        }
    }
}
