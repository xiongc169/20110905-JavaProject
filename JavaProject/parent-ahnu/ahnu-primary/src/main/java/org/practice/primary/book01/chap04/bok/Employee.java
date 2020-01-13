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
public class Employee implements Comparable<Employee>, Cloneable {

    {
        System.out.println("Employee 代码块1");
    }

    private Long Id;
    private String name;
    private double salary;
    private Date hireDate;
    private static Long nextId;

    //执行构造函数之前，先执行赋值操作；
    //new Employee()，则调用Employee.greet(); new Manager()，则调用Manager.greet(); new SeniorManager()，则调用SeniorManager.greet();
    //若SeniorManager未重写greet()方法，则执行直接父类的greet()方法；
    private String greetMsg = greet();

    {
        System.out.println("Employee 代码块2");
    }

    static {
        System.out.println("Employee 静态代码块");
    }

    public Employee() {
        System.out.println("Employee.Employee()");
    }

    public Employee(String name, double salary, Date hireDate) {
        this.name = name;
        this.salary = salary;
        this.hireDate = hireDate;
        System.out.println("Employee.Employee(3)");
    }

    /**
     * final
     */
    public String greet() {
        System.out.println("Employee.greet()");
        return "Employee.greet()";
    }

    public void raiseSalary(double byPercent) {
        System.out.println("Employee.raiseSalary()");
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public static Long getNextId() {
        System.out.println("Employee.getNextId()");
        return nextId;
    }

    public void finalize() {
        System.out.println("Employee.finalize()");
    }

    /**
     * 必须将方法声明为public
     */
    @Override
    public int compareTo(Employee obj) {
        return Double.compare(this.salary, obj.getSalary());
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
