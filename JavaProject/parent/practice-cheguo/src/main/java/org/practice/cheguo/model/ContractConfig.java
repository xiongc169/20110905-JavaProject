package org.practice.cheguo.model;

import java.util.List;

public class ContractConfig {
	
	private String templateName;
	
	private String templateNo;
	
	List<ContractSignParty> contarctSignPartys;

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
}
