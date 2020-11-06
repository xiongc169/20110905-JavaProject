package org.practice.java8.community;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.practice.java8.community.ch02Interface.GreetImpl;
import org.practice.java8.community.ch02Interface.IGreet;
import org.practice.java8.community.ch07Stream.Student;

/**
 * @Desc Java 8的十大新特性
 * http://www.cnblogs.com/pkufork/p/java_8.html
 * 利用Java Set 去除重复object
 * http://blog.csdn.net/miqi770/article/details/8998517
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018-03-02 09:00:00
 * <p>
 * @Version 1.0
 */
public class AppJava8 {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            lambdaTest();
            interfaceTest();
            streamTest();
            array2Stream();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * TODO：lambda表达式
     */
    public static void lambdaTest() {
        List<String> list = Arrays.asList("Buenos Aires", "Córdoba", "La Plata");
        //输出1
        list.forEach((item) -> {
            System.out.println(item);
        });
        //输出2
        list.forEach(AppJava8::print);
    }

    public static void print(String str) {
        System.out.println(str);
    }


    /**
     * TODO：函数式接口
     */
    public static void interfaceTest() {
        IGreet greet = new GreetImpl();
        IGreet greet2 = GreetImpl::new;
        greet.defaultMethod();
        greet.myMethod();
        IGreet.staticMethod();
    }

    /**
     * TODO：Stream
     */
    public static void streamTest() {
        List<Student> stuList = new ArrayList<Student>();
        Student stu = new Student("id1", "name1", "sex1", 1);
        Student stu2 = new Student("id2", "name1", "sex2", 2);
        Student stu3 = new Student("id3", "name1", "sex3", 3);
        Student stu4 = new Student("id4", "name1", "sex4", 4);
        stuList.add(stu);
        stuList.add(stu2);
        stuList.add(stu3);
        stuList.add(stu4);

        Predicate<Student> pred = item -> item.getAge() >= 3;
        stuList.forEach(item -> {
            if (pred.test(item)) {
                System.out.println(item.getId());
            }
        });

        stuList.forEach(item -> System.out.println(item.getId()));
        stuList.stream().filter(pred).forEach(item -> System.out.println(item.getId()));
        stuList.parallelStream().forEach(item -> System.out.println(item.getId()));

        int sum = stuList.stream().mapToInt(item -> item.getAge()).sum();
        System.out.println(sum);
    }

    /**
     * TODO：Array-Stream
     */
    public static void array2Stream() {
        Student[] stuArrays = new Student[]{
                new Student("id1", "name1", "sex1", 1),
                new Student("id2", "name2", "sex2", 2),
                new Student("id3", "name3", "sex3", 3)
        };

        // 从数组创建流
        Stream stuStream1 = Stream.of(stuArrays);
        Stream stuStream2 = Arrays.stream(stuArrays);
        stuStream1.forEach(item -> System.out.println(((Student) item).getName()));
    }
}
