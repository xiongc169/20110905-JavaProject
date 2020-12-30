package com.yoong.mybatis.api.source;

import org.apache.ibatis.builder.BaseBuilder;
import org.apache.ibatis.builder.StaticSqlSource;
import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.builder.xml.XMLStatementBuilder;
import org.apache.ibatis.executor.*;
import org.apache.ibatis.executor.keygen.Jdbc3KeyGenerator;
import org.apache.ibatis.executor.keygen.SelectKeyGenerator;
import org.apache.ibatis.executor.resultset.DefaultResultSetHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.*;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.scripting.defaults.RawSqlSource;
import org.apache.ibatis.scripting.xmltags.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionManager;
import org.apache.ibatis.session.defaults.DefaultSqlSession;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;

import javax.crypto.KeyGenerator;

public class Chap03 {

    public static void mybatisInit0301() throws Exception {
        BaseBuilder baseBuilder = null;
        XMLConfigBuilder xmlConfigBuilder = null;
        XMLMapperBuilder xmlMapperBuilder = null;
        XMLStatementBuilder xmlStatementBuilder = null;
    }

    public static void sqlSource_sqlNode0302() throws Exception {
        SqlNode sqlNode = null;
        MixedSqlNode mixedSqlNode = null;
        StaticTextSqlNode staticTextSqlNode = null;
        TextSqlNode textSqlNode = null;
        ForEachSqlNode forEachSqlNode = null;
        IfSqlNode ifSqlNode = null;
        VarDeclSqlNode varDeclSqlNode = null;
        TrimSqlNode trimSqlNode = null;
        ChooseSqlNode chooseSqlNode = null;

        SqlSource sqlSource = null;
        DynamicSqlSource dynamicSqlSource = null;
        RawSqlSource rawSqlSource = null;
        StaticSqlSource staticSqlSource = null;
    }

    public static void ognl030202() throws Exception {

    }

    public static void resultSetHandler0303() throws Exception {
        ResultSetHandler resultSetHandler = null;
        DefaultResultSetHandler defaultResultSetHandler = null;
    }

    public static void keyGenerator0304() throws Exception {
        KeyGenerator keyGenerator = null;
        Jdbc3KeyGenerator jdbc3KeyGenerator = null;
        SelectKeyGenerator selectKeyGenerator = null;
    }

    public static void statementHandler0305() throws Exception {
        StatementHandler statementHandler = null;
        RoutingStatementHandler routingStatementHandler = null;
        BaseStatementHandler baseStatementHandler = null;
        PreparedStatementHandler preparedStatementHandler = null;
        CallableStatementHandler callableStatementHandler = null;
        SimpleStatementHandler simpleStatementHandler = null;
    }

    public static void executor0306() throws Exception {
        Executor executor = null;
        BaseExecutor baseExecutor = null;
        CachingExecutor cachingExecutor = null;
        BatchExecutor batchExecutor = null;
        SimpleExecutor simpleExecutor = null;
        ReuseExecutor reuseExecutor = null;
        //ClosedExecutor closedExecutor = null;
    }

    public static void sqlSession0307() throws Exception {
        SqlSession sqlSession = null;
        DefaultSqlSession defaultSqlSession = null;
        SqlSessionManager sqlSessionManager = null;

        SqlSessionFactory sqlSessionFactory = null;
        DefaultSqlSessionFactory defaultSqlSessionFactory = null;
    }
}
