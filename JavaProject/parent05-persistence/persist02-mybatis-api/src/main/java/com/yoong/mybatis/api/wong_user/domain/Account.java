package com.yoong.mybatis.api.wong_user.domain;

import java.io.Serializable;
import java.util.Date;

public class Account implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.id
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.account_id
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    private String accountId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.password
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.contact_name
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    private String contactName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.mobile
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    private String mobile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.phone
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.email
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.customer_id
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    private String customerId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.customer_no
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    private String customerNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.customer_name
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    private String customerName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.create_time
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.modify_time
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    private Date modifyTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.note1
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    private String note1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.note2
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    private String note2;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.is_delete
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    private Integer isDelete;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.id
     *
     * @return the value of account.id
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.id
     *
     * @param id the value for account.id
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.account_id
     *
     * @return the value of account.account_id
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.account_id
     *
     * @param accountId the value for account.account_id
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.password
     *
     * @return the value of account.password
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.password
     *
     * @param password the value for account.password
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.contact_name
     *
     * @return the value of account.contact_name
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.contact_name
     *
     * @param contactName the value for account.contact_name
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.mobile
     *
     * @return the value of account.mobile
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.mobile
     *
     * @param mobile the value for account.mobile
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.phone
     *
     * @return the value of account.phone
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.phone
     *
     * @param phone the value for account.phone
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.email
     *
     * @return the value of account.email
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.email
     *
     * @param email the value for account.email
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.customer_id
     *
     * @return the value of account.customer_id
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.customer_id
     *
     * @param customerId the value for account.customer_id
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.customer_no
     *
     * @return the value of account.customer_no
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    public String getCustomerNo() {
        return customerNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.customer_no
     *
     * @param customerNo the value for account.customer_no
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo == null ? null : customerNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.customer_name
     *
     * @return the value of account.customer_name
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.customer_name
     *
     * @param customerName the value for account.customer_name
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.create_time
     *
     * @return the value of account.create_time
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.create_time
     *
     * @param createTime the value for account.create_time
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.modify_time
     *
     * @return the value of account.modify_time
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.modify_time
     *
     * @param modifyTime the value for account.modify_time
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.note1
     *
     * @return the value of account.note1
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    public String getNote1() {
        return note1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.note1
     *
     * @param note1 the value for account.note1
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    public void setNote1(String note1) {
        this.note1 = note1 == null ? null : note1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.note2
     *
     * @return the value of account.note2
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    public String getNote2() {
        return note2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.note2
     *
     * @param note2 the value for account.note2
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    public void setNote2(String note2) {
        this.note2 = note2 == null ? null : note2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.is_delete
     *
     * @return the value of account.is_delete
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.is_delete
     *
     * @param isDelete the value for account.is_delete
     *
     * @mbggenerated Wed Jan 16 16:41:00 CST 2019
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}