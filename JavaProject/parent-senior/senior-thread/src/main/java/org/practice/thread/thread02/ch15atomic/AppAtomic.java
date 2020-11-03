package org.practice.thread.thread02.ch15atomic;

import java.util.concurrent.atomic.*;

/**
 * @Desc Java中的13个原子操作类总结
 * https://blog.csdn.net/qq_36236890/article/details/81914871
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年8月29日
 * <p>
 * @Version 1.0
 */
public class AppAtomic {

    /**
     * 入口函数
     */
    public static void main(String[] args) throws Exception {
        try {
            atomicPrimary();
            atomicArray();
            atomicRefer();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void atomicPrimary() {
        AtomicInteger atomicInteger = new AtomicInteger();
        AtomicLong atomicLong = new AtomicLong();
        AtomicBoolean atomicBoolean = new AtomicBoolean();

        int result = atomicInteger.addAndGet(100);
        System.out.println("result: " + result);//100
        result = atomicInteger.get();
        System.out.println("result: " + result);//100

        boolean result02 = atomicInteger.compareAndSet(20, 200);
        boolean result03 = atomicInteger.compareAndSet(100, 200);
        System.out.println("result02: " + result02);//false
        System.out.println("result03: " + result03);//true
        int newValue02 = atomicInteger.get();
        System.out.println("newValue02: " + newValue02);//200

        int oldValue03 = atomicInteger.getAndIncrement();
        int newValue03 = atomicInteger.get();
        System.out.println("oldValue03: " + oldValue03);//200
        System.out.println("newValue03: " + newValue03);//201

        atomicInteger.lazySet(555);
        atomicInteger.set(566);
        int oldValue04 = atomicInteger.getAndSet(666);
        int newValue04 = atomicInteger.get();
        System.out.println("oldValue04: " + oldValue04);//555
        System.out.println("newValue04: " + newValue04);//666
    }

    public static void atomicArray() {
        int[] intArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        long[] longArray = new long[]{90, 91, 92, 93, 94, 95, 96, 97, 98, 99};
        Long[] LongArray = new Long[10];
        int[] intArray2 = new int[10];

        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(intArray);
        AtomicLongArray atomicLongArray = new AtomicLongArray(longArray);
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(LongArray);

        int result = atomicIntegerArray.get(5);
        System.out.println("result: " + result);//5

        boolean bool01 = atomicIntegerArray.compareAndSet(5, 4, 55);
        int result01 = atomicIntegerArray.get(5);
        System.out.println("bool01: " + bool01);//false
        System.out.println("result01: " + result01);//5

        boolean bool02 = atomicIntegerArray.compareAndSet(5, 5, 55);
        int result02 = atomicIntegerArray.get(5);
        System.out.println("bool02: " + bool02);//true
        System.out.println("result02: " + result02);//55
    }

    public static void atomicRefer() {
        AtomicReference atomicReference = new AtomicReference();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = new AtomicReferenceFieldUpdater() {
            @Override
            public boolean compareAndSet(Object obj, Object expect, Object update) {
                return false;
            }

            @Override
            public boolean weakCompareAndSet(Object obj, Object expect, Object update) {
                return false;
            }

            @Override
            public void set(Object obj, Object newValue) {

            }

            @Override
            public void lazySet(Object obj, Object newValue) {

            }

            @Override
            public Object get(Object obj) {
                return null;
            }
        };
        //AtomicMarkableReference atomicMarkableReference = new AtomicMarkableReference();
    }

    public static void atomicField() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = new AtomicIntegerFieldUpdater() {
            @Override
            public boolean compareAndSet(Object obj, int expect, int update) {
                return false;
            }

            @Override
            public boolean weakCompareAndSet(Object obj, int expect, int update) {
                return false;
            }

            @Override
            public void set(Object obj, int newValue) {

            }

            @Override
            public void lazySet(Object obj, int newValue) {

            }

            @Override
            public int get(Object obj) {
                return 0;
            }
        };
        AtomicLongFieldUpdater atomicLongFieldUpdater = new AtomicLongFieldUpdater() {
            @Override
            public boolean compareAndSet(Object obj, long expect, long update) {
                return false;
            }

            @Override
            public boolean weakCompareAndSet(Object obj, long expect, long update) {
                return false;
            }

            @Override
            public void set(Object obj, long newValue) {

            }

            @Override
            public void lazySet(Object obj, long newValue) {

            }

            @Override
            public long get(Object obj) {
                return 0;
            }
        };
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = new AtomicReferenceFieldUpdater() {
            @Override
            public boolean compareAndSet(Object obj, Object expect, Object update) {
                return false;
            }

            @Override
            public boolean weakCompareAndSet(Object obj, Object expect, Object update) {
                return false;
            }

            @Override
            public void set(Object obj, Object newValue) {

            }

            @Override
            public void lazySet(Object obj, Object newValue) {

            }

            @Override
            public Object get(Object obj) {
                return null;
            }
        };
    }
}
