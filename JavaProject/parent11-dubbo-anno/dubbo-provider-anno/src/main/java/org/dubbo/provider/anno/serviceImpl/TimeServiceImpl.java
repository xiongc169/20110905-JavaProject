package org.dubbo.provider.anno.serviceImpl;

import org.dubbo.common.anno.facade.TimeService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeServiceImpl implements TimeService {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public TimeServiceImpl() {
        System.out.println("TimeServiceImpl " + dateFormat.format(new Date()));
    }

    @Override
    public String getTime() {
        String result = String.format("TimeServiceImpl.getTime %s", dateFormat.format(new Date()));
        return result;
    }
}
