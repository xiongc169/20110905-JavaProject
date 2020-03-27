package org.practice.spring4x;

import org.practice.spring.domain.Car;
import org.practice.spring.domain.Customer;
import org.practice.spring3x.config.BeanConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

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
            groovyConfig();
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

    /**
     *
     */
    public static void groovyConfig() {
        try {
            GenericGroovyApplicationContext context = new GenericGroovyApplicationContext("classpath:spring4/car-config.groovy");
            Car car = (Car) context.getBean("car");
            System.out.println(car.getCarId());
            Customer customer = (Customer) context.getBean("customer");
            System.out.println(customer.getCustomerId());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
