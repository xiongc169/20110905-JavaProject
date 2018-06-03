package org.practice.mybatis;

import java.io.IOException;
import java.io.Reader;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.jndi.JndiDataSourceFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

/**
 * 
 * @author Administrator <br>
 *         http://www.cnblogs.com/xdp-gacl/p/4261895.html
 */
public class App {

	public static void main(String[] args) {
		// 1 构建SqlSessionFactory（从xml配置文件、Configuration类构建）
		// 2 构建SqlSession（从SqlSessionFactory构建）
		// 3 探究已映射的SQL语句
		getSqlSessionFromXml();

	}

	/**
	 * http://www.iteye.com/topic/1134147
	 * http://www.mybatis.org/mybatis-3/zh/getting-started.html
	 */
	public static void getSqlSessionFromXml() {
		try {
			Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");

			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			SqlSessionFactory factory = builder.build(reader);

			SqlSession session = factory.openSession();
			session.delete("org.practice.dao.dbo.CategoriesMapper.deleteByPrimaryKey", 32);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	/**
	 * http://www.mybatis.org/mybatis-3/zh/getting-started.html
	 */
	public static void getSqlSessionFromConfig() {
		try {
			SqlSessionFactory factory = null;
			DataSource dataSource = new JndiDataSourceFactory().getDataSource();
			TransactionFactory transFactory = new JdbcTransactionFactory();
			Environment environment = new Environment("id", transFactory, dataSource);
			Configuration config = new Configuration(environment);
			config.addMappers("");
			factory = new SqlSessionFactoryBuilder().build(config);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
