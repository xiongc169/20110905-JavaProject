package com.yoong.facade.cls.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 合同的配置类
 *
 * @author yoong
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
