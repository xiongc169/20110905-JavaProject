package com.yoong.springfx.book01.part02_ioc.factorybean;

import com.yoong.springfx.domain.Customer;
import org.springframework.beans.factory.FactoryBean;

/**
 * FactoryBean
 */
public class MyFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        Customer customer = new Customer();
        customer.setCustomerId("myFactoryBean_Id_001");
        customer.setCustomerName("myFactoryBean_Name_001");
        return customer;
    }

    @Override
    public Class<?> getObjectType() {
        return Customer.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
