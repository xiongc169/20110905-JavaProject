package org.practice.cheguo;

import java.util.Map;

import org.practice.cheguo.model.QueryResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * https://www.cnblogs.com/cdf-opensource-007/p/7106018.html Json工具类
 * 
 * @author 20180112002
 *
 */
public class JsonUtility {

	public static void main(String[] args) {

		// json();
		jsonToMap();
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

		// Map maps = (Map) JSON.parse(jsonStr);
		// Map data = (Map) maps.get("data");
		// String status = (String) data.get("status");
		// System.out.println(data);
		// System.out.println(status);
	}

}
