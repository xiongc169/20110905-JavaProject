package org.practice.thread.thread01.model;

public class Person {

    private String name;

    private int age;

    private int salary;

    static {
        System.out.println("");
    }

    /**
     * 无参构造函数
     */
    public Person() {
    }

    /**
     * 构造函数
     */
    public Person(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}
