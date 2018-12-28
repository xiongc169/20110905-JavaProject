package org.practice.spring.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Customer
 *
 * @author yoong
 */
@Component
public class Customer {

    private String customerId;

    private String customerName;

    private String sex;

    @Autowired
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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
