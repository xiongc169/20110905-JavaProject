package org.practice.book01.chap04;

import java.util.Date;

/**
 * @Desc Employee
 * @Author
 * @Date
 * @Version 1.0
 */
public class Employee {

    private String name;

    private double salary;

    private Date hireDate;

    public Employee() {
    }

    public Employee(String name, double salary, Date hireDate) {
        this.name = name;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getHireDate() {
        //return hireDate;
        return (Date) hireDate.clone();
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
}
