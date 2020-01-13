package org.practice.primary.book01.chap06;

import org.practice.primary.book01.chap04.bok.Employee;
import org.practice.primary.community.domain.Student;

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

            instanceof_isInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

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
    }

    public static void clone0602() {
        Employee original = new Employee("name", 200, new Date());
        Employee copy01 = original;
        copy01.setName("name01");
        System.out.println(original.getName());

        Employee copy02 = (Employee) original.clone();
        copy02.setName("name02");
        System.out.println(original.getName());
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
