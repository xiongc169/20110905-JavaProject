package org.practice.designPattern.create.ch03singleton;

import org.practice.designPattern.create.ch03singleton.accidence.Single;
import org.practice.designPattern.create.ch03singleton.runoob.SingletonInner;

/**
 * 懒汉式 & 线程不安全：静态方法
 * 懒汉式 & 线程安全：静态同步方法\同步代码块(synchronized)
 * 饿汉式 & 线程安全：初始化就创建
 * 双检索(DCL)：volatile+同步代码块(synchronized)
 * 登记式/静态内部类
 * 枚举
 * http://www.runoob.com/design-pattern/singleton-pattern.html
 * <p>
 * 23种设计模式详解(java)
 * PS：单例模式：非同步方法、synchronized同步方法、synchronized同步代码块；
 * http://www.cnblogs.com/maowang1991/archive/2013/04/15/3023236.html
 *
 * @author yoong
 */
public class App {

    /**
     * 入口函数
     *
     * @param args
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
        System.out.println("single==single2：" + (single == single2));
    }

    public static void singleton_runoob() {
        SingletonInner singleton = SingletonInner.getInstance();
        SingletonInner singleton2 = SingletonInner.getInstance();
        System.out.println("ch03singleton==singleton2：" + (singleton == singleton2));

        //SingletonInner singleton3 = new SingletonInner();
        //SingletonInner singleton4 = new SingletonInner();
        //System.out.println("singleton3 == singleton4：" + (singleton3 == singleton4));//false
    }

}
