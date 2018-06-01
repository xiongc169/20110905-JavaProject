package org.practice.mybatis.chap;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.practice.mybatis.chap.dao.NoticeMapper;
import org.practice.mybatis.chap.domain.Accounts;
import org.practice.mybatis.chap.domain.Notice;
import org.practice.mybatis.chap.domain.NoticeExample;

/**
 * 
 * @author Administrator
 *
 */
public class MyBatisTest {

	public static void main(String[] args) {
		// 1 构建SqlSessionFactory（从xml配置文件、Configuration类构建）
		// 2 构建SqlSession（从SqlSessionFactory构建）
		// 3 探究已映射的SQL语句
		mybatisTest();

	}

	public static void mybatisTest() {
		SqlSession session = null;
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-mysql.xml");

			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			SqlSessionFactory factory = builder.build(reader);

			session = factory.openSession();
			// 1、iBatis用法：命名空间+SQL Id
			// session.select("org.practice.mybatis.chap.dao.AccountsMapper.selectByPrimaryKey",
			// "201609191454299903499203", null);
			// session.commit();

			// 2、MyBatis用法：获取映射器
			NoticeExample noticeDot = new NoticeExample();
			NoticeMapper noticeDao = session.getMapper(NoticeMapper.class);
			List<Notice> noticeList = noticeDao.selectByExample(noticeDot);
			int count = noticeList.size();
			System.out.println("Notice Length:" + count);

			Notice notice = noticeDao.selectByPrimaryKey("DC198D89-4A54-423C-8B05-00029D493D61");
			System.out.println(notice.getTitle());

		} catch (Exception e) {
			e.printStackTrace();
			// session.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// 2018-6-1
	private static void mybatisTest2() {
		ClassLoader loader = Resources.getDefaultClassLoader();

		try {
			String resource = "mybatis-mysql.xml";
			InputStream iStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(iStream);
			SqlSession session = factory.openSession();
			Object result = session.selectOne("mybatis.demo.mapper.UserMapper.countUser");
			System.out.println(result);

			List<Accounts> result2 = session.selectList("mybatis.demo.mapper.UserMapper.selectUserByHost", "%");
			System.out.println(result2.size());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
