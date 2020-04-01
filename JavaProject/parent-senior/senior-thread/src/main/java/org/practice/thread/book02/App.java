package org.practice.thread.book02;

/**
 * 《Java核心技术卷1 基础知识》第十四章、多线程
 * https://www.jb51.net/books/227644.html
 *
 * @author Administrator
 */
public class App {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            System.out.println("Hello");
        } catch (RuntimeException ex) {
            ex.printStackTrace();
        } catch (Error error) {
            error.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
