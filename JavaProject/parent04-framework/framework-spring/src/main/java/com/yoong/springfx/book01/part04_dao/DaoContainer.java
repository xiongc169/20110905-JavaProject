package com.yoong.springfx.book01.part04_dao;

import com.yoong.springfx.book01.part04_dao.ch1401.JdbcManager;
import com.yoong.springfx.book01.part04_dao.ch1401.MyJdbcDaoSupport;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @Desc DaoContainer
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年8月20日
 * <p>
 * @Version 1.0
 */
public class DaoContainer {

    private static String mysqlUrl = "jdbc:mysql://127.0.0.1:3306/yoong_rehearsal?serverTimezone=UTC";

    private static String username = "root";

    private static String password = "123456";

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            JdbcManager.jdbc140101();
            jdbcTemplate140102();
            datasource140104();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * TODO: 14.1.2、JdbcTemplate的诞生
     * TODO: 14.1.3、JdbcTemplate和它的兄弟们
     */
    public static void jdbcTemplate140102() throws Exception {
        String querySql = "SELECT * FROM `test`";
        String querySql01 = "SELECT * FROM `test` LIMIT 1";
        DataSource dataSource = new DriverManagerDataSource(mysqlUrl, username, password);
        //Connection connection = dataSource.getConnection();

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(mysqlUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        //创建
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        //RowMapper 的使用
        List<String> queryResult = jdbcTemplate.query(querySql, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                String column01 = resultSet.getString(1);
                System.out.println(column01);
                return column01;
            }
        });
        System.out.println(queryResult.size());

        //StatementCallback 的使用
        Object executeResult = jdbcTemplate.execute(new StatementCallback<Object>() {
            @Override
            public Object doInStatement(Statement statement) throws SQLException, DataAccessException {
                boolean result = statement.execute(querySql01);
                return result;
            }
        });
        System.out.println(executeResult);

        //使用 DataSourceUtils 管理 Connection
        Connection connection02 = DataSourceUtils.getConnection(dataSource);
        System.out.println(connection02);
    }

    /**
     * TODO: 14.1.4、Spring中的DataSource
     */
    public static void datasource140104() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        SingleConnectionDataSource singleConnectionDataSource = new SingleConnectionDataSource();
        BasicDataSource basicDataSource = new BasicDataSource();

        MyJdbcDaoSupport myJdbcDaoSupport = new MyJdbcDaoSupport();
        DataSource dataSource = myJdbcDaoSupport.getDataSource();
    }
}
