package org.practice.thread.thread01.practice;

import java.util.Scanner;
import java.util.concurrent.Callable;

import org.practice.thread.thread01.model.Person;

public class InputCallable implements Callable<Object> {

    public Person person = null;

    public Object call() throws Exception {
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
        return person;
    }

}
