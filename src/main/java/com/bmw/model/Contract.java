package com.bmw.model;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Contract {
	// 合同ID
	private String contractId;

	// 进程代码
	private String processCode;

	// 合同状态 I:invoice已开票 O:未创建 C:已创建
	private String contractStatus;

	// 经销商
	private String dealerId;
	private String dealerName;

	// 区域
	private String regionId;
	private String regionName;

	// 集团
	private String groupId;
	private String groupName;
	

	private BasicInfo basicInfo;

	private CustomerInfo customerInfo;

	private SalesSummary salesSummary;

	// accessory mapping of <accessoryId,number>
	private Map<String, Integer> accessories;

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

	public Map<String, Integer> getAccessories() {
		return accessories;
	}

	public void setAccessories(Map<String, Integer> accessories) {
		this.accessories = accessories;
	}

	public String getDealerId() {
		return dealerId;
	}

	public void setDealerId(String dealerId) {
		this.dealerId = dealerId;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
}