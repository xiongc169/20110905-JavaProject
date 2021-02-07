package com.yoong.chesheng.api.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @Desc 创建合同模板入参类
 * <p>
 * @Author xc
 * <p>
 * @Date 2020年5月12日
 * <p>
 * @Version 1.0
 */
@Data
public class CreateTemplateReq implements Serializable {

    //模版名称
    @NotBlank(message = "contractName不能为空")
    private String contractName;

    //模版编号
    @NotBlank(message = "contractCode不能为空")
    private String contractCode;

    //模版内容
    @NotNull(message = "contractPdf不能为空")
    @JSONField(serialize = false)
    private byte[] contractPdf;

    //模版配置
    private List<TemplateConfig> templateConfigList;

    /**
     * 合同模板配置类
     */
    @Data
    public static class TemplateConfig implements Serializable {

        //文本域/签名域
        private String fieldId;
        //参数名称
        private String fieldName;
        //参数类型：1 填充域，2 签名域
        private Integer fieldType;
        //鉴权方式：1 无需鉴权，2 短信鉴权(三/四要素+短信)， 3 活体鉴权(三/四要素+(活体+人脸)+短信）
        private Integer sealAuthType;
        //签章策略：6 密钥证书，8 场景证书
        private Integer sealStrategy;
        //是否手写签名：0 否，1 是，默认否
        private Integer isHandwriting = 0;
        //说明
        private String remark;
    }
}
