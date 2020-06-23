package org.practice.designPattern.create.ch03singleton.community;

/**
 * @Desc 23种设计模式详解(java)
 * PS：单例模式：非同步方法、synchronized同步方法、synchronized同步代码块；
 * http://www.cnblogs.com/maowang1991/archive/2013/04/15/3023236.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2012年7月4日
 * <p>
 * @Version 1.0
 */
public class Single {

    private static Single instance = null;

    private Single() {
    }

    /**
     * 1、非同步方法：单线程环境中，基本满足需求；但多线程环境中，会有问题；
     * 2、synchronized 同步方法：在性能上会有所下降，因为每次调用getInstance()，都要对对象上锁；
     * 3、synchronized 同步代码块：性能有一定提升，但还是有问题：在Java指令中创建对象和赋值操作是分开进行的，即instance = new Single();语句是分两步执行的。
     * 但是JVM并不保证这两个操作的先后顺序，也就是说有可能JVM先为新的Singleton实例分配空间，再直接赋值给instance成员，最后去初始化这个Singleton实例，这样就可能出错了。(先为Single分配空间，再赋值给instance，最后去初始化实例)
     * 4、饿汉模式，SingleHunger
     * 5、内部静态类
     */
    public static Single getInstance() {
        if (instance == null) {
            //synchronized (Single.class) {
                //if (instance == null) {
                    instance = new Single();
                //}
            //}
        }
        return instance;
    }
}
