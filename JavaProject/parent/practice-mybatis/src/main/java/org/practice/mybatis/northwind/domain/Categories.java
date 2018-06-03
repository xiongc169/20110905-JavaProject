package org.practice.mybatis.northwind.domain;

public class Categories {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Categories.CategoryID
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    private Integer categoryid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Categories.CategoryName
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    private String categoryname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Categories.Description
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Categories.Picture
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    private byte[] picture;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Categories.CategoryID
     *
     * @return the value of Categories.CategoryID
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    public Integer getCategoryid() {
        return categoryid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Categories.CategoryID
     *
     * @param categoryid the value for Categories.CategoryID
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Categories.CategoryName
     *
     * @return the value of Categories.CategoryName
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    public String getCategoryname() {
        return categoryname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Categories.CategoryName
     *
     * @param categoryname the value for Categories.CategoryName
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname == null ? null : categoryname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Categories.Description
     *
     * @return the value of Categories.Description
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Categories.Description
     *
     * @param description the value for Categories.Description
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Categories.Picture
     *
     * @return the value of Categories.Picture
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    public byte[] getPicture() {
        return picture;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Categories.Picture
     *
     * @param picture the value for Categories.Picture
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}