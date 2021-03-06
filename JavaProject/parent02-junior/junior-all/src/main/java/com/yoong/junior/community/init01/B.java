package com.yoong.junior.community.init01;

/**
 * @Desc Java中继承的定义与使用
 * https://blog.csdn.net/zhao_miao/article/details/83240404
 * <p>
 * @Author yoong
 * <p>
 * @Date 2016-6-10 11:20:19
 * <p>
 * @Version 1.0
 */
public class B extends A {

    public B() {
        //Call to super() must be first statement in constructor body
        super("aa");
        System.out.println("4.B类的构造方法");
    }

    {
        System.out.println("5.B类的构造块");
    }

    static {
        System.out.println("6.B类的静态方法");
    }

    public static void main(String[] args) {
        System.out.println("7.start......");
        new B();
        new B();
        System.out.println("8.end.....");
    }
}

class A {
    public A() {
        System.out.println("1.A类的构造方法");
    }

    public A(String aa) {
        System.out.println("1.A类的构造方法-2");
    }

    {
        System.out.println("2.A类的构造块");
    }

    static {
        System.out.println("3.A类的静态方法");
    }
}
