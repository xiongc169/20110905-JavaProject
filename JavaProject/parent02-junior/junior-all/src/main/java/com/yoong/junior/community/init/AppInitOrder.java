package com.yoong.junior.community.init;

/**
 * @Desc 关于static语句, 构造代码块, 构造方法的执行顺序
 * PS：执行顺序：类加载之后，按从上到下执行被static修饰的语句(静态代码块)。如果有语句new了自身的对象，将从上到下执行构造代码块、构造器；创建完对象后，接着执行下面的static语句，当static语句执行完之后，再执行main方法。
 * https://blog.csdn.net/tt_zhang/article/details/7614180
 * <p>
 * @Author yoong
 * <p>
 * @Date 2013/1/10 17:02
 * <p>
 * @Version 1.0
 */
public class AppInitOrder {

    /**
     * 入口函数
     * <p>
     * ==静态块1start==
     * __构造块2start__
     * __构造块1start__
     * =======构造器-start========
     * ==静态块2start==
     * __构造块2start__
     * __构造块1start__
     * =======构造器-start========
     * =====method========
     * ==静态块3start==
     * main-start
     * __构造块2start__
     * __构造块1start__
     * =======构造器-start========
     * main-end
     */
    public static void main(String[] args) {
        try {
            System.out.println("main-start");
            new AppInitOrder();
            System.out.println("main-end");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static int method() {
        System.out.println("=====method========");
        return 0;
    }

    {
        System.out.println("__构造块2start__");
    }

    static {
        System.out.println("==静态块1start==");
    }

    public static AppInitOrder t1 = new AppInitOrder();

    static {
        System.out.println("==静态块2start==");
    }

    public static AppInitOrder t2 = new AppInitOrder();

    public static int x = method();

    static {
        System.out.println("==静态块3start==");
    }

    public AppInitOrder() {
        System.out.println("=======构造器-start========");
    }

    {
        System.out.println("__构造块1start__");
    }
}
