package com.yoong.web.hibernate.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

/**
 * @Desc Resource
 * @Author
 * @Date
 * @Version 1.0
 */
@Entity
public class Resource {
    private long id;
    private long resourceId;
    private long resourceName;
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
    @Column(name = "resource_id", nullable = false)
    public long getResourceId() {
        return resourceId;
    }

    public void setResourceId(long resourceId) {
        this.resourceId = resourceId;
    }

    @Basic
    @Column(name = "resource_name", nullable = false)
    public long getResourceName() {
        return resourceName;
    }

    public void setResourceName(long resourceName) {
        this.resourceName = resourceName;
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
        Resource resource = (Resource) o;
        return id == resource.id &&
                resourceId == resource.resourceId &&
                resourceName == resource.resourceName &&
                isDelete == resource.isDelete &&
                Objects.equals(createTime, resource.createTime) &&
                Objects.equals(modifyTime, resource.modifyTime) &&
                Objects.equals(note1, resource.note1) &&
                Objects.equals(note2, resource.note2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, resourceId, resourceName, createTime, modifyTime, note1, note2, isDelete);
    }
}
