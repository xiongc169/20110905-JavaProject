package com.yoong.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author yoong
 *
 * @desc AuthConfig.java
 *
 * @date 2018年9月20日
 *
 */
@Component
public class AuthConfig {

	@Value("${com.yoong.username}")
	private String userName;

	@Value("${com.yoong.username}")
	private String password;

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
