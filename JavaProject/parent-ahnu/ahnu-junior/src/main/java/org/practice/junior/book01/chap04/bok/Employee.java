package org.practice.junior.book01.chap04.bok;

import java.util.Date;

public class Employee implements Comparable<Employee>, Cloneable {

    {
        System.out.println("Employee 代码块1");
    }

    private Long Id;
    private String name;
    private double salary;
    private Date hireDate;
    private static Long nextId;

    /**
     * 执行构造函数之前，先执行赋值操作；
     * 若 new Employee()，则调用Employee.greet();
     * 若 new Manager()，则调用Manager.greet();
     * 若 new Executive()，则调用Executive.greet();
     * 若 Executive未重写greet()方法，则执行直接父类的greet()方法；
     */
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

    {
        System.out.println("Employee 代码块3");
    }

    static {
        System.out.println("Employee 静态代码块2");
    }

    //region Getter and Setter
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public static void setNextId(Long nextId) {
        Employee.nextId = nextId;
    }

    public String getGreetMsg() {
        return greetMsg;
    }

    public void setGreetMsg(String greetMsg) {
        this.greetMsg = greetMsg;
    }
    //endregion

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

    /**
     * 覆盖(重写) Object.clone()
     */
    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 覆盖(重写) Object.finalize()
     */
    @Override
    public void finalize() {
        System.out.println("Employee.finalize()");
    }

    /**
     * 覆盖(重写) Comparable.compareTo(), 必须将方法声明为public
     */
    @Override
    public int compareTo(Employee obj) {
        return Double.compare(this.salary, obj.getSalary());
    }
}
