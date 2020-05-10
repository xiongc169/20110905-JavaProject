package org.practice.springfx.book04;

import org.practice.springfx.domain.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.net.URL;

/**
 * @Desc SpringCodeApp
 * <p/>
 * @Author Yoong
 * <p/>
 * @Date 2020年4月29日20:26:30
 * <p/>
 * @Version 1.0
 */
public class SpringCodeApp {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:/springcode/spring-code.xml");
            Car car = (Car) applicationContext.getBean("car_01");
            System.out.println(car.getCarId());

            URL url = new URL("");
            Resource resource = new ClassPathResource("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
