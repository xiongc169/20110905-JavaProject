package com.yoong.springfx.book01.part02_ioc.factorybean;

import com.yoong.springfx.domain.Customer;

/**
 * 静态工厂方法
 */
public class MyStaticFactory {

    public static Customer getCustomer() {
        Customer customer = new Customer();
        customer.setCustomerId("MyStaticFactory_NonArgs");
        return customer;
    }

    public static Customer getCustomer(String customerId) {
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        return customer;
    }
}
