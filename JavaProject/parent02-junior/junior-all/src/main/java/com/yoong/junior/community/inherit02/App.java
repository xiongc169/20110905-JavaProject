package com.yoong.junior.community.inherit02;

/**
 * @Desc 聊聊java中的继承
 * https://blog.csdn.net/JavaCoder_juejue/article/details/81112692
 * https://blog.csdn.net/u014253011/article/details/84564308
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015-6-10
 * <p>
 * @Version 1.0
 */
public class App {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        Child child = new Child();
        child.show();
    }
}

class Parent {
    public int num = 10;

    public Parent() {
        System.out.println("Parent()");
    }
}

class Child extends Parent {
    public int num = 20;

    public Child() {
        System.out.println("Child()");
    }

    public void show() {
        int num = 30;
        System.out.println(num);
        System.out.println(this.num);
        System.out.println(super.num);
    }
}
