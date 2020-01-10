package org.practice.primary.book01.chap05;

import lombok.Data;
import org.practice.primary.book01.chap04.bok.Employee;

import java.util.Date;

/**
 * @Desc Manager
 * @Author
 * @Date
 * @Version 1.0
 */
@Data
public class Manager extends Employee {

    private Double bonus;

    public Manager() {
        System.out.println("Manager.Manager()");
    }

    public Manager(String name, double salary, Date hireDate) {
        super(name, salary, hireDate);
        System.out.println("Manager.Manager(3)");
    }

    @Override
    public Double getSalary() {
        System.out.println("Manager.getSalary()");
        //return getSalary() + bonus;//抛异常：java.lang.StackOverflowError
        return super.getSalary() + bonus;
    }

    public String greet() {
        System.out.println("Manager.greet()");
        String greet = "Manager " + this.getName();
        return greet;
    }
}
