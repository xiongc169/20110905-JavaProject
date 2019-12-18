package org.practice.primary.book01.chap03;

import org.practice.primary.book01.chap05.Employee;

/**
 * 流言终结者：Java是引用传递还是值传递？
 * PS：基本类型：变量存储的是值；
 * 引用类型：变量存储的是实例对象的地址；
 * 说明Java是值传递。不是参数是引用类型，它就是引用传递。
 * https://baijiahao.baidu.com/s?id=1614769568984126810
 * Java 到底是值传递还是引用传递？
 * https://www.zhihu.com/question/31203609
 * Java中引用传值问题
 * https://www.cnblogs.com/9513-/p/8484071.html
 * https://blog.csdn.net/zy_jibai/article/details/80794008
 * 传值引用和调用引用的区别
 * PS：C语言；传值引用一般就是生成一个临时对象，而引用调用是调用参数本身。
 * https://www.cnblogs.com/lovemargin/p/10562386.html
 */
public class AppReference {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            int num = 100;
            System.out.println(num);//100
            referenceInt(num);
            System.out.println(num);//100

            String str = "abc";
            System.out.println(str);//abc
            referenceString(str);
            System.out.println(str);//abc

            Employee employee = new Employee();
            employee.setName("name");
            System.out.println(employee.getName());//name
            referenceObject(employee);
            System.out.println(employee.getName());//referenceObject
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void referenceInt(int x) {
        x = x * 2;
    }

    private static void referenceString(String str) {
        str = "referenceString";
    }

    private static void referenceObject(Employee employee) {
        employee.setName("referenceObject");
    }
}
