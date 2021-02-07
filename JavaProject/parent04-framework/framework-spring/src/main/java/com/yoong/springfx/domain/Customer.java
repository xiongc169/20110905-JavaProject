package com.yoong.springfx.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Desc Customer
 * <p>
 * @Author yoong
 * <p>
 * @Date 2014年3月30日
 * <p>
 * @Version 1.0
 */
@Data
@Component
public class Customer {

    private String customerId;

    private String customerName;

    private String sex;

    //@Autowired
    //@Autowired(required = false)
    //@Qualifier(value = "car_01")
    @Resource(name = "car_02")
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
