package org.practice.designPattern.create.ch03singleton;

import org.practice.designPattern.create.ch03singleton.community.Single;
import org.practice.designPattern.create.ch03singleton.runoob.SingletonInner;

/**
 * @Desc 单例模式
 * PS：1、懒汉式 + 静态方法 = 线程不安全
 * 2、懒汉式 + 静态同步方法\同步代码块(synchronized) = 线程安全
 * 3、饿汉式(初始化就创建) = 线程安全
 * 4、双检锁/双重校验锁(DCL, Double-Checked Locking), volatile + static + 同步代码块(synchronized) = 线程安全
 * 5、登记式/静态内部类 = 线程安全
 * 6、枚举
 * http://www.runoob.com/design-pattern/singleton-pattern.html
 * 23种设计模式详解(java)
 * PS：单例模式：非同步方法、synchronized同步方法、synchronized同步代码块；
 * http://www.cnblogs.com/maowang1991/archive/2013/04/15/3023236.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2012年7月4日
 * <p>
 * @Version 1.0
 */
public class App {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            single_accidence();
            singleton_runoob();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void single_accidence() {
        Single single = Single.getInstance();
        Single single2 = Single.getInstance();
        System.out.println("single == single2：" + (single == single2));
    }

    public static void singleton_runoob() {
        SingletonInner singleton = SingletonInner.getInstance();
        SingletonInner singleton2 = SingletonInner.getInstance();
        System.out.println("ch03singleton == singleton2：" + (singleton == singleton2));

        SingletonInner singleton3 = SingletonInner.getInstance();
        SingletonInner singleton4 = SingletonInner.getInstance();
        System.out.println("singleton3 == singleton4：" + (singleton3 == singleton4));//true
    }

}
