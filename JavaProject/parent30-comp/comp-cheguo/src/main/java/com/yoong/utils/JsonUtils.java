package com.yoong.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yoong.facade.cls.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Desc FastJson对于JSON格式字符串、JSON对象及JavaBean之间的相互转换
 * PS：FastJSON简介
 * https://www.cnblogs.com/cdf-opensource-007/p/7106018.html
 * Java的4种Json类库介绍
 * PS：四款处理json的java类库：Json-lib、Gson、Jackson、Fastjson
 * http://blog.csdn.net/moshenglv/article/details/52021263
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年1月15日
 * <p>
 * @Version 1.0
 */
public class JsonUtils {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            jsonToMap();
            toTemplateJson();
            mapToJson();
            string2JonArray();
            human2Json();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static String bean2Json(Object obj) {
        return JSON.toJSONString(obj);
    }

    public static <T> T json2Bean(String jsonStr, Class<T> objClass) {
        return JSON.parseObject(jsonStr, objClass);
    }

    public static JSONArray json2List(String jsonStr) {
        return JSON.parseArray(jsonStr);
    }

    public static void serializeObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("bcode", "registerMobile11");
        jsonObject.put("bname", "reservedMobile22");
        String jsonStr = jsonObject.toJSONString();
        System.out.println(jsonStr);
    }

    public static void deserializeObject() {
        String isRegisteredJson = "{\"customerId\":250335,\"registerNo\":\"104056\",\"linkUrl\":\"http://180.169.200.170:8239/open/account/index/KH96115244044128256\",\"registerStatus\":0,\"registerMobile\":\"15157692880\",\"globalId\":\"140103199007190043\",\"name\":\"贾壕析\"}";
        RegisterData isRegisteredResponse = JSON.parseObject(isRegisteredJson, RegisterData.class);
        System.out.println(isRegisteredResponse.getCustomerId());

        String registerResponseData = "{\"coCompanyId\":12121414,\"customerId\":121495934,\"registerNo\":\"104115\",\"registerStatus\":0,\"registerMobile\":\"13957600199\",\"globalId\":\"210782196210290069\",\"name\":\"何蕾玲\",\"reservedMobile\":\"13957600199\",\"bankAccountName\":\"何蕾玲\",\"bankAccountNo\":\"6221410006090865\",\"bankName\":\"邮政银行\",\"bankNo\":\"0100\"}";
        RegisterData registerData = JSON.parseObject(registerResponseData, RegisterData.class);
        System.out.println(registerData.getCustomerId());
    }

    public static void jsonToMap() {

        JSONObject dataObj = new JSONObject();
        dataObj.put("status", "status 11");
        dataObj.put("registerMobile", "registerMobile 22");
        dataObj.put("globalId", "globalId 33");
        dataObj.put("name", "name 44");
        dataObj.put("reservedMobile", "reservedMobile 55");

        JSONObject responseObj = new JSONObject();
        responseObj.put("code", "code code");
        responseObj.put("msg", "msg msg");
        responseObj.put("data", dataObj);

        String responseStr = responseObj.toJSONString();
        System.out.println(responseStr);

        QueryResponse queryResponse = JSON.parseObject(responseStr, QueryResponse.class);
        System.out.println(queryResponse.getCode());

        QueryData data = queryResponse.getData();
        String dataJson = JSON.toJSONString(data);
        System.out.println(dataJson);

        Map maps = (Map) JSON.parse(responseStr);
        Map data2 = (Map) maps.get("data");
        String status = (String) data2.get("status");
        System.out.println(data2);
        System.out.println(status);
    }

    public static void toTemplateJson() {
        ContractConfig contractConfig = new ContractConfig();
        contractConfig.setTemplateName("征信调查授权书 2人签");
        contractConfig.setTemplateNo("HT_1120");

        List<ContractSignParty> partys = new ArrayList<ContractSignParty>();
        ContractSignParty contractSignParty1 = new ContractSignParty();
        contractSignParty1.setUserType("0");
        contractSignParty1.setIdentityNo("330381198707105912");
        contractSignParty1.setUserName("张三");
        contractSignParty1.setMobileNo("15305872206");
        contractSignParty1.setSignLocation("Signature1");
        partys.add(contractSignParty1);
        ContractSignParty contractSignParty2 = new ContractSignParty();
        contractSignParty2.setUserType("1");
        contractSignParty2.setIdentityNo("78945212345678");
        contractSignParty2.setUserName("李四");
        contractSignParty2.setMobileNo("18977889953");
        contractSignParty1.setSignLocation("Signature2");
        partys.add(contractSignParty2);
        contractConfig.setContarctSignPartys(partys);

        Map<String, String> data = new HashMap<String, String>();
        data.put("1", "init_contract_no");
        data.put("2", "payableAmount");
        data.put("3", "year");
        data.put("4", "month");
        data.put("5", "day");
        data.put("6", "customer_name");
        contractConfig.setData(data);

        String templateJson = JSON.toJSONString(contractConfig);

        ContractConfig contractConfig2 = JSON.parseObject(templateJson, ContractConfig.class);
        System.out.println(templateJson);
    }

    public static void mapToJson() {
        Map<String, String> bankMap = new HashMap<String, String>();
        bankMap.put("0100", "邮政储蓄银行");
        bankMap.put("0103", "农业银行");
        bankMap.put("0104", "中国银行");
        bankMap.put("0105", "建设银行");
        bankMap.put("0301", "交通银行");
        String result = JSON.toJSONString(bankMap);
        System.out.println(result);

        JSONObject bankMap2 = JSON.parseObject(result);
        String value = bankMap2.get("0100").toString();
        System.out.println(value);

        List<Map<String, String>> bankList = new ArrayList<Map<String, String>>();
        for (Map.Entry<String, String> entry : bankMap.entrySet()) {
            Map<String, String> bank = new HashMap<String, String>();
            bank.put("value", entry.getKey());
            bank.put("text", entry.getValue());
            bankList.add(bank);
        }
        String jsonStr = JSON.toJSONString(bankList);
        System.out.println(jsonStr);
    }

    private static void string2JonArray() {
        String jsArr = "[1288,1289]";
        JSONArray jsonArr = JSONArray.parseArray(jsArr);
        jsonArr.forEach(item -> System.out.println(item));
    }

    private static void human2Json() {
        Human human = new Human();
        human.setName("name 1");
        human.setAge(100);
        String json = JSON.toJSONString(human);
        System.out.println(json);
        Human man = (Human) JSON.parse(json);
        System.out.println(man.getAge());
    }
}
