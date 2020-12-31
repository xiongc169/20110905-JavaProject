package com.yoong.mybatis.api.source;

import org.apache.ibatis.jdbc.SQL;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.mybatis.spring.transaction.SpringManagedTransaction;

public class Chap04 {

    public static void mybatis_spring040204() throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        SpringManagedTransaction springManagedTransaction = new SpringManagedTransaction(null);
        SqlSessionTemplate sqlSessionTemplate = null;
        SqlSessionDaoSupport sqlSessionDaoSupport = null;
        MapperFactoryBean mapperFactoryBean = null;
        MapperScannerConfigurer mapperScannerConfigurer = null;
    }

    public static void ognl040302() throws Exception {
        //OgnlUtils.
        String mysql = new SQL() {
            {
                SELECT("*");
                FROM("a");
                INNER_JOIN("b on a.id=b.id");
                WHERE("a.age>10");
            }
        }.toString();
    }
}
