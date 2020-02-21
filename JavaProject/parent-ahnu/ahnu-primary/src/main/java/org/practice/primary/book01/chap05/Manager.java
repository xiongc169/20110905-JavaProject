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
    private String managerTitle = getTitle();

    {
        System.out.println("Manager 代码块");
    }

    static {
        System.out.println("Manager 静态代码块");
    }

    public Manager() {
        System.out.println("Manager.Manager()");
    }

    public Manager(String name, double salary, Date hireDate) {
        super(name, salary, hireDate);
        System.out.println("Manager.Manager(3)");
    }

    @Override
    public double getSalary() {
        System.out.println("Manager.getSalary()");
        //return salary + bonus;    //编译不通过，获取不到salary字段；
        //return getSalary() + bonus;   //执行抛异常：java.lang.StackOverflowError；
        //return this.getSalary() + bonus;  //执行抛异常：java.lang.StackOverflowError；
        return super.getSalary() + bonus;   //正解，可以通过super.salary 访问父类非私有域(public|protected)
    }

    public String greet() {
        System.out.println("Manager.greet()");
        return "Manager.greet()";
    }

    public String getTitle() {
        System.out.println("Manager.getTitle()");
        return "Manager.getTitle()";
    }

}