package org.practice.spring.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Customer
 *
 * @author yoong
 */
@Data
@Component
public class Customer {

    private String customerId;

    private String customerName;

    private String sex;

//    @Autowired
//    @Autowired(required = false)
//    @Qualifier("car_02")
//    @Resource(name = "car_01")
    private Car car;

    public Customer() {
        System.out.println("Customer.Customer()");
    }

    public Customer(String id) {
        this.customerId = id;
    }

    public Customer(String id, String customerName) {
        this.customerId = id;
        this.customerName = customerName;
    }

    public void init() {
        System.out.println("Customer.init()");
    }

    public void destroy() {
        System.out.println("Customer.destroy()");
    }
}