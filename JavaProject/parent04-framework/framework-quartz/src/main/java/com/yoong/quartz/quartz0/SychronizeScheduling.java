package com.yoong.quartz.quartz0;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @Desc Quartz
 * http://blog.csdn.net/a4307515/article/details/46985533
 * <p>
 * @Author yoong
 * <p>
 * @Date 2016年8月2日 下午5:32:13
 * <p>
 * @Version 1.0
 */
public class SychronizeScheduling {

    /**
     * 入口函数
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
