package com.yoong.junior.community.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Desc 诉讼类型的枚举类 —— liancheng: 20180830-riskmanagersystem
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年9月6日
 * <p>
 * @Version 1.0
 */
public enum LitigationTypeEnum {

    COMPANY_LITIGATION(1, "公司诉讼"),
    BANK_LITIGATION(2, "银行诉讼");

    private Integer code;

    private String name;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    LitigationTypeEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static LitigationTypeEnum get(int code) {
        LitigationTypeEnum litigationType = Stream.of(LitigationTypeEnum.values()).filter(item -> item.getCode() == code).findAny().orElse(null);
        return litigationType;
    }

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            LitigationTypeEnum companyLitigation = LitigationTypeEnum.valueOf("COMPANY_LITIGATION");
            List<LitigationTypeEnum> litigationTypes = Arrays.asList(LitigationTypeEnum.values());
            int code = litigationTypes.get(0).getCode();
            String name = litigationTypes.get(0).getName();
            String enumName = litigationTypes.get(0).toString();

            System.out.println(companyLitigation);
            System.out.println(litigationTypes);
            System.out.println(name);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
