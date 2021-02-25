package com.yoong.web.mybatis.model;

import java.util.Date;

public class Customer {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.id
     *
     * @mbggenerated Sun Jul 12 11:38:47 CST 2020
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.customer_id
     *
     * @mbggenerated Sun Jul 12 11:38:47 CST 2020
     */
    private String customerId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.customer_name
     *
     * @mbggenerated Sun Jul 12 11:38:47 CST 2020
     */
    private String customerName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.password
     *
     * @mbggenerated Sun Jul 12 11:38:47 CST 2020
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.mobile
     *
     * @mbggenerated Sun Jul 12 11:38:47 CST 2020
     */
    private String mobile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.email
     *
     * @mbggenerated Sun Jul 12 11:38:47 CST 2020
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.create_time
     *
     * @mbggenerated Sun Jul 12 11:38:47 CST 2020
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.modify_time
     *
     * @mbggenerated Sun Jul 12 11:38:47 CST 2020
     */
    private Date modifyTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.note1
     *
     * @mbggenerated Sun Jul 12 11:38:47 CST 2020
     */
    private String note1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.note2
     *
     * @mbggenerated Sun Jul 12 11:38:47 CST 2020
     */
    private String note2;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.is_delete
     *
     * @mbggenerated Sun Jul 12 11:38:47 CST 2020
     */
    private Integer isDelete;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.id
     *
     * @return the value of customer.id
     *
     * @mbggenerated Sun Jul 12 11:38:47 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.id
     *
     * @param id the value for customer.id
     *
     * @mbggenerated Sun Jul 12 11:38:47 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.customer_id
     *
     * @return the value of customer.customer_id
     *
     * @mbggenerated Sun Jul 12 11:38:47 CST 2020
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.customer_id
     *
     * @param customerId the value for customer.customer_id
     *
     * @mbggenerated Sun Jul 12 11:38:47 CST 2020
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.customer_name
     *
     * @return the value of customer.customer_name
     *
     * @mbggenerated Sun Jul 12 11:38:47 CST 2020
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.customer_name
     *
     * @param customerName the value for customer.customer_name
     *
     * @mbggenerated Sun Jul 12 11:38:47 CST 2020
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.password
     *
     * @return the value of customer.password
     *
     * @mbggenerated Sun Jul 12 11:38:47 CST 2020
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.password
     *
     * @param password the value for customer.password
     *
     * @mbggenerated Sun Jul 12 11:38:47 CST 2020
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.mobile
     *
     * @return the value of customer.mobile
     *
     * @mbggenerated Sun Jul 12 11:38:47 CST 2020
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.mobile
     *
     * @param mobile the value for customer.mobile
     *
     * @mbggenerated Sun Jul 12 11:38:47 CST 2020
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.email
     *
     * @return the value of customer.email
     *
     * @mbggenerated Sun Jul 12 11:38:47 CST 2020
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.email
     *
     * @param email the value for customer.email
     *
     * @mbggenerated Sun Jul 12 11:38:47 CST 2020
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.create_time
     *
     * @return the value of customer.create_time
     *
     * @mbggenerated Sun Jul 12 11:38:47 CST 2020
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.create_time
     *
     * @param createTime the value for customer.create_time
     *
     * @mbggenerated Sun Jul 12 11:38:47 CST 2020
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.modify_time
     *
     * @return the value of customer.modify_time
     *
     * @mbggenerated Sun Jul 12 11:38:47 CST 2020
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.modify_time
     *
     * @param modifyTime the value for customer.modify_time
     *
     * @mbggenerated Sun Jul 12 11:38:47 CST 2020
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.note1
     *
     * @return the value of customer.note1
     *
     * @mbggenerated Sun Jul 12 11:38:47 CST 2020
     */
    public String getNote1() {
        return note1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.note1
     *
     * @param note1 the value for customer.note1
     *
     * @mbggenerated Sun Jul 12 11:38:47 CST 2020
     */
    public void setNote1(String note1) {
        this.note1 = note1 == null ? null : note1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.note2
     *
     * @return the value of customer.note2
     *
     * @mbggenerated Sun Jul 12 11:38:47 CST 2020
     */
    public String getNote2() {
        return note2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.note2
     *
     * @param note2 the value for customer.note2
     *
     * @mbggenerated Sun Jul 12 11:38:47 CST 2020
     */
    public void setNote2(String note2) {
        this.note2 = note2 == null ? null : note2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.is_delete
     *
     * @return the value of customer.is_delete
     *
     * @mbggenerated Sun Jul 12 11:38:47 CST 2020
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.is_delete
     *
     * @param isDelete the value for customer.is_delete
     *
     * @mbggenerated Sun Jul 12 11:38:47 CST 2020
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}