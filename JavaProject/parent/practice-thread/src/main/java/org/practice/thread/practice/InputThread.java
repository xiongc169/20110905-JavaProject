package org.practice.thread.practice;

import java.util.Scanner;

import org.practice.model.Person;

/**
 * @author Administrator
 * @desc InputThread.java
 * @date 2016年4月17日 下午8:34:11
 */
public class InputThread extends Thread {
    public Person person = null;

    /**
     *
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入你的姓名：");
        String name = scanner.nextLine();

        System.out.println("请输入你的年龄：");
        int age = scanner.nextInt();

        System.out.println("请输入你的工资：");
        int salary = scanner.nextInt();

        person = new Person();
        person.setName(name);
        person.setAge(age);
        person.setSalary(salary);

        System.out.println("输入完毕！");
        System.out.println("姓名：" + name + "\n" + "年龄：" + age + "\n" + "工资：" + salary);
    }
}
