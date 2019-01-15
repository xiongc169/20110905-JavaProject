package org.practice.designPattern.create.ch03singleton.accidence;

/**
 * @author yoong
 * <br>
 * @desc 23种设计模式详解(java)
 * PS：单例模式：饿汉模式；
 * http://www.cnblogs.com/maowang1991/archive/2013/04/15/3023236.html
 * <br>
 * @date 2019/1/14 15:32
 */
public class SingleHunger {

    private static SingleHunger instance = new SingleHunger();

    private SingleHunger() {
    }

    /**
     * 饿汉模式，占用内存
     *
     * @return
     */
    private static SingleHunger getInstance() {
        return SingleHunger.instance;
    }
}
