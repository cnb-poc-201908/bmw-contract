package com.bmw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmw.common.BMWPocConstants;
import com.bmw.model.Contract;

@Service
public class ContractService {
	@Autowired
	private List<Contract> contractList;

	public List<Contract> getPreContractList(String dealerId, String regionId, String groupId, String contractStatus) {

		return contractList;
	}


	public int createContract(String contractId, Contract contractForm) {
		int result = BMWPocConstants.REST_SUCCESS_CODE;
		for(Contract contract : contractList) {
			if(contractId != null && contractId.equals(contract.getContractId())) {
				contract.setContractStatus(BMWPocConstants.CONTRACT_STATUS_CREATED);
				contract.setProcessCode(BMWPocConstants.CONTRACT_STATUS_CREATED);
			}
		}
		return result;
	}

	public int updateContractStatus(String contractId,
				String contractStatus, String processCode) {
		int result = BMWPocConstants.REST_SUCCESS_CODE;
		for(Contract contract : contractList) {
			if(contractId != null && contractId.equals(contract.getContractId())) {
				contract.setContractStatus(contractStatus);
				contract.setProcessCode(processCode);
			}
		}
		return result;
	}

}
