package org.practice.cheguo;

import com.alibaba.fastjson.JSONObject;

public class JsonUtility {

	public static void main(String[] args) {

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

}
