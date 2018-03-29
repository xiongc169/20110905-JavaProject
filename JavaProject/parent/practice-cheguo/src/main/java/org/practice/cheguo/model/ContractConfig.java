package org.practice.cheguo.model;

import java.util.List;
import java.util.Map;

/**
 * 合同的配置类
 * 
 * @author yoong
 *
 */
public class ContractConfig {

	/**
	 * 合同模板名称
	 */
	private String templateName;

	/**
	 * 合同模板编号
	 */
	private String templateNo;

	/**
	 * 合同签署方列表
	 */
	private List<ContractSignParty> contarctSignPartys;

	/**
	 * 参数配置
	 */
	private Map<String, String> data;

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getTemplateNo() {
		return templateNo;
	}

	public void setTemplateNo(String templateNo) {
		this.templateNo = templateNo;
	}

	public List<ContractSignParty> getContarctSignPartys() {
		return contarctSignPartys;
	}

	public void setContarctSignPartys(List<ContractSignParty> contarctSignPartys) {
		this.contarctSignPartys = contarctSignPartys;
	}

	public Map<String, String> getData() {
		return data;
	}

	public void setData(Map<String, String> data) {
		this.data = data;
	}
}
