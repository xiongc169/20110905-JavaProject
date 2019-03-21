package com.yoong.practice.hibernate.accidence.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

/**
 * @Desc Menu
 * @Author
 * @Date
 * @Version 1.0
 */
@Entity
public class Menu {
    private long id;
    private long menuId;
    private long menuName;
    private String menuUrl;
    private String parentId;
    private Integer order;
    private Date createTime;
    private Date modifyTime;
    private String note1;
    private String note2;
    private int isDelete;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "menu_id", nullable = false)
    public long getMenuId() {
        return menuId;
    }

    public void setMenuId(long menuId) {
        this.menuId = menuId;
    }

    @Basic
    @Column(name = "menu_name", nullable = false)
    public long getMenuName() {
        return menuName;
    }

    public void setMenuName(long menuName) {
        this.menuName = menuName;
    }

    @Basic
    @Column(name = "menu_url", nullable = true, length = 20)
    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    @Basic
    @Column(name = "parent_id", nullable = true, length = 20)
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "order", nullable = true)
    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
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
        Menu menu = (Menu) o;
        return id == menu.id &&
                menuId == menu.menuId &&
                menuName == menu.menuName &&
                isDelete == menu.isDelete &&
                Objects.equals(menuUrl, menu.menuUrl) &&
                Objects.equals(parentId, menu.parentId) &&
                Objects.equals(order, menu.order) &&
                Objects.equals(createTime, menu.createTime) &&
                Objects.equals(modifyTime, menu.modifyTime) &&
                Objects.equals(note1, menu.note1) &&
                Objects.equals(note2, menu.note2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, menuId, menuName, menuUrl, parentId, order, createTime, modifyTime, note1, note2, isDelete);
    }
}
