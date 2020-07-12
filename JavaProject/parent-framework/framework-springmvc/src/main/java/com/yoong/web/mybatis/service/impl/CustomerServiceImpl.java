package com.yoong.web.mybatis.service.impl;

import com.yoong.web.mybatis.mapper.CustomerMapper;
import com.yoong.web.mybatis.model.Customer;
import com.yoong.web.mybatis.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Desc CustomerServiceImpl.java
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年8月20日
 * <p>
 * @Version 1.0
 */
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    public CustomerMapper customerMapper;

    @Override
    public Customer insertCustomer(Customer customer) {
        int effectRows = customerMapper.insert(customer);
        System.out.println("effectRows: " + effectRows + ", Id: " + customer.getId());
        //double aa = 10 / 0;
        customer.setId(null);
        int effectRows2 = customerMapper.insert(customer);
        System.out.println("effectRows2: " + effectRows2 + ", Id: " + customer.getId());
        return customer;
    }
}
