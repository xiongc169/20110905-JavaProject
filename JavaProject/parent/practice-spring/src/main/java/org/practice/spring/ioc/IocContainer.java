package org.practice.spring.ioc;

import org.practice.spring.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class IocContainer {

	/**
	 * 入口函数
	 */
	public static void main(String[] args) {
		applicatioinDemo();
	}

	/**
	 * BeanFactory
	 */
	public static void beanFactoryDemo() {
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource(""));
		factory.getBean("");
	}

	/**
	 * Resource\ResourceLoader
	 */
	public static void resourceDemo() {
		// Resource res = new ByteArrayResource();

		ResourceLoader resLoader = new DefaultResourceLoader();
		Resource res = resLoader.getResource("F:\\usr\\local\\yoong\\global.xml");
	}

	/**
	 * ApplicationContext
	 */
	public static void applicatioinDemo() {
		try {
			ApplicationContext fileSystemXml = new FileSystemXmlApplicationContext("/src/main/resources/spring-context.xml");
			User user = (User) fileSystemXml.getBean("user");
			System.out.println(user.getIid());
			((FileSystemXmlApplicationContext) fileSystemXml).close();

			ApplicationContext classpathXml = new ClassPathXmlApplicationContext("spring-context.xml");
			User user2 = (User) classpathXml.getBean("user");
			System.out.println(user2.getIid());
			((ClassPathXmlApplicationContext) classpathXml).close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

}
