package org.practice.thread.book01.chap0402;

public class App {

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
