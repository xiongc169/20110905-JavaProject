package org.practice.designPattern.create.ch03singleton.community;

/**
 * @Desc 23种设计模式详解(java)
 * PS：单例模式：饿汉模式；
 * http://www.cnblogs.com/maowang1991/archive/2013/04/15/3023236.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2012年7月4日
 * <p>
 * @Version 1.0
 */
public class SingleHunger {

    private static SingleHunger instance = new SingleHunger();

    private SingleHunger() {
    }

    /**
     * 饿汉模式，占用内存
     */
    private static SingleHunger getInstance() {
        return SingleHunger.instance;
    }
}
