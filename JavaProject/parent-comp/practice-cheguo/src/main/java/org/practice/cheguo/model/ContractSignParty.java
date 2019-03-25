package org.practice.cheguo.model;

/**
 * 合同签署方信息
 * 
 * @author yoong
 *
 */
public class ContractSignParty {

	/**
	 * 签署方类型
	 */
	private String userType;

	/**
	 * 签署方身份证号
	 */
	private String identityNo;

	/**
	 * 签署方名称
	 */
	private String userName;

	/**
	 * 签署方手机号
	 */
	private String mobileNo;

	/**
	 * 签署位置
	 */
	private String signLocation;

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getIdentityNo() {
		return identityNo;
	}

	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getSignLocation() {
		return signLocation;
	}

	public void setSignLocation(String signLocation) {
		this.signLocation = signLocation;
	}
}
