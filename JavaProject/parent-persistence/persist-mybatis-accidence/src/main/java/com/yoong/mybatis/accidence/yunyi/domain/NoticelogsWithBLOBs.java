package com.yoong.mybatis.accidence.yunyi.domain;

public class NoticelogsWithBLOBs extends Noticelogs {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column NoticeLogs.CustomerId
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    private String customerid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column NoticeLogs.CustomerName
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    private String customername;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column NoticeLogs.Receiver
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    private String receiver;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column NoticeLogs.SecretTo
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    private String secretto;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column NoticeLogs.CopyTo
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    private String copyto;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column NoticeLogs.NotifyExceptionMsg
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    private String notifyexceptionmsg;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column NoticeLogs.CustomerId
     *
     * @return the value of NoticeLogs.CustomerId
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    public String getCustomerid() {
        return customerid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column NoticeLogs.CustomerId
     *
     * @param customerid the value for NoticeLogs.CustomerId
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    public void setCustomerid(String customerid) {
        this.customerid = customerid == null ? null : customerid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column NoticeLogs.CustomerName
     *
     * @return the value of NoticeLogs.CustomerName
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    public String getCustomername() {
        return customername;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column NoticeLogs.CustomerName
     *
     * @param customername the value for NoticeLogs.CustomerName
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    public void setCustomername(String customername) {
        this.customername = customername == null ? null : customername.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column NoticeLogs.Receiver
     *
     * @return the value of NoticeLogs.Receiver
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column NoticeLogs.Receiver
     *
     * @param receiver the value for NoticeLogs.Receiver
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column NoticeLogs.SecretTo
     *
     * @return the value of NoticeLogs.SecretTo
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    public String getSecretto() {
        return secretto;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column NoticeLogs.SecretTo
     *
     * @param secretto the value for NoticeLogs.SecretTo
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    public void setSecretto(String secretto) {
        this.secretto = secretto == null ? null : secretto.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column NoticeLogs.CopyTo
     *
     * @return the value of NoticeLogs.CopyTo
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    public String getCopyto() {
        return copyto;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column NoticeLogs.CopyTo
     *
     * @param copyto the value for NoticeLogs.CopyTo
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    public void setCopyto(String copyto) {
        this.copyto = copyto == null ? null : copyto.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column NoticeLogs.NotifyExceptionMsg
     *
     * @return the value of NoticeLogs.NotifyExceptionMsg
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    public String getNotifyexceptionmsg() {
        return notifyexceptionmsg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column NoticeLogs.NotifyExceptionMsg
     *
     * @param notifyexceptionmsg the value for NoticeLogs.NotifyExceptionMsg
     *
     * @mbggenerated Fri Dec 15 13:59:18 CST 2017
     */
    public void setNotifyexceptionmsg(String notifyexceptionmsg) {
        this.notifyexceptionmsg = notifyexceptionmsg == null ? null : notifyexceptionmsg.trim();
    }
}