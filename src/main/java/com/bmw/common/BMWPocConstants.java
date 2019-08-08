package com.bmw.common;

public class BMWPocConstants {

	private BMWPocConstants() {

	}

	public static final String ACCEPT_LANG_ZH_CH = "zh-CN";
	public static final String API_V1 = "/v1";
	public static final String API_V2 = "/v2";
	public static final String KEY_NAME_VALUE = "value";
	public static final Integer REST_ERROR_CODE = -1;
	public static final Integer REST_SUCCESS_CODE = 0;
	public static final Integer REPAIRORDER_PAGE_SIZE = 200;
	public static final String DEFAULT_JULIAN_DATE = "2458000";
	public static final String REDIS_CONTRACT_LIST_KEY = "contractList";
	public static final Integer CONTRACT_MOCK_LENGTH = 10;
	public static final String CONTRACT_STATUS_ORDERED = "O";
	public static final String CONTRACT_STATUS_CREATED = "C";
	public static final String CONTRACT_STATUS_INVOICED = "I";
}
