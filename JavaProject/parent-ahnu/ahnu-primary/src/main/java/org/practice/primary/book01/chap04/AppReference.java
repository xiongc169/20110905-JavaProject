package org.practice.primary.book01.chap04;

import org.practice.primary.book01.chap04.bok.Employee;

/**
 * @Desc 《Java核心技术·卷1》第四章、类与对象 P123
 * 一个方法不能修改一个基本数据类型的参数(即数值型和布尔型)；
 * 一个方法可以改变一个对象参数的状态；
 * 一个方法不能让对象参数引用一个新的对象；
 * <p>
 * 流言终结者：Java是引用传递还是值传递？
 * PS：基本类型：变量存储的是值；引用类型：变量存储的是实例对象的地址；
 * 说明Java是值传递。不是参数是引用类型，它就是引用传递。
 * https://baijiahao.baidu.com/s?id=1614769568984126810
 * Java 到底是值传递还是引用传递？
 * PS：形参、实参：当我们调用一个有参函数的时候，会把实际参数传递给形式参数。
 * 值传递(pass by value)，是指在调用函数时将实际参数复制一份传递到函数中，这样在函数中如果对参数进行修改，将不会影响到实际参数。
 * 引用传递(pass by reference)，是指在调用函数时将实际参数的地址直接传递到函数中，那么在函数中对参数所进行的修改，将影响到实际参数。
 * https://www.zhihu.com/question/31203609
 * Java中引用传值问题
 * https://www.cnblogs.com/9513-/p/8484071.html
 * https://blog.csdn.net/zy_jibai/article/details/80794008
 * 传值引用和调用引用的区别
 * PS：C语言；传值引用一般就是生成一个临时对象，而引用调用是调用参数本身。
 * https://www.cnblogs.com/lovemargin/p/10562386.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2019/2/1 11:50
 * <p>
 * @Version 1.0
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

            StringBuilder sb = new StringBuilder("abc");
            System.out.println(sb);//abc
            referenceStringBuilder(sb);
            System.out.println(sb);//abcReferenceString

            StringBuilder sb02 = new StringBuilder("abc");
            System.out.println(sb02);//abc
            referenceStringBuilder02(sb02);
            System.out.println(sb02);//abc

            Employee employee = new Employee();
            employee.setName("name");
            System.out.println(employee.getName());//name
            referenceObject(employee);
            System.out.println(employee.getName());//referenceObject

            int[] array = new int[10];
            array[0] = 100;
            System.out.println(array[0]);//100
            referenceArray(array);
            System.out.println(array[0]);//200

            int[] array02 = new int[10];
            array02[0] = 100;
            System.out.println(array02[0]);//100
            referenceArray02(array02);
            System.out.println(array02[0]);//100
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

    private static void referenceStringBuilder(StringBuilder str) {
        str.append("ReferenceString");
    }

    private static void referenceStringBuilder02(StringBuilder str) {
        str = new StringBuilder("ReferenceString");
    }

    private static void referenceObject(Employee employee) {
        employee.setName("referenceObject");
    }

    private static void referenceArray(int[] array) {
        array[0] = 200;
        array[1] = 400;
    }

    private static void referenceArray02(int[] array) {
        array = new int[10];
        array[0] = 200;
        array[1] = 400;
    }
}
