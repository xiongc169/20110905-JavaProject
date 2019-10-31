package org.practice.quartz.quartz1;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 创建任务
 * 
 * @author Administrator
 *
 */
public class SynJob implements Job {

	public void execute(JobExecutionContext context) throws JobExecutionException {

		JobDetail detail = context.getJobDetail();
		String name = detail.getJobDataMap().getString("name");
		System.out.println("Hello, Quartz! - executing its JOB at " + new Date() + " by " + name);

	}

}
