package org.practice.jvm.book01;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @Desc 《深入理解Java虚拟机·JVM高级特性与实践》
 * 第二章、Java内存区域与内存溢出异常
 * @Author
 * @Date
 * @Version 1.0
 */
public class Chap02 {

    private static Integer stackLength = 0;

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            heapOutOfMemory();
            stackLeak();
            nativeStackLeak();
            methodArea();
            directoryMemoryOOM();
            testAllocation();
            System.gc();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 2.4.1、堆溢出
     * -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+HeapDumpOnOutOfMemoryError
     * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
     */
    public static void heapOutOfMemory() {
        List<Object> list = new ArrayList<>();
        while (true) {
            list.add(new Object());
        }
    }

    /**
     * 2.4.2、虚拟机栈溢出
     * Exception in thread "main" java.lang.StackOverflowError
     */
    public static void stackLeak() {
        stackLength++;
        stackLeak();
    }

    /**
     * 2.4.2、本地方法栈溢出
     */
    public static void nativeStackLeak() {
        List<String> list = new ArrayList<>();
        String name = "yoong";
        int i = 0;
        while (true) {
            //若字符串常量池中包含一个等于此String对象的字符串，则返回常量池这个字符串的String对象；
            //否则将此String对象添加到常量池，并返回此String对象的引用；
            list.add(name.intern() + i++);
        }
    }

    /**
     * 2.4.3、方法区和运行时常量池溢出
     * -XX:PermSize=10M -XX:MaxPermSize=10M
     * Exception in thread "main" java.lang.StackOverflowError
     */
    public static void methodArea() {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (true) {
            result.add(("String" + i).intern());
            i++;
        }
    }

    /**
     * 2.4.4、本机直接内存溢出
     * -XX:MaxDirectMemorySize
     */
    public static void directoryMemoryOOM() throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(1);
        }
    }

    /**
     * 3.6.1
     * -XX:+PrintGCDetails
     * -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8
     */
    public static void testAllocation() {

        byte[] allocation1 = new byte[2 * 1024 * 1024];
        byte[] allocation2 = new byte[2 * 1024 * 1024];
        byte[] allocation3 = new byte[2 * 1024 * 1024];
        byte[] allocation4 = new byte[4 * 1024 * 1024];
    }
}
