package org.practice.cheguo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.practice.cheguo.model.ContractConfig;
import org.practice.cheguo.model.ContractSignParty;
import org.practice.cheguo.model.QueryData;
import org.practice.cheguo.model.QueryResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * https://www.cnblogs.com/cdf-opensource-007/p/7106018.html Json工具类
 * http://blog.csdn.net/moshenglv/article/details/52021263
 * 
 * @author 20180112002
 *
 */
public class JsonUtility {

	public static void main(String[] args) {

		// json();
		// jsonToMap();
		toTemplateJson();
	}

	public static void json() {
		JSONObject isRegisteredObj = new JSONObject();
		isRegisteredObj.put("registerMobile", "registerMobile11");
		isRegisteredObj.put("reservedMobile", "reservedMobile22");
		isRegisteredObj.put("globalType", "globalType33");
		isRegisteredObj.put("globalId", "globalId44");
		isRegisteredObj.put("realName", "realName55");
		isRegisteredObj.put("bankAccountNo", "bankAccountNo66");
		isRegisteredObj.put("userId", "userId77");
		isRegisteredObj.put("channel", "channel88");
		isRegisteredObj.put("reqSn", "reqSn99");
		String jsonStr = isRegisteredObj.toJSONString();
		System.out.println(jsonStr);
	}

	public static void jsonToMap() {

		JSONObject dataObj = new JSONObject();
		dataObj.put("status", "status 11");
		dataObj.put("registerMobile", "registerMobile 22");
		dataObj.put("globalId", "globalId 33");
		dataObj.put("name", "name 44");
		dataObj.put("reservedMobile", "reservedMobile 55");
		dataObj.put("bankAccountName", "bankAccountName 66");
		dataObj.put("bankAccountNo", "bankAccountNo 77");
		dataObj.put("bankName", "bankName 88");
		dataObj.put("bankNo", "bankNo 99");

		JSONObject isRegisteredObj = new JSONObject();
		isRegisteredObj.put("code", "code code");
		isRegisteredObj.put("msg", "msg msg");
		isRegisteredObj.put("data", dataObj);

		String jsonStr = isRegisteredObj.toJSONString();
		System.out.println(jsonStr);

		QueryResponse response = JSON.parseObject(jsonStr, QueryResponse.class);
		System.out.println(response.getCode());

		QueryData data = response.getData();
		String dataJson = JSON.toJSONString(data);
		System.out.println(dataJson);

		// Map maps = (Map) JSON.parse(jsonStr);
		// Map data = (Map) maps.get("data");
		// String status = (String) data.get("status");
		// System.out.println(data);
		// System.out.println(status);
	}

	public static void toTemplateJson() {
		ContractConfig contractConfig = new ContractConfig();
		//contractTemplate.setTemplateName("征信调查授权书 2人签");
		//contractTemplate.setTemplateNo("QT_579");
		contractConfig.setTemplateName("征信调查授权书 2人签");
		contractConfig.setTemplateNo("JK_1180");

		List<ContractSignParty> partys = new ArrayList<ContractSignParty>();
		ContractSignParty contractSignParty1 = new ContractSignParty();
		contractSignParty1.setUserType("0");
		contractSignParty1.setIdentityNo("330381198707105912");
		contractSignParty1.setUserName("狄诒丰");
		contractSignParty1.setMobileNo("15305872206");
		partys.add(contractSignParty1);

		ContractSignParty contractSignParty2 = new ContractSignParty();
		contractSignParty2.setUserType("1");
		contractSignParty2.setIdentityNo("78945212345678");
		contractSignParty2.setUserName("车国测试专用");
		contractSignParty2.setMobileNo("18977889953");
		partys.add(contractSignParty2);

		contractConfig.setContarctSignPartys(partys);

		String templateJson = JSON.toJSONString(contractConfig);
		System.out.println(templateJson);
	}

	public static String bean2Json(Object obj) {
		return JSON.toJSONString(obj);
	}

	public static <T> T json2Bean(String jsonStr, Class<T> objClass) {
		return JSON.parseObject(jsonStr, objClass);
	}
}
