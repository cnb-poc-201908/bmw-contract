package com.bmw.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Contract {
	private BasicInfo basicInfo;

	private CustomerInfo customerInfo;

	private SalesSummary salesSummary;

	private String comments;

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
}