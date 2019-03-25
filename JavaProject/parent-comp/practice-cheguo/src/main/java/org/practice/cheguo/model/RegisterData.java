package org.practice.cheguo.model;

/**
 * 
 * @author 20180112002
 *
 */
public class RegisterData {

	/**
	 * 项目主键
	 */
	private Integer coCompanyId;

	/**
	 * 用户id
	 */
	private Long customerId;

	/**
	 * 注册编号 (在基金公司注册 产生的注册编号)
	 */
	private String registerNo;

	/**
	 * 基金公司返回url
	 */
	private String linkUrl;

	/**
	 * 认证状态，0: 未认证 1:已认证 (基金公司返回状态 中间件转译成这2个)
	 */
	private Integer registerStatus;

	/**
	 * 注册手机号码
	 */
	private String registerMobile;

	/**
	 * 身份证号
	 */
	private String globalId;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 银行预留手机号码
	 */
	private String reservedMobile;

	/**
	 * 银行卡开户名
	 */
	private String bankAccountName;

	/**
	 * 银行卡号
	 */
	private String bankAccountNo;

	/**
	 * 银行名称
	 */
	private String bankName;

	/**
	 * 银行编号
	 */
	private String bankNo;

	public Integer getCoCompanyId() {
		return coCompanyId;
	}

	public void setCoCompanyId(Integer coCompanyId) {
		this.coCompanyId = coCompanyId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getRegisterNo() {
		return registerNo;
	}

	public void setRegisterNo(String registerNo) {
		this.registerNo = registerNo;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public Integer getRegisterStatus() {
		return registerStatus;
	}

	public void setRegisterStatus(Integer registerStatus) {
		this.registerStatus = registerStatus;
	}

	public String getRegisterMobile() {
		return registerMobile;
	}

	public void setRegisterMobile(String registerMobile) {
		this.registerMobile = registerMobile;
	}

	public String getGlobalId() {
		return globalId;
	}

	public void setGlobalId(String globalId) {
		this.globalId = globalId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReservedMobile() {
		return reservedMobile;
	}

	public void setReservedMobile(String reservedMobile) {
		this.reservedMobile = reservedMobile;
	}

	public String getBankAccountName() {
		return bankAccountName;
	}

	public void setBankAccountName(String bankAccountName) {
		this.bankAccountName = bankAccountName;
	}

	public String getBankAccountNo() {
		return bankAccountNo;
	}

	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankNo() {
		return bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}
}
