package org.practice.netty.book01.ch0701serial;

import java.io.Serializable;

public class SubscribeReq implements Serializable {

	private static final long serialVersionUID = 1L;

	private int subReqID;

	private String userName;

	private String productName;

	private String phoneNumber;

	public int getSubReqID() {
		return subReqID;
	}

	public void setSubReqID(int subReqID) {
		this.subReqID = subReqID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
