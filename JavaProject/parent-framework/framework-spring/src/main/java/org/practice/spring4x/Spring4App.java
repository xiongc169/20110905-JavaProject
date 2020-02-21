package org.practice.spring4x;

import org.practice.spring.domain.Customer;
import org.practice.spring3x.config.BeanConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Desc Spring4App
 * @Author
 * @Date
 * @Version 1.0
 */
public class Spring4App {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            conditionDemo();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     *
     */
    public static void conditionDemo() {
        try {
            AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
            Customer customer = (Customer) annotationConfigApplicationContext.getBean("customer");
            System.out.println(customer.getCustomerId());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
