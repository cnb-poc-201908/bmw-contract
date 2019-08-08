package com.bmw.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import com.bmw.common.BMWPocConstants;
import com.bmw.model.BasicInfo;
import com.bmw.model.Contract;
import com.bmw.model.CustomerInfo;
import com.bmw.utils.DateUtil;
import com.github.javafaker.Faker;

public class ContractDataBuilder {

	private ContractDataBuilder() {

	}

	public static List<Contract> buildcontractList() {	
		List<Contract> contractList = getInitContractList();
		List<CustomerInfo> cInfoList = getCustomerInfoList();
		List<BasicInfo> bInfoList = getBasicInfoList();	
		
		for (int i = 0; i <contractList.size(); i++) {
			CustomerInfo cInfo = cInfoList.get(i);
			contractList.get(i).setCustomerInfo(cInfo);
		}

		return contractList;
	}

	private static List<BasicInfo> getBasicInfoList() {
		// TODO Auto-generated method stub
		return null;
	}

	private static List<CustomerInfo> getCustomerInfoList() {
		List<CustomerInfo> cInfoList = new ArrayList<CustomerInfo>();
		Faker faker = new Faker(new Locale("zh-CN"));
		
		for (int i = 0; i < BMWPocConstants.CONTRACT_MOCK_LENGTH*3; i++) {
			CustomerInfo c = new CustomerInfo();
			c.setCustomerName(faker.name().fullName());
			c.setCustomerAddress(faker.address().city()+faker.address().streetAddress());
			c.setCustomerContact(faker.phoneNumber().cellPhone());
			
			cInfoList.add(c);
		}
		return cInfoList;
	}

	private static List<Contract> getInitContractList() {
		//mock init contract list
		List<Contract> cList = new ArrayList<>();
		Random random = new Random();
		
		String[] contractStatus = new String[] {"I","C","O"};
		
		for (String cStatus : contractStatus) {
			for (int i = 0; i < BMWPocConstants.CONTRACT_MOCK_LENGTH ; i++) {
				String contractNumber = "CT"+DateUtil.dateToBasicISODate(LocalDate.now())+random.nextInt(10000);
				String processStatus = cStatus;
				cList.add(new Contract(contractNumber,processStatus,cStatus));
			}
		}
		
		return cList;
	}
}