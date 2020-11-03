package org.practice.thread;

/**
 * @Desc 线程如何返回值； 线程结束如何回调； 线程间如何通信； 线程间共享变量； 线程安全；
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015-08-30 09:00:00
 * <p>
 * @Version 1.0
 */
public class AppThread {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            System.out.println(args.length);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
