package com.yoong.mybatis.api.wong_user.dao;

import java.util.List;

import com.yoong.mybatis.api.wong_user.domain.Account;
import org.apache.ibatis.annotations.Param;
import com.yoong.mybatis.api.wong_user.domain.Customer;
import com.yoong.mybatis.api.wong_user.domain.CustomerExample;

public interface CustomerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    int countByExample(CustomerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    int deleteByExample(CustomerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    int insert(Customer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    int insertSelective(Customer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    List<Customer> selectByExample(CustomerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);

    Customer selectById(Long Id);

    Account selectAccountById(Long Id);
}