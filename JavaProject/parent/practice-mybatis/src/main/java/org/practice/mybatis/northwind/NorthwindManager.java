package org.practice.mybatis.northwind;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.practice.mybatis.northwind.domain.Categories;

public class NorthwindManager {

	public static void main(String[] args) {

		northwindTest();
	}

	/**
	 * 2018-6-1
	 */
	private static void northwindTest() {
		try {
			String resource = "mybatis-northwind.xml";
			InputStream iStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(iStream);
			SqlSession session = factory.openSession();
			Categories result = session
					.selectOne("org.practice.mybatis.northwind.dao.CategoriesMapper.selectByPrimaryKey", 28);
			System.out.println(result);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
