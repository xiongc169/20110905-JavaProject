package com.yoong.springfx.book02.config;

import com.yoong.springfx.book03.condition.FirstCondition;
import com.yoong.springfx.domain.Car;
import com.yoong.springfx.domain.Customer;
import com.yoong.springfx.domain.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @Desc BeanConfig
 * <p>
 * @Author yoong
 * <p>
 * @Date 2019年8月20日
 * <p>
 * @Version 1.0
 */
@Configuration
public class BeanConfig {

    @Bean
    public Student student() {
        return new Student();
    }

    @Bean
    public Car car() {
        Car car = new Car();
        car.setCarId("carId-01");
        return car;
    }

    @Conditional(FirstCondition.class)
    @Bean
    public Customer customer(Car car) {
        Customer customer = new Customer();
        customer.setCustomerId("customerId-01");
        customer.setCar(car);
        return customer;
    }
}
