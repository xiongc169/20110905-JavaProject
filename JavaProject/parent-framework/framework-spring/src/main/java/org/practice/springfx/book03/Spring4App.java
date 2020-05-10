package org.practice.springfx.book03;

import org.practice.springfx.domain.Car;
import org.practice.springfx.domain.Customer;
import org.practice.springfx.book02.config.BeanConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

/**
 * @Desc Spring4App
 * <p>
 * @Author yoong
 * <p>
 * @Date 2019年8月20日
 * <p>
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
