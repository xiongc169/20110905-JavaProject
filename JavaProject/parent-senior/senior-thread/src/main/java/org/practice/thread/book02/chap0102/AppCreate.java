package org.practice.thread.book02.chap0102;

/**
 * @Desc 《Java 7并发编程实战手册》
 * PS：1.2、线程的创建和运行
 * https://www.jb51.net/books/404868.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015-08-30 09:00:00
 * <p>
 * @Version 1.0
 */
public class AppCreate {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            calculatorTest();
            myThread();

            MyThread thread = new MyThread();
            thread.start();
            thread.interrupt();
            Boolean isInterrupted = Thread.currentThread().isInterrupted();
            System.out.println("isInterrupted: " + isInterrupted);
            Thread.currentThread().interrupt();
            Boolean interrupted = thread.interrupted();//获取Thread.currentThread().interrupt();的结果
            System.out.println("interrupted: " + interrupted);
            Boolean isInterrupted2 = Thread.currentThread().isInterrupted();
            System.out.println("isInterrupted2: " + isInterrupted2);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void calculatorTest() {

        for (int i = 0; i < 10; i++) {
            Calculator calculator = new Calculator(i);
            Thread thread = new Thread(calculator);
            thread.start();
        }
    }

    public static void myThread() {
        for (int i = 0; i < 10; i++) {
            MyThread thread = new MyThread();
            thread.start();
        }
    }
}
