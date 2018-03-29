package org.practice.cheguo.model;

/**
 * 
 * @author yoong
 *
 */
public class QueryData {

	/**
	 * 
	 */
	private String registerNo;

	/**
	 * 用户注册状态，1 已注册，0 未注册，0 包含未注册，处理中，失败等情况
	 */
	private String registerStatus;

	public String getRegisterNo() {
		return registerNo;
	}

	public void setRegisterNo(String registerNo) {
		this.registerNo = registerNo;
	}

	public String getRegisterStatus() {
		return registerStatus;
	}

	public void setRegisterStatus(String registerStatus) {
		this.registerStatus = registerStatus;
	}
}
