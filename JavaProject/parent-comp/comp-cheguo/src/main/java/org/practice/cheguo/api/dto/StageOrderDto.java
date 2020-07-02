package org.practice.cheguo.api.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Desc 分期管理-提单入参类
 * @Auth xc
 * @Date 2020-6-30
 */
@Data
public class StageOrderDto implements Serializable {

    private static final long serialVersionUID = -3503777074134942485L;

    /**
     * 姓名
     */
    private String username;

    /**
     * 性别：0 女，1 男
     */
    private Integer sex;

    /**
     * 民族
     */
    private String nationality;

    /**
     * 住址
     */
    private String address;

    /**
     * 身份证号
     */
    private String cardid;

    /**
     * 签发机关
     */
    private String certAuthority;

    /**
     * 证件有效期开始日期
     */
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date cardStartValidtime;

    /**
     * 证件有效期结束日期
     */
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date cardEndValidtime;

    /**
     * 证件是否长期有效 0:否,1:是
     */
    private Integer cardValid;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 银行卡号
     */
    private String bankCardid;

    private Long dealerId;

    /**
     * 车商名称
     */
    private String dealerName;

    /**
     * 提单类型：1 电子提单，2 纸质提单，见 OrderTypeEnum
     */
    private Integer orderType;

    /**
     * 汽车类型：1 新车，2 二手车
     */
    private Integer carType;

    /**
     * 预估车价
     */
    private BigDecimal carEstimatePrice;

    /**
     * 订单状态：1 查询中，2 查询成功，3 订单关闭，见 OrderStatusEnum
     */
    private Integer orderStatus;

    /**
     * 征信结果：1 征信查询中，2 征信通过，3 征信不通过，见 CreditResultEnum
     */
    private Integer creditResult;

    /**
     * 是否展示重新提交：0 不展示，1 展示
     */
    private Integer recommit = 0;

    /**
     * 身份证头像照
     */
    private String cardImageHead;

    /**
     * 身份证国徽照
     */
    private String cardImageEmblem;

    /**
     * 手持身份证照
     */
    private String holdingImage;

    /**
     * 客户人像照
     */
    private String portraitImage;

    /**
     * 征信授权书
     */
    private String creditAuthImage;

    /**
     * 备注
     */
    private String remark;

    /**
     * 关联人
     */
    private List<StageRelaterDto> relaterDtoList;

    @Data
    public static class StageRelaterDto implements Serializable {

        private static final long serialVersionUID = -9028918184071640189L;

        /**
         * 姓名
         */
        private String username;

        /**
         * 性别：0 女，1 男
         */
        private Integer sex;

        /**
         * 手机号
         */
        private String phone;

        /**
         * 身份证号
         */
        private String cardid;

        /**
         * 银行卡号
         */
        private String bankCardid;

        /**
         * 担保人与借款人关系： 见 GuaRelationshipEnum
         * 2：配偶，3：父亲，4：母亲，5：姐妹，6：兄弟，7：儿子，8：亲戚，9：朋友，10：合伙人，11：同事，12：女儿，13：姐夫，14：嫂子，15：儿媳
         */
        private Integer relationship;

        /**
         * 身份证头像照
         */
        private String cardImageHead;

        /**
         * 身份证国徽照
         */
        private String cardImageEmblem;

        /**
         * 手持身份证照
         */
        private String holdingImage;

        /**
         * 客户人像照
         */
        private String portraitImage;

        /**
         * 征信授权书
         */
        private String creditAuthImage;
    }
}
