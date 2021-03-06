package org.dubbo.provider.starter.core.model;

import java.util.Date;

public class Role {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.id
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.role_id
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    private Long roleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.role_name
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    private String roleName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.create_time
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.modify_time
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    private Date modifyTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.note1
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    private String note1;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.note2
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    private String note2;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.is_delete
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    private Integer isDelete;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.id
     *
     * @return the value of role.id
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.id
     *
     * @param id the value for role.id
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.role_id
     *
     * @return the value of role.role_id
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.role_id
     *
     * @param roleId the value for role.role_id
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.role_name
     *
     * @return the value of role.role_name
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.role_name
     *
     * @param roleName the value for role.role_name
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.create_time
     *
     * @return the value of role.create_time
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.create_time
     *
     * @param createTime the value for role.create_time
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.modify_time
     *
     * @return the value of role.modify_time
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.modify_time
     *
     * @param modifyTime the value for role.modify_time
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.note1
     *
     * @return the value of role.note1
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    public String getNote1() {
        return note1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.note1
     *
     * @param note1 the value for role.note1
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    public void setNote1(String note1) {
        this.note1 = note1 == null ? null : note1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.note2
     *
     * @return the value of role.note2
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    public String getNote2() {
        return note2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.note2
     *
     * @param note2 the value for role.note2
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    public void setNote2(String note2) {
        this.note2 = note2 == null ? null : note2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.is_delete
     *
     * @return the value of role.is_delete
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.is_delete
     *
     * @param isDelete the value for role.is_delete
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}