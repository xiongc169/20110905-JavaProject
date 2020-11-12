package org.practice.quartz.quartz2;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

public class GreetJob implements Job {

    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Hello " + new Date());
    }
}
