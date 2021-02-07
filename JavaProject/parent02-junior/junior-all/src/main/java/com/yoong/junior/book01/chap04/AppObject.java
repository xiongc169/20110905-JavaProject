package com.yoong.junior.book01.chap04;

import com.yoong.junior.book01.chap04.bok.Employee;
import com.yoong.junior.book01.chap04.diy.ApiServiceRecord;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static java.lang.Math.pow;

/**
 * @Desc 《《Java核心技术·卷1》第四章、对象与类
 * <p>
 * @Author yoong
 * <p>
 * @Date 2019/2/1 11:50
 * <p>
 * @Version 1.0
 */
public class AppObject {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            predefinedClass0402();
            customizeClass0403();
            staticField0404(); //静态域、静态代码块、实例域、实例代码块的初始化顺序
            methodParam0405(); //按值调用、按引用调用
            construct0406();
            //this.finalize();
            package0407();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 4.2、预定义类
     */
    public static void predefinedClass0402() {
        double pow01 = Math.pow(2, 15);//32768.0
        Date date = new Date();
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        Calendar calendar = Calendar.getInstance();

        System.out.println(pow01);
        System.out.println(calendar);
    }

    /**
     * 4.3、自定义类
     */
    public static void customizeClass0403() {
        Employee[] staff = new Employee[10];
        staff[0] = new Employee("name01", 100d, new Date());
        staff[1] = new Employee("name02", 200d, new Date());
        staff[2] = new Employee("name03", 300d, new Date());
        System.out.println(staff[0].getSalary());
        staff[0].raiseSalary(10);
        System.out.println(staff[0].getSalary());

        Date hireDate = staff[0].getHireDate();
        System.out.println(hireDate);
        hireDate = new Date();
        System.out.println(staff[0].getHireDate());
    }

    /**
     * 4.4、静态域与静态方法
     * PS：静态域(static fieldName)、静态常量(static final fieldName)、静态方法(static)、工厂方法、main()方法
     */
    public static void staticField0404() {
        System.out.println(Employee.getNextId());

        //静态代码块、静态方法、代码块、构造函数、实例方法的执行顺序
        //ApiBaseRecord.output();//父静态代码块 - 静态方法 (需单独执行)
        //System.out.println();

        //ApiServiceRecord.output();//父静态代码块 - 子静态代码块 - 子静态方法 (需单独执行)
        //System.out.println();

        //ApiBaseRecord apiBaseRecord = new ApiBaseRecord();//父静态代码块 - 父代码块 - 父构造函数 (需单独执行)
        //System.out.println();

        ApiServiceRecord apiServiceRecord = new ApiServiceRecord();//父静态代码块 - 子静态代码块 - 父代码块 - 父构造函数 - 子代码块 - 子构造函数 (需单独执行)
        //System.out.println();
    }

    /**
     * 4.5、方法参数
     * PS：按值调用(call by value)：方法接收的是调用者提供的值；
     * 按引用调用(call by reference)：方法接收的是调用者提供的变量地址；
     * 一个方法可以修改传递引用所对应的变量值，不能修改传递值所对应的变量值；
     * 一个方法不能修改一个基本数据类型的参数(即数值型和布尔型)；
     * 一个方法可以改变一个对象参数的状态；
     * 一个方法不能让对象参数引用一个新的对象；
     * ——《Java核心技术·卷1》第四章、类与对象 P123
     */
    public static void methodParam0405() {

    }

    /**
     * 4.6、对象构造
     */
    public static void construct0406() {
        Employee employee = new Employee("name01", 100d, new Date());
        System.out.println(employee.getName());
    }

    /**
     * 4.6.8、对象析构与finalize方法
     */
    @Override
    public void finalize() {
        System.out.println("finalize");
    }

    /**
     * 4.7、包
     */
    public static void package0407() {
        Double pow01 = pow(2, 7);
        System.out.println(pow01);
    }
}