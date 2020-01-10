package org.practice.primary.book01.chap05;

import org.practice.primary.book01.chap04.bok.Employee;

/**
 * @Desc 《Java核心技术·卷1》第五章、继承
 * @Author
 * @Date
 * @Version 1.0
 */
public class AppInherit {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            inherit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void inherit() {
        Employee employee = new Employee();
        System.out.println();

        Manager manager = new Manager();
        System.out.println();

        manager.setId(10l);
        manager.setName("001-name");
        manager.setSalary(100d);
        manager.setBonus(50d);

        String greet = manager.greet();
        Double allSalary = manager.getSalary();

        Employee manager01 = new Manager();
        //manager01.setBonus(100d);//编译不通过
    }
}
