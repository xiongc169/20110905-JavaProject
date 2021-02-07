package com.yoong.springfx.domain2;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @Desc ContractBaseConfig
 * <p>
 * @Author yoong
 * <p>
 * @Date 2014年3月30日
 * <p>
 * @Version 1.0
 */
@Data
@Component
public class ContractBaseConfig {

    private String contractCode;

    private String contractName;

    private String orgCode;

    private String appId;

    //是否删除：0 未删除，1 已删除
    private Integer isDelete;
}
