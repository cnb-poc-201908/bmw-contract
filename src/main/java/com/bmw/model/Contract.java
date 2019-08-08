package com.bmw.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Contract {
	// 合同ID
	private String contractId;

	// 进程代码
	private String processCode;

	// 合同状态 I:invoice已开票 O:未创建 C:已创建
	private String contractStatus;

	private BasicInfo basicInfo;

	private CustomerInfo customerInfo;

	private SalesSummary salesSummary;

	private String comments;

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getProcessCode() {
		return processCode;
	}

	public void setProcessCode(String processCode) {
		this.processCode = processCode;
	}

	public String getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}

	public BasicInfo getBasicInfo() {
		return basicInfo;
	}

	public void setBasicInfo(BasicInfo basicInfo) {
		this.basicInfo = basicInfo;
	}

	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}

	public SalesSummary getSalesSummary() {
		return salesSummary;
	}

	public void setSalesSummary(SalesSummary salesSummary) {
		this.salesSummary = salesSummary;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Contract(String contractId, String processCode, String contractStatus) {
		this.contractId = contractId;
		this.processCode = processCode;
		this.contractStatus = contractStatus;
	}

	public Contract() {

	}

}