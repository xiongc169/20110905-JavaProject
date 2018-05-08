package org.dubbo.consumer;

import org.dubbo.common.service.CalculatorService;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class Consumer {
	public static void main(String[] args) {
		try {

			FileSystemXmlApplicationContext fsContext = new FileSystemXmlApplicationContext(
					new String[] { "classpath:consumer.xml" });
			CalculatorService calculator = (CalculatorService) fsContext.getBean("calculatorService");
			double result = calculator.sub(100, 200);
			double result2 = calculator.mul(100, 200);
			double result3 = calculator.div(100, 200);
			double result4 = calculator.add(100, 200);
			System.out.println(result);
			System.out.println(result2);
			System.out.println(result3);
			System.out.println(result4);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
