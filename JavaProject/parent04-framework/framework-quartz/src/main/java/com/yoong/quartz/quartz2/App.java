package com.yoong.quartz.quartz2;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @Desc App
 * <p>
 * @Author yoong
 * <p>
 * @Date 2016年8月2日 下午5:32:13
 * <p>
 * @Version 1.0
 */
public class App {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            greetJob();
            System.out.println("Ending of GreetJob!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
