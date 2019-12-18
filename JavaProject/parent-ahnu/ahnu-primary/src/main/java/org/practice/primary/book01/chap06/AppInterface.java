package org.practice.primary.book01.chap06;

import org.practice.primary.community.domain.Student;

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
            instance();
        } catch (Exception ex) {
            ex.printStackTrace();
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
}
