package org.practice.thread;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author chaoxiong
 * <br>
 * @since 2015-10-19 15:45:45
 * <br>
 */
public class App {

    //HH表示24小时制 如果换成hh表示12小时制
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 入口函数
     *
     * @param args
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
