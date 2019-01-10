package org.practice.primary.domain;

/**
 * 利用Java Set 去除重复object
 * http://blog.csdn.net/miqi770/article/details/8998517
 *
 * @author Administrator
 */
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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
