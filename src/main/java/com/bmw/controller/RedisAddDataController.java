package com.bmw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bmw.common.BMWPocConstants;
import com.bmw.data.ContractDataBuilder;
import com.bmw.model.Contract;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/redis")
public class RedisAddDataController {
	@Autowired
	RedisTemplate<String, String> redisTemplate;

	@GetMapping(value = "", produces = "application/json")
	public List<Contract> helloWorld() throws Exception {

		// start set data into redis
		ValueOperations<String, String> ops = redisTemplate.opsForValue();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		List<Contract> list = ContractDataBuilder.buildcontractList();
		ops.set(BMWPocConstants.REDIS_CONTRACT_LIST_KEY, objectMapper.writeValueAsString(list));
		// end set data into redis
		return objectMapper.readValue(ops.get(BMWPocConstants.REDIS_CONTRACT_LIST_KEY),
				new TypeReference<List<Contract>>() {
				});
	}
}
