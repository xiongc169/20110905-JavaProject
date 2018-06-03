package org.practice.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.practice.hibernate.domain.Categories;


/**
 * Hibernate API
 * 
 * @author chaoxiong
 * @version 2015-10-28 19:55:26 ����ͨhibernate�� �־û��ࡢ�����ļ���ӳ���ļ�����
 *          ע�⣺�־û��ࡢӳ���ļ�������ת������hbm2java\hbm2ddl
 *          ע�⣺hibernateӳ���ļ���ӳ����������ͨ���ԡ����ϡ������hibernate�����������ô洢���̣� ע�⣺hql�����ݿ����ӳ�
 * 
 *          http://www.cnblogs.com/eflylab/archive/2007/01/09/615338.html
 *          (Hibernate��ܼ���)
 */
public class HibernateTest {

	public static void main(String[] args) {
		hbm2ddl();
	}

	public static void hibernateTest() {
		try {
			// ��ȡhibernate.cfg.xml�ļ�
			Configuration cfg = new Configuration().configure();
			// ����SessionFactory
			SessionFactory sf = cfg.buildSessionFactory();
			// ȡ��session
			Session session = sf.openSession();
			Transaction tx = (Transaction) session.beginTransaction();

			Categories category = new Categories();
			category.setCategoryName("chao");
			category.setDescription("this is delicious");

			session.save(category);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * http://blog.csdn.net/jiuqiyuliang/article/details/39380465
	 */
	public static void hbm2ddl() {
		try {
			Configuration cfg = new Configuration().configure();
//			SchemaExport export = new SchemaExport(cfg);
//			export.create(true, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
