package org.practice.primary.community.domain;

import lombok.Data;

/**
 * 利用Java Set 去除重复object
 * PS：Set集合针对String类型、8大基础数据类型，会过滤掉重复数据；
 * 如果存放的是其他类型对象，则需要重写hashCode方法、equals方法。
 * 当equals比较相等时，则会去比较hashCode值，如果一致的话，则不会存进set。
 * http://blog.csdn.net/miqi770/article/details/8998517
 */
@Data
public class Student {
    private String id;
    private String name;
    private String sex;
    private int age;

    public Student() {
    }

    public Student(String id, String name, String sex, int age) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Student) {
            Student stu = (Student) obj;
            if (stu.getId() == this.id && stu.getName() == this.name) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.getId().hashCode() * this.getName().hashCode();
    }

}
