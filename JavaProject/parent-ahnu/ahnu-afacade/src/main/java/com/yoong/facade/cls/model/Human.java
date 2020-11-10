package com.yoong.facade.cls.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @Desc Human
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015-07-25 09:00:00
 * <p>
 * @Version 1.0
 */
@Data
public class Human implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private int age;

    private Date createDate;

    public Human() {
        super();
    }

    public Human(final String name, final int age) {
        super();

        this.name = name;
        this.age = age;
    }

    public Human(final String name, final int age, final Date createDate) {
        super();

        this.name = name;
        this.age = age;
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Human) {
            Human stu = (Human) obj;
            if (stu.getName() == this.name && stu.getAge() == this.age) {
                return true;
            }
        }
        return false;

        // return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode() + this.getAge();
        // return HashCodeBuilder.reflectionHashCode(this);
    }
}
