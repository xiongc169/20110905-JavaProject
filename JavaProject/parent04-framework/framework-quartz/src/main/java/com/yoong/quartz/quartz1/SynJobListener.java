package com.yoong.quartz.quartz1;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

public class SynJobListener implements JobListener {

    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }

    public void jobToBeExecuted(JobExecutionContext context) {
        // TODO Auto-generated method stub

    }

    public void jobExecutionVetoed(JobExecutionContext context) {
        // TODO Auto-generated method stub

    }

    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        // TODO Auto-generated method stub

    }
}
