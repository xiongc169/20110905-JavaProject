package org.practice.thread.book02;

/**
 * 《Java核心技术卷1 基础知识》
 * https://www.jb51.net/books/227644.html
 *
 * @author Administrator
 */
public class AppThread {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            interrupt1402();
            status1403();
        } catch (RuntimeException ex) {
            ex.printStackTrace();
        } catch (Error error) {
            error.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public static void interrupt1402() {
        //中断方法
        Thread.currentThread().interrupt();
        //获取中断状态，静态方法，而且会清除线程的中断状态
        boolean interrupted = Thread.interrupted();
        //获取中断状态，非静态方法，不会清除线程的中断状态
        Thread thread = new Thread();
        boolean isInterrupted = thread.isInterrupted();
        //新建线程
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
    }

    public static void status1403() {
        //New 新建状态
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getId());
            }
        });
        //Runnable 可运行
        thread.start();
    }
}
