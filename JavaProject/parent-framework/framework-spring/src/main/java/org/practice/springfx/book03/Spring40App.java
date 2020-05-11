package org.practice.springfx.book03;

import org.practice.springfx.domain.Car;
import org.practice.springfx.domain.Customer;
import org.practice.springfx.book02.config.BeanConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

/**
 * @Desc 《精通Spring 4.x企业应用开发实战》陈雄华 林开雄 文建国 著
 * https://www.jb51.net/books/573360.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2017-6-12
 * <p>
 * @Version 1.0
 */
public class Spring40App {

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
            GenericGroovyApplicationContext context = new GenericGroovyApplicationContext("classpath:book03/car-config.groovy");
            Car car = (Car) context.getBean("car");
            System.out.println(car.getCarId());
            Customer customer = (Customer) context.getBean("customer");
            System.out.println(customer.getCustomerId());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
