package org.practice.quartz0;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @description SychronizeJob.java
 * @author chaoxiong
 * @date 2016年8月2日 下午5:32:13
 */
public class SychronizeJob implements Job {

	/**
	 * 创建一个job
	 */
	public void execute(JobExecutionContext context) throws JobExecutionException {

		//向job中传递数据
		// JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
		// String name = jobDataMap.getString("name");
		System.out.println("Hello, Quartz! - executing its JOB at " + new Date());

	}

}
