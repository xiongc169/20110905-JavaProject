package com.yoong.hibernate.spring.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * @Desc Account
 * @Author
 * @Date
 * @Version 1.0
 */
@Entity
public class Account {
    private long id;
    private String accountId;
    private String password;
    private String contactName;
    private String mobile;
    private String phone;
    private String email;
    private String customerId;
    private String customerNo;
    private String customerName;
    private Date createTime;
    private Date modifyTime;
    private String note1;
    private String note2;
    private int isDelete;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "account_id", nullable = false, length = 50)
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 100)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "contact_name", nullable = true, length = 40)
    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    @Basic
    @Column(name = "mobile", nullable = true, length = 20)
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 40)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "customer_id", nullable = true, length = 50)
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "customer_no", nullable = true, length = 50)
    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    @Basic
    @Column(name = "customer_name", nullable = true, length = 100)
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Basic
    @Column(name = "create_time", nullable = false)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "modify_time", nullable = false)
    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Basic
    @Column(name = "note1", nullable = true, length = 200)
    public String getNote1() {
        return note1;
    }

    public void setNote1(String note1) {
        this.note1 = note1;
    }

    @Basic
    @Column(name = "note2", nullable = true, length = 200)
    public String getNote2() {
        return note2;
    }

    public void setNote2(String note2) {
        this.note2 = note2;
    }

    @Basic
    @Column(name = "is_delete", nullable = false)
    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id &&
                isDelete == account.isDelete &&
                Objects.equals(accountId, account.accountId) &&
                Objects.equals(password, account.password) &&
                Objects.equals(contactName, account.contactName) &&
                Objects.equals(mobile, account.mobile) &&
                Objects.equals(phone, account.phone) &&
                Objects.equals(email, account.email) &&
                Objects.equals(customerId, account.customerId) &&
                Objects.equals(customerNo, account.customerNo) &&
                Objects.equals(customerName, account.customerName) &&
                Objects.equals(createTime, account.createTime) &&
                Objects.equals(modifyTime, account.modifyTime) &&
                Objects.equals(note1, account.note1) &&
                Objects.equals(note2, account.note2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountId, password, contactName, mobile, phone, email, customerId, customerNo, customerName, createTime, modifyTime, note1, note2, isDelete);
    }
}
