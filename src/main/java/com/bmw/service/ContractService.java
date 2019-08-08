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

	public List<Contract> getPreContractList(String dealerId, String regionId, String groupId, String contractStatus) {

		return contractList;
	}

}
