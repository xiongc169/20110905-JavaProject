package org.anno.consumer;

import org.anno.consumer.controller.UserController;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 
 */
public class Consumer {
	public static void main(String[] args) {
		try {

			FileSystemXmlApplicationContext fs = new FileSystemXmlApplicationContext(new String[] { "classpath:consumer.xml" });
			fs.start();

			UserController userCtr = (UserController) fs.getBean("userCtr");
			double result = userCtr.calculator.add(100, 200);
			double result2 = userCtr.calculator.sub(100, 200);
			double result3 = userCtr.calculator.mul(100, 200);
			double result4 = userCtr.calculator.div(100, 200);
			System.out.println(result + "\n" + result2 + "\n" + result3 + "\n" + result4 + "\n");

			String userName = userCtr.userDao.getUserName();
			System.out.println(userName);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
