package org.practice.quartz0;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @description SychronizeScheduling.java
 * @author chaoxiong
 * @date 2016年8月2日 下午5:36:09
 */
public class SychronizeScheduling {

	/**
	 * @description TODO
	 * @param args
	 * @throws SchedulerException
	 * @return void
	 * @author chaoxiong
	 * @date 2016年8月2日 下午7:24:13
	 *       http://blog.csdn.net/a4307515/article/details/46985533
	 */
	public static void main(String[] args) throws SchedulerException {
		// 1、定义job实例，JobBuilder
		JobDetail jobDetail = JobBuilder.newJob(SychronizeJob.class).withIdentity("SychronizeJob", "group1").usingJobData("name", "孙悟空").build();

		// 2、使用触发器定义job如何执行，TriggerBuilder
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger", "group1").startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).withRepeatCount(3)).build();

		// 3、任务调度API，启动或者终止任务
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = schedulerFactory.getScheduler();
		scheduler.scheduleJob(jobDetail, trigger);

		// 4、启动job
		scheduler.start();
	}
}
