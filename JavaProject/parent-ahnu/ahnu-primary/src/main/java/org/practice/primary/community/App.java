package org.practice.primary.community;

import java.util.HashSet;
import java.util.Set;

import org.practice.primary.community.init_order.DeriveClass;
import org.practice.primary.community.domain.Student;

/**
 * @author yoong
 * @version 1.0
 * @description App.java
 * @date 2012年4月2日
 */
public class App {

    /**
     * 入口函数
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            initOrderTest();
            setDistinctTest();
            instance();
            left();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 静态变量、静态代码块、变量、代码块、构造函数的执行顺序
     */
    private static void initOrderTest() {
        DeriveClass deriveClass = new DeriveClass();
        DeriveClass.staticSay();
        deriveClass.say();
    }

    /**
     * @desc https://blog.csdn.net/miqi770/article/details/8998517 <br>
     * 利用Java Set 去除重复object，重写equals\hashcode方法
     * @date 2014年4月2日
     * @version 1.0
     */
    public static void setDistinctTest() {
        Set<Student> stuSet = new HashSet<Student>();
        Student stu = new Student("id1", "name1", "sex1", 1);
        Student stu2 = new Student("id1", "name1", "sex2", 2);
        Student stu3 = new Student("id3", "name1", "sex3", 3);
        Student stu4 = new Student("id4", "name1", "sex4", 4);

        System.out.printf("%d ; %d ; %d ; %d \n", stu.hashCode(), stu2.hashCode(), stu3.hashCode(), stu4.hashCode());

        stuSet.add(stu);
        stuSet.add(stu2);
        stuSet.add(stu3);
        stuSet.add(stu4);

        for (Student item : stuSet) {
            System.out.printf("%s - %s - %s - %d\n", item.getId(), item.getName(), item.getSex(), item.getAge());
        }
    }

    /**
     * Java中instanceof和isInstance区别详解
     * PS：obj instanceof className、class.isInstance(obj)
     * https://www.cnblogs.com/greatfish/p/6096038.html
     * instanceof、isInstance、==、equals判断Class是否相等
     * https://blog.csdn.net/qq_36894974/article/details/79090322
     */
    public static void instance() {
        Student student = new Student();
        Student student2 = new Student();
        if (student instanceof Student) {
            System.out.println("instanceof true");
        }
        if (Student.class.isInstance(student2)) {
            System.out.println("isInstance true");
        }
    }

    /**
     * https://blog.csdn.net/sx729034738/article/details/69569055 <br>
     * PS：java中的运算 ^, << , >>,&
     */
    public static void left() {
        // 左移n位就相当于乘以2的n次方
        int a = 3 << 10;
        int b = 48 >> 2;
        System.out.println(a);
        System.out.println(b);
    }
}
