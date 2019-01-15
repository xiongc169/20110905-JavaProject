package org.practice.designPattern.create.ch03singleton.accidence;

/**
 * @author yoong
 * <br>
 * @desc 23种设计模式详解(java)
 * PS：单例模式：非同步方法、synchronized同步方法、synchronized同步代码块；
 * http://www.cnblogs.com/maowang1991/archive/2013/04/15/3023236.html
 * <br>
 * @date 2019/1/14 15:32
 */
public class Single {

    private static Single instance = null;

    private Single() {
    }

    /**
     * 非同步方法、synchronized同步方法、synchronized同步代码块
     * <p>
     * synchronized 同步代码块可能出错：在Java指令中创建对象和赋值操作是分开进行的，即instance = new Single();语句是分两步执行的。
     * 但是JVM并不保证这两个操作的先后顺序，也就是说有可能JVM会为新的Singleton实例分配空间，然后直接赋值给instance成员，然后再去初始化这个Singleton实例。这样就可能出错了，
     *
     * @return
     */
    public static Single getInstance() {
        if (instance == null) {
//            synchronized (Single.class) {
            instance = new Single();
        }
//        }
        return instance;
    }
}
