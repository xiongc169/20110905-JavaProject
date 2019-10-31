package org.practice.quartz.quartz1;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 调度任务：http://www.yiibai.com/quartz/
 */
public class App {
	public static void main(String[] args) {

		simpleTriggerDemo();

	}

	public static void simpleTriggerDemo() {
		try {
			// Quartz 1.6.3
			// JobDetail job = new JobDetail();
			// job.setName("dummyJobName");
			// job.setJobClass(HelloJob.class);
			JobDetail job = JobBuilder.newJob(SynJob.class).withIdentity("dummyJobName", "group1").build();

			// Quartz 1.6.3
			// SimpleTrigger trigger = new SimpleTrigger();
			// trigger.setStartTime(new Date(System.currentTimeMillis() +
			// 1000));
			// trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
			// trigger.setRepeatInterval(30000);

			// Trigger the job to run on the next round minute
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity("dummyTriggerName", "group1")
					.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever())
					.build();

			// schedule it
			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
			scheduler.scheduleJob(job, trigger);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void cronTriggerDemo() {
		try {
			// Quartz 1.6.3
			// JobDetail job = new JobDetail();
			// job.setName("dummyJobName");
			// job.setJobClass(HelloJob.class);
			JobDetail job = JobBuilder.newJob(SynJob.class).withIdentity("dummyJobName", "group1").build();

			// Quartz 1.6.3
			// CronTrigger trigger = new CronTrigger();
			// trigger.setName("dummyTriggerName");
			// trigger.setCronExpression("0/5 * * * * ?");

			Trigger trigger = TriggerBuilder.newTrigger().withIdentity("dummyTriggerName", "group1")
					.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();

			// schedule it
			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
			scheduler.scheduleJob(job, trigger);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
