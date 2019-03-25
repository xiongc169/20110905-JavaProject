package org.practice.thread2.chap0102;

/**
 *
 */
public class App {

    /**
     * 入口函数
     *
     * @param args
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
