package com.bmw.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bmw.entity.response.RestResponse;
import com.bmw.model.Contract;
import com.bmw.service.ContractService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/contracts")
@Api(description = "BMW微服务平台合同管理接口")
public class ContractController {

	private static Logger logger = LoggerFactory.getLogger(ContractController.class);

	@Autowired
	private ContractService contractService;

	@GetMapping(value = "", produces = "application/json")
	@ApiOperation(value = "合同列表信息查询")
	public RestResponse<List<Contract>> getPreContract(
			@RequestParam(value = "dealerId", required = false) String dealerId,
			@RequestParam(value = "regionId", required = false) String regionId,
			@RequestParam(value = "groupId", required = false) String groupId,
			@RequestParam(value = "contractStatus", required = false) String contractStatus) {

		logger.info("get ungenerated contract list");
		List<Contract> contractList = contractService.getPreContractList(dealerId, regionId, groupId,contractStatus);
		RestResponse<List<Contract>> response = new RestResponse<>();
		response.setData(contractList);
    	return response;
	}

	@PutMapping(value = "/{contractId}", produces = "application/json")
	@ApiOperation(value = "创建合同")
	public RestResponse<Object> createContract(
			@RequestBody Contract conntract,
			@PathVariable(value = "contractId", required = false) String contractId) {

		RestResponse<Object> response = new RestResponse<>();
		logger.info("enter createContract with param contractId:{}", contractId);
		response.setCode(contractService.createContract(contractId, conntract));
		return response;
	}
}

