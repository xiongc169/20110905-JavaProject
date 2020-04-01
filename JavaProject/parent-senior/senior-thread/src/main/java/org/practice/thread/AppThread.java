package org.practice.thread;

/**
 * @author yoong
 * <br/>
 * @desc 线程如何返回值； 线程结束如何回调； 线程间如何通信； 线程间共享变量； 线程安全；
 * <br/>
 * @date 2018年8月28日
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
