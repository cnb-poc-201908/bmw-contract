package com.bmw.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.bmw.common.BMWPocConstants;
import com.bmw.model.BasicInfo;
import com.bmw.model.Contract;
import com.bmw.model.CustomerInfo;
import com.bmw.utils.DateUtil;
import com.github.javafaker.Faker;

public class ContractDataBuilder {
	private static String[] dealerIds = new String[] { "DL-10006661", "D-10006662", "D-10006663", "D-10006664" };
	private static String[] groupIds = new String[] { "GP-10001", "GP-10002", "GP-10003" };
	private static String[] regionIds = new String[] { "RG-10001", "RG-10002" };
	private static String[] dealerNames = new String[] { "北京京宝行汽车服务有限公司", "北京博瑞宝汽车销售服务有限公司", "深圳博瑞宝汽车销售服务有限公司",
			"广州博瑞宝汽车销售服务有限公司" };
	private static String[] groupNames = new String[] { "京宝行集团", "博瑞宝集团", "宝马销售集团" };
	private static String[] regionNames = new String[] { "华北区", "华南区" };

	private static String[] contractStatus = new String[] { "I", "C", "O" };

	private static LocalDate now = LocalDate.now();
	private static String dateString = DateUtil.dateToBasicISODate(now);
	private static String[] salesPersonId = new String[] { "S023933", "S065754", "S066778" };

	private ContractDataBuilder() {

	}

	public static List<Contract> buildcontractList() {
		List<Contract> contractList = getInitContractList();
		List<CustomerInfo> cInfoList = getCustomerInfoList();
		List<BasicInfo> bInfoList = getBasicInfoList();

		for (int i = 0; i < contractList.size(); i++) {
			Contract c = contractList.get(i);
			CustomerInfo cInfo = cInfoList.get(i);
			BasicInfo bInfo = bInfoList.get(i);

			c.setCustomerInfo(cInfo);
			c.setBasicInfo(bInfo);
		}

		return contractList;
	}

	private static List<BasicInfo> getBasicInfoList() {
		List<BasicInfo> bInfoList = new ArrayList<BasicInfo>();

		for (int i = 0; i < BMWPocConstants.CONTRACT_MOCK_LENGTH * 12; i++) {
			BasicInfo b = new BasicInfo();
			// 订单号 orderNumber
			b.setOrderNumber("O" + String.format("%012d", 3537 * (i + 1)));
			// 订单日期 orderDate
			b.setOrderDate(DateUtil.dateToString(now.minusDays(i * 6 + 10L)));
			// 发票账户 invoiceNumber
			b.setInvoiceNumber("I" + String.format("%010d", 4235 * (i + 1)));
			// 发票日期 invoiceDate

			// 车架号 chassisNumber DUX20190802TEST01
			b.setChassisNumber("DUX" + dateString + "TEST" + String.format("%02d", i));
			// 销售员ID salesPersonId
			b.setSalesPersonId(salesPersonId[i % 3]);
			// 预计交付日期 deliveryDate
			b.setDeliveryDate(DateUtil.dateToString(now.minusDays(i * 5 + 1L)));
			// 发票总金额 InvoiceTotal
			b.setInvoiceTotal(300000 + i * 25000d);
			bInfoList.add(b);
		}

		return bInfoList;
	}

	private static List<CustomerInfo> getCustomerInfoList() {
		List<CustomerInfo> cInfoList = new ArrayList<CustomerInfo>();
		Faker faker = new Faker(new Locale("zh-CN"));

		for (int i = 0; i < BMWPocConstants.CONTRACT_MOCK_LENGTH * 12; i++) {
			CustomerInfo c = new CustomerInfo();
			// 客户ID
			c.setCustomerId("CID" + String.format("%06d", 537 * (i + 1)));
			// 客户姓名
			c.setCustomerName(faker.name().fullName());
			// 客户地址
			c.setCustomerAddress(faker.address().city() + faker.address().streetAddress());
			// 客户联系方式
			c.setCustomerContact(faker.phoneNumber().cellPhone());

			cInfoList.add(c);
		}
		return cInfoList;
	}

	private static List<Contract> getInitContractList() {
		// mock init contract list
		List<Contract> cList = new ArrayList<>();

		for (int k = 0; k < dealerIds.length; k++) {
			for (int j = 0; j < contractStatus.length; j++) {
				for (int i = 0; i < BMWPocConstants.CONTRACT_MOCK_LENGTH; i++) {
					String contractId = "CT" + dateString + String.format("%06d", 1437 * (i + j + k + 1));
					String processCode = contractStatus[j];

					Contract c = new Contract();
					c.setContractId(contractId);
					c.setProcessCode(processCode);
					c.setContractStatus(contractStatus[j]);

					c.setDealerId(dealerIds[k]);
					c.setDealerName(dealerNames[k]);

					if (k == 0 || k == 1) {
						c.setGroupId(groupIds[0]);
						c.setGroupName(groupNames[0]);

						c.setRegionId(regionIds[0]);
						c.setRegionName(regionNames[0]);
					}

					if (k == 2) {
						c.setGroupId(groupIds[1]);
						c.setGroupName(groupNames[1]);

						c.setRegionId(regionIds[1]);
						c.setRegionName(regionNames[1]);
					}

					if (k == 3) {
						c.setGroupId(groupIds[2]);
						c.setGroupName(groupNames[2]);

						c.setRegionId(regionIds[1]);
						c.setRegionName(regionNames[1]);
					}
					cList.add(c);
				}
			}
		}

		return cList;
	}
}