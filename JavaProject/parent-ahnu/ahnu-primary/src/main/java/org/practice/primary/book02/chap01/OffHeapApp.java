package org.practice.primary.book02.chap01;

import sun.misc.Unsafe;
import sun.nio.ch.DirectBuffer;

import java.nio.ByteBuffer;

/**
 * @Desc 堆外内存
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015年6月25日
 * <p>
 * @Version 1.0
 */
public class OffHeapApp {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            allocateDirectMemory();
            allocateDirectMemory02();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 堆外内存与堆内内存详解
     * -Xmx100m
     * -XX:MaxDirectMemorySize=100M
     * https://blog.csdn.net/ZYC88888/article/details/80228531
     */
    public static void allocateDirectMemory() {
        //DirectByteBuffer 不是 public 的
        //DirectByteBuffer directByteBuffer = new DirectByteBuffer();

        //分配JVM堆内存，属于GC管辖范围，由于需要拷贝所以速度相对较慢
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //分配OS本地内存，不属于GC管辖范围，由于不需要内存拷贝所以速度相对较快
        ByteBuffer directByteBuffer = ByteBuffer.allocateDirect(1024);
        //clean()方法能有效及时回收直接缓存
        ((DirectBuffer) directByteBuffer).cleaner().clean();
    }

    /**
     * JAVA堆外内存的简介和使用
     * https://www.jianshu.com/p/17e72bb01bf1
     */
    public static void allocateDirectMemory02() {
        //Unsafe类操作堆外内存
        Unsafe unsafe = Unsafe.getUnsafe();
        long baseAddress = unsafe.allocateMemory(1024);
        unsafe.reallocateMemory(1024, 1024);
        unsafe.freeMemory(baseAddress);
        //NIO类操作堆外内存
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
    }
}
