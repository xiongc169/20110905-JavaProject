package com.yoong.quartz.quartz1;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @Desc Quartz
 * http://www.yiibai.com/quartz/
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
            simpleTriggerDemo();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
