package org.practice.mybatis.northwind.domain;

public class CustomercustomerdemoKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CustomerCustomerDemo.CustomerID
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    private String customerid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CustomerCustomerDemo.CustomerTypeID
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    private String customertypeid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CustomerCustomerDemo.CustomerID
     *
     * @return the value of CustomerCustomerDemo.CustomerID
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    public String getCustomerid() {
        return customerid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CustomerCustomerDemo.CustomerID
     *
     * @param customerid the value for CustomerCustomerDemo.CustomerID
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    public void setCustomerid(String customerid) {
        this.customerid = customerid == null ? null : customerid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CustomerCustomerDemo.CustomerTypeID
     *
     * @return the value of CustomerCustomerDemo.CustomerTypeID
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    public String getCustomertypeid() {
        return customertypeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CustomerCustomerDemo.CustomerTypeID
     *
     * @param customertypeid the value for CustomerCustomerDemo.CustomerTypeID
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    public void setCustomertypeid(String customertypeid) {
        this.customertypeid = customertypeid == null ? null : customertypeid.trim();
    }
}