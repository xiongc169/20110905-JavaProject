package org.practice.primary.book01.chap06;

import org.practice.primary.book01.chap04.bok.Employee;
import org.practice.primary.book01.chap06.cp641.TalkingClock;
import org.practice.primary.community.domain.Student;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Date;

/**
 * @Desc 《Java核心技术·卷1》第六章、接口与内部类
 * @Author
 * @Date
 * @Version 1.0
 */
public class AppInterface {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            compare0601();
            clone0602();
            callback0603();
            innerClass0604();
            instanceof_isInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 6.1、接口
     */
    public static void compare0601() {
        Employee[] employeeList = new Employee[]{
                new Employee("name01", 200, new Date()),
                new Employee("name02", 100, new Date()),
                new Employee("name03", 50, new Date()),
                new Employee("name04", 10, new Date())
        };
        Arrays.sort(employeeList);
        System.out.println(employeeList.length);

        boolean instanceofRes = employeeList[0] instanceof Comparable;
        System.out.println(instanceofRes);
        boolean isInstanceRes = Comparable.class.isInstance(employeeList[1]);
        System.out.println(isInstanceRes);

        //接口中不能包含实例域、静态方法(若有则必须实现)，但却可以包含常量。
        //接口中的方法自动设置为public，接口中的域自动设置为public static final。
        MyImplement implement = new MyImplement();
        System.out.println(MyImplement.interfaceId);
        //System.out.println(implement.interfaceId);
        //MyImplement.interfaceId = 10;
    }

    /**
     * 6.2、对象克隆
     */
    public static void clone0602() {
        Employee original = new Employee("name", 200, new Date());
        Employee copy01 = original;
        copy01.setName("name01");
        System.out.println(original.getName());

        Employee copy02 = (Employee) original.clone();
        copy02.setName("name02");
        copy02.setHireDate(new Date());
        System.out.println(original.getName());

        //对于不可变的对象，浅拷贝后，新引用的改变不会影响原始值
        String str01 = "String-01";
        String str02 = str01;
        str02 = "String-02";
        System.out.println(str01);
    }

    /**
     * 6.3、接口与回调
     */
    public static void callback0603() {
        ActionListener listener = new TimePrinter();
        Timer timer = new Timer(5000, listener);
        timer.start();
        JOptionPane.showMessageDialog(null, "Quit Program?");
    }

    /**
     * 6.4、内部类
     */
    public static void innerClass0604() {
        TalkingClock clock = new TalkingClock(5, true);
        clock.start();

        TalkingClock.TimePrinter timePrinter = clock.new TimePrinter();
    }

    /**
     * Java中instanceof和isInstance区别详解
     * PS：obj instanceof className、class.isInstance(obj)
     * https://www.cnblogs.com/greatfish/p/6096038.html
     * instanceof、isInstance、==、equals判断Class是否相等
     * https://blog.csdn.net/qq_36894974/article/details/79090322
     */
    public static void instanceof_isInstance() {
        Student student = new Student();
        Student student2 = new Student();
        if (student instanceof Student) {
            System.out.println("instanceof true");
        }
        if (Student.class.isInstance(student2)) {
            System.out.println("isInstance true");
        }
    }
}
