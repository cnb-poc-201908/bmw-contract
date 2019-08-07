package com.bmw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmw.model.Contract;
import com.bmw.model.CustomerInfo;

@Service
public class ContractService {
	@Autowired
	private List<Contract> contractList;

	public List<Contract> getcontractList(String dealerId, String regionId, String groupId) {
		
		CustomerInfo cusInfo = new CustomerInfo();
		cusInfo.setCustomerName("Li Zheng Bang");
		
		Contract contract = new Contract();
		contract.setCustomerInfo(cusInfo);
		contractList.add(contract);
		
		return contractList;
	}

}
