package org.dubbo.provider.starter.core.model;

import java.util.Date;

public class RoleMenu {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_menu.id
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_menu.role_id
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    private Long roleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_menu.menu_id
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    private Long menuId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_menu.create_time
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_menu.modify_time
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    private Date modifyTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_menu.note1
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    private String note1;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_menu.note2
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    private String note2;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_menu.is_delete
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    private Integer isDelete;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_menu.id
     *
     * @return the value of role_menu.id
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_menu.id
     *
     * @param id the value for role_menu.id
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_menu.role_id
     *
     * @return the value of role_menu.role_id
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_menu.role_id
     *
     * @param roleId the value for role_menu.role_id
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_menu.menu_id
     *
     * @return the value of role_menu.menu_id
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    public Long getMenuId() {
        return menuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_menu.menu_id
     *
     * @param menuId the value for role_menu.menu_id
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_menu.create_time
     *
     * @return the value of role_menu.create_time
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_menu.create_time
     *
     * @param createTime the value for role_menu.create_time
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_menu.modify_time
     *
     * @return the value of role_menu.modify_time
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_menu.modify_time
     *
     * @param modifyTime the value for role_menu.modify_time
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_menu.note1
     *
     * @return the value of role_menu.note1
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    public String getNote1() {
        return note1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_menu.note1
     *
     * @param note1 the value for role_menu.note1
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    public void setNote1(String note1) {
        this.note1 = note1 == null ? null : note1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_menu.note2
     *
     * @return the value of role_menu.note2
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    public String getNote2() {
        return note2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_menu.note2
     *
     * @param note2 the value for role_menu.note2
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    public void setNote2(String note2) {
        this.note2 = note2 == null ? null : note2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_menu.is_delete
     *
     * @return the value of role_menu.is_delete
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_menu.is_delete
     *
     * @param isDelete the value for role_menu.is_delete
     *
     * @mbg.generated Sat Jul 10 22:09:55 CST 2021
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}