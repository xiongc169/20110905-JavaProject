package org.practice.springfx.book02.config;

import org.practice.springfx.domain.Car;
import org.practice.springfx.domain.Customer;
import org.practice.springfx.domain2.Student;
import org.practice.springfx.book03.condition.FirstCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @Desc JmsConfig
 * @Author
 * @Date
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
