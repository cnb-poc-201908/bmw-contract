package com.bmw.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bmw.entity.response.RestResponse;
import com.bmw.model.Contract;
import com.bmw.service.ContractService;

@RestController
@RequestMapping("/pre-contracts")
public class ContractController {

	private static Logger logger = LoggerFactory.getLogger(ContractController.class);

	@Autowired
	private ContractService contractService;

	@GetMapping(value = "", produces = "application/json")
	public RestResponse<List<Contract>> getPreContract(
			@RequestParam(value = "dealerId", required = false) String dealerId,
			@RequestParam(value = "regionId", required = false) String regionId,
			@RequestParam(value = "groupId", required = false) String groupId) {

		logger.info("get ungenerated contract list");
		List<Contract> contractList = contractService.getcontractList(dealerId, regionId, groupId);
		RestResponse<List<Contract>> response = new RestResponse<>();
		response.setData(contractList);
    	return response;
	}
}

