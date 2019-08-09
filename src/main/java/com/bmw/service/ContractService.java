package com.bmw.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmw.common.BMWPocConstants;
import com.bmw.model.Contract;
import com.bmw.model.ContractTemplate;

@Service
public class ContractService {
	@Autowired
	private List<Contract> contractList;

	public List<Contract> getPreContractList(String dealerId, String regionId, String groupId, String contractStatus) {

		List<Contract> source = contractList;

		if (StringUtils.isNotBlank(regionId)) {
			source = source.stream().filter((Contract contract) -> contract.getRegionId().equals(regionId))
					.collect(Collectors.toList());
		}
		if (StringUtils.isNotBlank(dealerId)) {
			source = source.stream().filter((Contract contract) -> contract.getDealerId().equals(dealerId))
					.collect(Collectors.toList());
		}
		if (StringUtils.isNotBlank(groupId)) {
			source = source.stream().filter((Contract contract) -> contract.getGroupId().equals(groupId))
					.collect(Collectors.toList());
		}
		if (StringUtils.isNotBlank(contractStatus)) {
			source = source.stream().filter((Contract contract) -> contract.getContractStatus().equals(contractStatus))
					.collect(Collectors.toList());
		}

		return source;
	}

	public int createContract(String contractId, Contract contractForm) {
		int result = BMWPocConstants.REST_SUCCESS_CODE;
		for (Contract contract : contractList) {
			if (contractId != null && contractId.equals(contract.getContractId())) {
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

	public ContractTemplate fillDataWithTemplate(String contractId, String templateId) {
		ContractTemplate template = null;
		return template;
	}

}
