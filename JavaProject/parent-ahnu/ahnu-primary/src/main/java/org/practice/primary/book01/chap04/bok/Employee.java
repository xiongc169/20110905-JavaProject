package org.practice.primary.book01.chap04.bok;

import lombok.Data;

import java.util.Date;

/**
 * @Desc final Employee
 * @Author
 * @Date
 * @Version 1.0
 */
@Data
public class Employee {
    private Long Id;
    private String name = greet();//执行构造器之前，先执行赋值操作
    private Double salary;
    private Date hireDate;
    private static Long nextId;

    public Employee() {
    }


    public Employee(String name, double salary, Date hireDate) {
        this.name = name;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    /**
     * final
     */
    public String greet() {
        String greet = "Employee " + name;
        return greet;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public static Long getNextId() {
        return nextId;
    }

    public void finalize() {
        System.out.println("Employ.finalize");
    }
}
