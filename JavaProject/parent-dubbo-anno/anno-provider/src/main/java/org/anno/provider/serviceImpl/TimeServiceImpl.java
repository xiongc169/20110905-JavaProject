package org.anno.provider.serviceImpl;

import org.anno.common.facade.TimeService;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Desc TimeServiceImpl
 * @Author
 * @Date 2019年6月28日14:51:28
 * @Version 1.0
 */
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
