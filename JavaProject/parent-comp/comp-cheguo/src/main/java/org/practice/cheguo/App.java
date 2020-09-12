package org.practice.cheguo;

import com.alibaba.fastjson.JSON;
import com.yoong.facade.cls.model.Human;
import org.practice.cheguo.api.dto.StageOrderDto;
import org.practice.cheguo.api.request.CreateTemplateReq;
import org.practice.cheguo.domain.ApproveFeeModParam;
import org.practice.cheguo.domain.EbizFeeInfo;
import org.springframework.beans.BeanUtils;

import javax.validation.Validation;
import javax.validation.Validator;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Desc App
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年1月15日
 * <p>
 * @Version 1.0
 */
public class App {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            streamSort();
            validate();
            parseObject();
            urlEncodeDemo();
            copy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * JAVA8-用lamda表达式和增强版Comparator进行排序
     * https://blog.csdn.net/gao1440156051/article/details/71126194
     */
    public static void streamSort() {
        Date now = new Date();
        List<Human> humans = new ArrayList<>();
        humans.add(new Human("Sarah", 10, new Date()));
        humans.add(new Human("Jack", 12, new Date()));
        humans.add(new Human("Tomy", 11, new Date()));
        humans.add(new Human("Tomy", 11, new Date()));

//		Collections.sort(humans, Comparator.comparing(Human::getCreateDate));
//		humans = humans.stream().sorted(Comparator.comparing(Human::getCreateDate)).collect(Collectors.toList());
//		humans = humans.stream().sorted(Comparator.comparing(Human::getCreateDate).reversed()).collect(Collectors.toList());
//		Human theOne = humans.stream().sorted(Comparator.comparing(Human::getCreateDate).reversed()).findFirst().get();
//		Human theOne2 = humans.stream().sorted(Comparator.comparing(Human::getCreateDate).reversed()).findFirst().orElse(null);
        int size = humans.size();

        List<Human> distinctHumans = humans.stream().distinct().collect(Collectors.toList());
        int size2 = distinctHumans.size();
        distinctHumans.forEach(item -> {
            System.out.println(item.getName() + " - " + item.getAge() + " - " + item.getCreateDate());
        });
        System.out.println(size2);
    }

