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

		for (int i = 0; i < BMWPocConstants.CONTRACT_MOCK_LENGTH * 3; i++) {
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

		for (int i = 0; i < BMWPocConstants.CONTRACT_MOCK_LENGTH * 3; i++) {
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

		String[] contractStatus = new String[] { "I", "C", "O" };

		for (String cStatus : contractStatus) {
			for (int i = 0; i < BMWPocConstants.CONTRACT_MOCK_LENGTH; i++) {
				String contractNumber = "CT" + dateString + String.format("%06d", 437 * (i + 1));
				String processStatus = cStatus;
				cList.add(new Contract(contractNumber, processStatus, cStatus));
			}
		}

		return cList;
	}
}