package org.practice.jdbc;

import java.sql.*;
import java.sql.DriverManager;

/**
 * 数据库管理
 * <p>
 * http://www.cnblogs.com/yokoboy/archive/2013/03/01/2939315.html
 *
 * @author chaoxiong
 * @version 2015-08-28 09:55:26
 */
public class DBManager {

    // sql server驱动类
    private static String sqlServerDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    private static String sqlServerURL = "jdbc:sqlserver://localhost:1433;DatabaseName=Northwind;user=sa;password=111111";

    // mysql驱动类
    private static String mySQLDriver = "com.mysql.jdbc.Driver";

    private static String mySQLURL = "jdbc:mysql://127.0.0.1:3306/mysql?user=root&password=123456&serverTimezone=UTC";

    // mycat连接串
    private static String mycatURL = "jdbc:mysql://127.0.0.1:8066/TESTDB?user=root&password=123456";

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        Connection dbConn = null;
        try {
            // Sql Server
            String northwindSql = "select * from Categories";
            String northwindInsert = "INSERT INTO Categories(CategoryName,Description,Picture) VALUES('CategoryName', 'Description', 'Picture')";
            // MySQL
            String mysql = "select * from `user`";
            String mycatSql = "select * from travelrecord";
            // 插入到
            String insertSql = "INSERT INTO `travelrecord` (`id`, `user_id`, `traveldate`, `fee`, `days`) VALUES ('15000002', '2', '2017-10-22', '2', '2')";
            String insertNewSql = "INSERT INTO `hotnews` (`id`, `news_title`, `content`, `producer`, `createdate`) VALUES ('1', 'NewTitle', 'NewContent', 'Producer', '2017-11-2');";
            String insertCompanySql = "INSERT INTO `company` (`id`, `companyname`, `leader`, `createtime`) VALUES ('5', 'CompanyName', 'Leader', '2017-11-2');";
            String insertEmployeeSql = "INSERT INTO `employee` (`sharding_id`, `employeename`, `sex`, `createtime`) VALUES ('10010', 'EmployeeName', 'male', '2017-11-2');";

            String insertCustomerSql = "INSERT INTO `customer` (`id`, `customername`, `createtime`) VALUES ('4', 'customerName4', '2017-11-2');";
            String insertCustomerAddrSql = "INSERT INTO `customer_addr` (`id`, `addressname`, `customer_id`, `createtime`) VALUES ('3', 'anhui2', '3', '2017-11-2');";

            dbConn = getConnection(mySQLDriver, mySQLURL);
            executeQuery(dbConn, mysql);
            //exeInsert(dbConn, northwindInsert);

            // SQL Server
            // String sql = "select * from [Employees]";
            // dbConn = getConnection(sqlServerDriver, sqlServerURL);
            // exeCmd(dbConn, sql);
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
                PreparedStatement prepStmt = conn.prepareStatement(sql);
                // PreparedStatement pstmt=dbConn.prepareStatement("");
                // CallableStatement cstmt=dbConn.prepareCall("{CALL demoSp(? ,
                // ?)}");
                // ResultSet rs = stmt.executeQuery("select * from [Employees]
                // where userName = ?");
                ResultSet rs = prepStmt.executeQuery();
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
                PreparedStatement prepStmt = conn.prepareStatement(sql);
                boolean rs = prepStmt.execute();

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
