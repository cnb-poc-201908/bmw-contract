package com.bmw.data;

import java.util.ArrayList;
import java.util.List;
import com.bmw.model.Contract;
import com.bmw.model.CustomerInfo;

public class ContractDataBuilder {

	private ContractDataBuilder() {

	}

	public static List<Contract> buildcontractList() {
		List<Contract> contractList = new ArrayList<Contract>();
		
		CustomerInfo cusInfo = new CustomerInfo();
		cusInfo.setCustomerName("Kenny Lee");
		
		Contract contract = new Contract();
		contract.setCustomerInfo(cusInfo);
		contractList.add(contract);
		return contractList;
	}
}