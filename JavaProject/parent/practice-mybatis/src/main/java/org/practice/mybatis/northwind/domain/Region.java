package org.practice.mybatis.northwind.domain;

public class Region {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Region.RegionID
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    private Integer regionid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Region.RegionDescription
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    private String regiondescription;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Region.RegionID
     *
     * @return the value of Region.RegionID
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    public Integer getRegionid() {
        return regionid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Region.RegionID
     *
     * @param regionid the value for Region.RegionID
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    public void setRegionid(Integer regionid) {
        this.regionid = regionid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Region.RegionDescription
     *
     * @return the value of Region.RegionDescription
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    public String getRegiondescription() {
        return regiondescription;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Region.RegionDescription
     *
     * @param regiondescription the value for Region.RegionDescription
     *
     * @mbggenerated Sun Jun 03 14:25:41 CST 2018
     */
    public void setRegiondescription(String regiondescription) {
        this.regiondescription = regiondescription == null ? null : regiondescription.trim();
    }
}