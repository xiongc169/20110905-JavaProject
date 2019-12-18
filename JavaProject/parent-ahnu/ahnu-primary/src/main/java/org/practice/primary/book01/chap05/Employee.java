package org.practice.primary.book01.chap05;

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
    private String name;
    private Long salary;
    private Date hireDate;

    public Employee() {
    }

    public Employee(String name, Long salary, Date hireDate) {
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
}
