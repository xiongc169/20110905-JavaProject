package org.practice.springfx.book01.part04_dao.ch1401;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @Desc JdbcManager
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年8月20日
 * <p>
 * @Version 1.0
 */
public class JdbcManager {

    private static String mysqlDriver = "com.mysql.cj.jdbc.Driver";

    private static String mysqlUrl = "jdbc:mysql://127.0.0.1:3306/mysql?user=root&password=123456&serverTimezone=UTC";

    public static void jdbc140101() {
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
}
