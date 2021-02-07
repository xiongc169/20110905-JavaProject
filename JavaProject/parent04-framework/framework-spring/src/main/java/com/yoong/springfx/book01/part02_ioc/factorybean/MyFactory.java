package com.yoong.springfx.book01.part02_ioc.factorybean;

import com.yoong.springfx.domain.Customer;

/**
 * 非静态工厂方法
 */
public class MyFactory {

    public Customer getCustomer() {
        Customer customer = new Customer();
        customer.setCustomerId("MyFactory_NonArgs");
        return customer;
    }
}
