package org.anno.provider.serviceImpl;

import org.anno.common.service.UserService;

import com.alibaba.dubbo.config.annotation.Service;

@Service
public class UserServiceImpl implements UserService {

	public String getUserName() {
		return "chaoxiong——2017-10-25 15:00:54";
	}

}
