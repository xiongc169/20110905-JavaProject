package org.practice.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 
 * @author chaoxiong
 * @since 2015-10-19 15:45:45
 * 
 *        线程如何返回值； 线程结束如何回调； 线程间如何通信； 线程间共享变量； 线程安全；
 */
public class App {

	public static void main(String[] args) {

		// 最后的aa表示“上午”或“下午” HH表示24小时制 如果换成hh表示12小时制
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// String now = sdf.format(new Date());
		// System.out.println(now);

		List<String> destMailList = new ArrayList<String>();
		destMailList.add("gcxrnf81923@chacuo.net");

		ExecutorService pool = Executors.newFixedThreadPool(10);

		long begin = System.currentTimeMillis();
		System.out.println("begin :" + begin);

		for (int i = 0; i < 20; i++) {
			SendEmailTask sendEmail = new SendEmailTask(destMailList);

			sendEmail.run(); // 1、调用run方法

			Thread thread = new Thread(sendEmail); // 2、启动线程
			thread.start();

			pool.execute(sendEmail); // 3、线程池启动线程
		}

		long end = System.currentTimeMillis();
		System.out.println("end :" + end);
	}
}
