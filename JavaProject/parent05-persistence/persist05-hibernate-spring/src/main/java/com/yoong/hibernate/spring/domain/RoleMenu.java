package com.yoong.hibernate.spring.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "role_menu", schema = "wong_user", catalog = "")
public class RoleMenu {
    private long id;
    private long roleId;
    private Long menuId;
    private Timestamp createTime;
    private Timestamp modifyTime;
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
    @Column(name = "role_id", nullable = false)
    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "menu_id", nullable = true)
    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    @Basic
    @Column(name = "create_time", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "modify_time", nullable = false)
    public Timestamp getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Timestamp modifyTime) {
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
        RoleMenu roleMenu = (RoleMenu) o;
        return id == roleMenu.id &&
                roleId == roleMenu.roleId &&
                isDelete == roleMenu.isDelete &&
                Objects.equals(menuId, roleMenu.menuId) &&
                Objects.equals(createTime, roleMenu.createTime) &&
                Objects.equals(modifyTime, roleMenu.modifyTime) &&
                Objects.equals(note1, roleMenu.note1) &&
                Objects.equals(note2, roleMenu.note2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleId, menuId, createTime, modifyTime, note1, note2, isDelete);
    }
}
