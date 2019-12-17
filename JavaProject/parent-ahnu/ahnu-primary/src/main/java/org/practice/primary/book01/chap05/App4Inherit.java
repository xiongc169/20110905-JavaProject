package org.practice.primary.book01.chap05;

/**
 * @Desc App4Inherit
 * @Author
 * @Date
 * @Version 1.0
 */
public class App4Inherit {

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
        Manager manager = new Manager();
        manager.setId(10l);
        manager.setName("001-name");
        manager.setSalary(100l);
        manager.setBonus(50l);
        String greet = manager.greet();
        System.out.println(greet);
        Long allSalary = manager.getSalary();
        System.out.println(allSalary);
    }
}
