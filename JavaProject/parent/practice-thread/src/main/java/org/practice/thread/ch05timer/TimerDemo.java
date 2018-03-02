package org.practice.thread.ch05timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Java并发编程：Timer和TimerTask（转载）
 * http://www.cnblogs.com/dolphin0520/p/3938991.html
 * 
 * @author Administrator
 *
 */
public class TimerDemo {

	public static void main(String[] args) {

		System.out.println(new Date().toString() + "：this is before timer.schedule()");

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println(new Date().toString() + "：this is timertask()");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					String msg = e.getMessage();
					System.out.println(msg);
				}
			}
		}, 3000, 1000);

		System.out.println(new Date().toString() + "：this is after timer.schedule()");
	}

}
