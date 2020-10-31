package org.practice.thread.thread01;

import org.practice.thread.thread01.practice.SendEmailTask;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Desc 多线程
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015-08-30 09:06:00
 * <p>
 * @Version 1.0
 */
public class AppThread01 {

    //HH表示24小时制 如果换成hh表示12小时制
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            sendEmail();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 发邮件
     */
    private static void sendEmail() {
        List<String> receivers = new ArrayList<String>();
        receivers.add("xiong****@163.com");
        ExecutorService pool = Executors.newFixedThreadPool(10);

        System.out.println(format.format(new Date()) + " Begin...");
        for (int i = 0; i < 10; i++) {
            SendEmailTask sendEmail = new SendEmailTask(receivers);
            // 1、调用run方法
            //sendEmail.run();
            // 2、启动线程
            //Thread thread = new Thread(sendEmail);
            //thread.start();
            // 3、线程池启动线程
            pool.execute(sendEmail);
        }
        System.out.println(format.format(new Date()) + " End!");
    }
}
