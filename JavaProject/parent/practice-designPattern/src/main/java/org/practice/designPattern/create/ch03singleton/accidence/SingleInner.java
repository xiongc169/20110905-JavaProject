package org.practice.designPattern.create.ch03singleton.accidence;

/**
 * @author yoong
 * <br>
 * @desc 23种设计模式详解(java)
 * PS：单例模式：内部类
 * http://www.cnblogs.com/maowang1991/archive/2013/04/15/3023236.html
 * <br>
 * @date 2019/1/14 15:40
 */
public class SingleInner {

    private SingleInner() {
    }

    private static class SingletonFactory {
        private static final SingleInner INSTANCE = new SingleInner();
    }

    public static final SingleInner getInstance() {
        return SingletonFactory.INSTANCE;
    }
}

