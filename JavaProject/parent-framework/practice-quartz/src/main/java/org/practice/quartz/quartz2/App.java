package org.practice.quartz.quartz2;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class App {

	public static void main(String[] args) {

		greetJob();

		System.out.println("Ending of GreetJob!");
	}

	public static void greetJob() {

		try {

			JobDetail greet = JobBuilder.newJob(GreetJob.class).withIdentity("myJobName", "myGroupName").build();

			Trigger simpleTrigger = TriggerBuilder.newTrigger().withIdentity("myTriggerName", "myTriggerGroupName")
					.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever())
					.build();

			Scheduler schedule = new StdSchedulerFactory().getScheduler();

			schedule.scheduleJob(greet, simpleTrigger);

			schedule.start();

		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
}
