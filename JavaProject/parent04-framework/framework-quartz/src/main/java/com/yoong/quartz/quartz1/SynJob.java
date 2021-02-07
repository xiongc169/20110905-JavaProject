package com.yoong.quartz.quartz1;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * @Desc 创建任务
 * <p>
 * @Author yoong
 * <p>
 * @Date 2016年8月2日 下午5:32:13
 * <p>
 * @Version 1.0
 */
public class SynJob implements Job {

    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDetail detail = context.getJobDetail();
        String name = detail.getJobDataMap().getString("name");
        System.out.println("Hello, Quartz! - executing its JOB at " + new Date() + " by " + name);
    }
}
