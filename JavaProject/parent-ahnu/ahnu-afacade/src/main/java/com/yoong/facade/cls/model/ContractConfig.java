package com.yoong.facade.cls.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @Desc ContractConfig
 * <p>
 * @Author 20180112002
 * <p>
 * @Date 2018-01-15 09:00:00
 * <p>
 * @Version 1.0
 */
@Data
public class ContractConfig {

    /**
     * 合同模板名称
     */
    private String templateName;

    /**
     * 合同模板编号
     */
    private String templateNo;

    /**
     * 合同签署方列表
     */
    private List<ContractSignParty> contarctSignPartys;

    /**
     * 参数配置
     */
    private Map<String, String> data;
}
