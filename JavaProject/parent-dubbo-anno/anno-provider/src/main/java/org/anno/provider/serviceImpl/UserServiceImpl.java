package org.anno.provider.serviceImpl;

import org.anno.common.service.UserService;

import com.alibaba.dubbo.config.annotation.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public String getUserName() {
        //2017-10-25 15:00:54
        String userName = "Yoong —— " + format.format(new Date());
        return userName;
    }

}
