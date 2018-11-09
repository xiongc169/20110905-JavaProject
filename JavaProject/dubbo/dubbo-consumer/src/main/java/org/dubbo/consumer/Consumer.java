package org.dubbo.consumer;

import org.dubbo.common.service.CalculatorService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Hello world!
 */
public class Consumer {
    public static void main(String[] args) {
        try {

            FileSystemXmlApplicationContext fsContext = new FileSystemXmlApplicationContext(new String[]{"classpath:consumer.xml"});
            CalculatorService calculator = (CalculatorService) fsContext.getBean("advancedCalculatorService");//calculatorService、advancedCalculatorService
            double result = calculator.add(100, 200);
            double result1 = calculator.sub(100, 200);
            double result2 = calculator.mul(100, 200);
            double result3 = calculator.div(100, 200);
            System.out.println(result);
            System.out.println(result1);
            System.out.println(result2);
            System.out.println(result3);

            ClassPathXmlApplicationContext cpContext = new ClassPathXmlApplicationContext("classpath:consumer.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
