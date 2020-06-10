package org.practice.primary.community;

import java.util.HashSet;
import java.util.Set;

import org.practice.primary.community.domain.Student;

/**
 * @Desc App.java
 * <p>
 * @Author yoong
 * <p>
 * @Date 2012年4月2日
 * <p>
 * @Version 1.0
 */
public class AppCommunity {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            setDistinctTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 利用Java Set 去除重复object
     * PS：Set集合针对String类型、8大基础数据类型，会过滤掉重复数据；
     * 如果存放的是其他类型对象，则需要重写hashCode方法、equals方法。
     * 当equals比较相等时，则会去比较hashCode值，如果一致的话，则不会存进set。
     * https://blog.csdn.net/miqi770/article/details/8998517
     */
    public static void setDistinctTest() {
        Set<Student> stuSet = new HashSet<>();
        Student stu = new Student("id1", "name1", "sex1", 1);
        Student stu2 = new Student("id1", "name1", "sex2", 2);
        Student stu3 = new Student("id3", "name1", "sex3", 3);
        Student stu4 = new Student("id4", "name1", "sex4", 4);

        System.out.printf("%d ; %d ; %d ; %d \n", stu.hashCode(), stu2.hashCode(), stu3.hashCode(), stu4.hashCode());
        System.out.println("stu.equals(stu2)  " + stu.equals(stu2));
        stuSet.add(stu);
        stuSet.add(stu2);
        stuSet.add(stu3);
        stuSet.add(stu4);

        for (Student item : stuSet) {
            System.out.printf("%s - %s - %s - %d\n", item.getId(), item.getName(), item.getSex(), item.getAge());
        }
    }
}
