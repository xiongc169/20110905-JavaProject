package com.yoong.practice.mybatis.accidence.yunyi.domain;

import java.util.Date;

public class Admins {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Admins.Id
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Admins.AdminName
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    private String adminname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Admins.Mobile
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    private String mobile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Admins.Email
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Admins.Password
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Admins.Salt
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    private String salt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Admins.AuthoryId
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    private Integer authoryid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Admins.CreateTime
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    private Date createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Admins.IsSuperAdmin
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    private Byte issuperadmin;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Admins.LastLoginTime
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    private Date lastlogintime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Admins.LastLoginAddress
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    private String lastloginaddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Admins.LastLoginInfo
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    private String lastlogininfo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Admins.LastLoginIp
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    private String lastloginip;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Admins.IsLogin
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    private Byte islogin;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Admins.Id
     *
     * @return the value of Admins.Id
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Admins.Id
     *
     * @param id the value for Admins.Id
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Admins.AdminName
     *
     * @return the value of Admins.AdminName
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    public String getAdminname() {
        return adminname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Admins.AdminName
     *
     * @param adminname the value for Admins.AdminName
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    public void setAdminname(String adminname) {
        this.adminname = adminname == null ? null : adminname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Admins.Mobile
     *
     * @return the value of Admins.Mobile
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Admins.Mobile
     *
     * @param mobile the value for Admins.Mobile
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Admins.Email
     *
     * @return the value of Admins.Email
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Admins.Email
     *
     * @param email the value for Admins.Email
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Admins.Password
     *
     * @return the value of Admins.Password
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Admins.Password
     *
     * @param password the value for Admins.Password
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Admins.Salt
     *
     * @return the value of Admins.Salt
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    public String getSalt() {
        return salt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Admins.Salt
     *
     * @param salt the value for Admins.Salt
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Admins.AuthoryId
     *
     * @return the value of Admins.AuthoryId
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    public Integer getAuthoryid() {
        return authoryid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Admins.AuthoryId
     *
     * @param authoryid the value for Admins.AuthoryId
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    public void setAuthoryid(Integer authoryid) {
        this.authoryid = authoryid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Admins.CreateTime
     *
     * @return the value of Admins.CreateTime
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Admins.CreateTime
     *
     * @param createtime the value for Admins.CreateTime
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Admins.IsSuperAdmin
     *
     * @return the value of Admins.IsSuperAdmin
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    public Byte getIssuperadmin() {
        return issuperadmin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Admins.IsSuperAdmin
     *
     * @param issuperadmin the value for Admins.IsSuperAdmin
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    public void setIssuperadmin(Byte issuperadmin) {
        this.issuperadmin = issuperadmin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Admins.LastLoginTime
     *
     * @return the value of Admins.LastLoginTime
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    public Date getLastlogintime() {
        return lastlogintime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Admins.LastLoginTime
     *
     * @param lastlogintime the value for Admins.LastLoginTime
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Admins.LastLoginAddress
     *
     * @return the value of Admins.LastLoginAddress
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    public String getLastloginaddress() {
        return lastloginaddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Admins.LastLoginAddress
     *
     * @param lastloginaddress the value for Admins.LastLoginAddress
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    public void setLastloginaddress(String lastloginaddress) {
        this.lastloginaddress = lastloginaddress == null ? null : lastloginaddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Admins.LastLoginInfo
     *
     * @return the value of Admins.LastLoginInfo
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    public String getLastlogininfo() {
        return lastlogininfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Admins.LastLoginInfo
     *
     * @param lastlogininfo the value for Admins.LastLoginInfo
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    public void setLastlogininfo(String lastlogininfo) {
        this.lastlogininfo = lastlogininfo == null ? null : lastlogininfo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Admins.LastLoginIp
     *
     * @return the value of Admins.LastLoginIp
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    public String getLastloginip() {
        return lastloginip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Admins.LastLoginIp
     *
     * @param lastloginip the value for Admins.LastLoginIp
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    public void setLastloginip(String lastloginip) {
        this.lastloginip = lastloginip == null ? null : lastloginip.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Admins.IsLogin
     *
     * @return the value of Admins.IsLogin
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    public Byte getIslogin() {
        return islogin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Admins.IsLogin
     *
     * @param islogin the value for Admins.IsLogin
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    public void setIslogin(Byte islogin) {
        this.islogin = islogin;
    }
}