    public static void validate() {
        try {
            //Validator validator=new SpringValidatorAdapter;
            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            CreateTemplateReq req = new CreateTemplateReq();
            req.setContractName("contractName");
            validator.validate(req, CreateTemplateReq.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void parseObject() {
        try {
            String stageOrderDtoStr = "{\"username\":\"关飞章\",\"sex\":\"1\",\"nationality\":\"汉\",\"address\":\"杭州市江干区凤起东路189号\",\"cardid\":\"441302198901032025\",\"certAuthority\":\"南宁市公安局青秀分局\",\"cardStartValidtime\":\"2005-5-5\",\"cardEndValidtime\":\"2025-5-5\",\"cardValid\":\"1\",\"phone\":\"19999999999\",\"bankCardid\":\"6226223400443399\",\"dealerId\":\"1\",\"dealerName\":\"刘增测试车商有限公司\",\"orderType\":\"1\",\"carType\":\"1\",\"carEstimatePrice\":96789.32,\"orderStatus\":\"0\",\"creditResult\":\"0\",\"recommit\":\"0\",\"cardImageHead\":\"http://hjhjkh.oss-cn-hangzhou.aliyuncs.comign-test/1583733549219-1159313293.jpg\",\"cardImageEmblem\":\"http://hjhjkh.oss-cn-hangzhou.aliyuncs.comign-test/1583733565461-1517244937.jpg\",\"holdingImage\":\"http://hjhjkh.oss-cn-hangzhou.aliyuncs.comign-test/1583733565461-1517244937.jpg\",\"portraitImage\":\"http://hjhjkh.oss-cn-hangzhou.aliyuncs.comign-test/1583733565461-1517244937.jpg\",\"remark\":\"remark-2020年6月8日14:14:47\",\"relaterDtoList\":[{\"username\":\"郜慕凝\",\"sex\":\"0\",\"phone\":\"18888888888\",\"cardid\":\"14102919940113994X\",\"bankCardid\":\"6226223400443398\",\"relationship\":\"2\",\"cardImageHead\":\"http://hjhjkh.oss-cn-hangzhou.aliyuncs.comign-test/1583733549219-1159313293.jpg\",\"cardImageEmblem\":\"http://hjhjkh.oss-cn-hangzhou.aliyuncs.comign-test/1583733565461-1517244937.jpg\",\"holdingImage\":\"http://hjhjkh.oss-cn-hangzhou.aliyuncs.comign-test/1583733565461-1517244937.jpg\",\"creditAuthImage\":\"http://hjhjkh.oss-cn-hangzhou.aliyuncs.comign-test/1583733565461-1517244937.jpg\"},{\"username\":\"蓬增侠\",\"sex\":\"1\",\"phone\":\"17777777777\",\"cardid\":\"530702201509076397\",\"bankCardid\":\"6226223400443397\",\"relationship\":\"3\",\"cardImageHead\":\"http://hjhjkh.oss-cn-hangzhou.aliyuncs.comign-test/1583733549219-1159313293.jpg\",\"cardImageEmblem\":\"http://hjhjkh.oss-cn-hangzhou.aliyuncs.comign-test/1583733565461-1517244937.jpg\",\"holdingImage\":\"http://hjhjkh.oss-cn-hangzhou.aliyuncs.comign-test/1583733565461-1517244937.jpg\",\"creditAuthImage\":\"http://hjhjkh.oss-cn-hangzhou.aliyuncs.comign-test/1583733565461-1517244937.jpg\"},{\"username\":\"强凝丹\",\"sex\":\"1\",\"phone\":\"16666666666\",\"cardid\":\"433101200304229113\",\"bankCardid\":\"6226223400443396\",\"relationship\":\"4\",\"cardImageHead\":\"http://hjhjkh.oss-cn-hangzhou.aliyuncs.comign-test/1583733549219-1159313293.jpg\",\"cardImageEmblem\":\"http://hjhjkh.oss-cn-hangzhou.aliyuncs.comign-test/1583733565461-1517244937.jpg\",\"holdingImage\":\"http://hjhjkh.oss-cn-hangzhou.aliyuncs.comign-test/1583733565461-1517244937.jpg\",\"creditAuthImage\":\"http://hjhjkh.oss-cn-hangzhou.aliyuncs.comign-test/1583733565461-1517244937.jpg\"}]}";
            StageOrderDto stageOrderDto = JSON.parseObject(stageOrderDtoStr, StageOrderDto.class);
            System.out.println(stageOrderDto.getSex());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void urlEncodeDemo() {
        String dubboParams = "{\"username\":\"蒲致远\",\"orderStatus\":\"1\",\"creditResult\":\"1\"}";
        String urlEncodeResult = URLEncoder.encode(dubboParams);
        System.out.println(urlEncodeResult);
        String urlDecodeResult = URLDecoder.decode(urlEncodeResult);
        System.out.println(urlDecodeResult);
    }

    public static void copy() {
        String approveGuaParamStr = "{\"accidentInsurance\":\"0\",\"approveNodeId\":\"22\",\"basicRate\":8.9,\"billingPrice\":\"100000\",\"bizType\":\"1\",\"carLoanAmount\":\"50000\",\"companyId\":9,\"companyName\":\"测试车商\",\"dealerRateLower\":\"12\",\"dealerServiceFeeAmount\":\"0\",\"dealerServiceFeeRate\":\"0\",\"decorateAmount\":\"0\",\"downpaymentAmount\":50000,\"downpaymentRate\":50,\"extraFeeAmount\":3259.87,\"extraFeeRate\":3.26,\"extraHandingFee\":290.13,\"feeCalcType\":1,\"guaranteeServiceFee\":3259.87,\"handingFeeRate\":\"16.00\",\"hasPurchaseTax\":0,\"installmentAmount\":53259.87,\"installmentHandingFee\":4740.13,\"insuranceAmount\":\"0\",\"loanAmount\":\"50000.00\",\"loanRatio\":50,\"loanTerm\":\"12\",\"monthlySupply\":1611.11,\"orderNo\":\"BIZ6571262424284600418\",\"productCode\":\"LOAN001\",\"productName\":\"信用卡分期（普通模式）\",\"purchaseTax\":\"0\",\"serviceFeeUpRate\":\"4\",\"totalRepayAmount\":58000}";
        ApproveFeeModParam approveFeeModParam = JSON.parseObject(approveGuaParamStr, ApproveFeeModParam.class);
        EbizFeeInfo feeInfo = new EbizFeeInfo();
        BeanUtils.copyProperties(approveFeeModParam, feeInfo);
        System.out.println(feeInfo);
    }
}
