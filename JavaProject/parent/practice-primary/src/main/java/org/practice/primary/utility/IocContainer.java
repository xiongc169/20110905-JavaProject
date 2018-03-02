package org.practice.primary.utility;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class IocContainer {

	public static void beanFactoryDemo() {
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource(""));
		factory.getBean("");
	}

	public static void applicatioinDemo() {
		ApplicationContext appContext = new FileSystemXmlApplicationContext();
		ApplicationContext appContext2 = new ClassPathXmlApplicationContext();
	}

	/**
	 * spring中的resource
	 * 
	 * @description TODO
	 * @return void
	 * @author Administrator
	 * @date 2016年5月10日 下午8:30:23
	 *
	 */
	public static void resourceDemo() {
		// Resource res = new ByteArrayResource();

		ResourceLoader resLoader = new DefaultResourceLoader();
		Resource res = resLoader.getResource("F:\\usr\\local\\yoong\\global.xml");
	}
}
