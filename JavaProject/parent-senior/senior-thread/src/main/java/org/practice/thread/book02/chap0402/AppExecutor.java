package org.practice.thread.book02.chap0402;

/**
 * @Desc 《Java 7并发编程实战手册》
 * PS：4.2、创建线程执行器
 * https://www.jb51.net/books/404868.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015-08-30 09:00:00
 * <p>
 * @Version 1.0
 */
public class AppExecutor {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            serverTest();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 4.2、创建线程执行器
     */
    private static void serverTest() {
        Server server = new Server();
        for (int i = 0; i < 10; i++) {
            Task task = new Task("Task-" + i);
            server.executeTask(task);
        }
        server.endServer();
    }
}
