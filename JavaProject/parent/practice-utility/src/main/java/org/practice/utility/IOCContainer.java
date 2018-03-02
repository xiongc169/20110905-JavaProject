package org.practice.utility;

import org.practice.model.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class IOCContainer {

	/**
	 * IOC容器测试类
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		ClassPathXmlApplicationContext cpXmlContext = null;
		FileSystemXmlApplicationContext fsXmlContext = null;

		try {
			cpXmlContext = new ClassPathXmlApplicationContext("applicationContext.xml");
			User user = (User) cpXmlContext.getBean("user");
			System.out.println(user.getName() + user.getAge());

			fsXmlContext = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
			User user2 = (User) fsXmlContext.getBean("user");
			System.out.println(user2.getName() + user2.getAge());

		} catch (Exception ex) {
			String msg = ex.getMessage();
			System.out.println(msg);
		} finally {
			if (cpXmlContext != null) {
				cpXmlContext.close();
			}
			if (fsXmlContext != null) {
				fsXmlContext.close();
			}
		}

	}
}
