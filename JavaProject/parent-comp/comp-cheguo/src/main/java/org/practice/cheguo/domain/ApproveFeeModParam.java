package org.practice.cheguo.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Desc 业务审批-费用信息 修改入参类
 * @Auth xc
 * @Date 2020-8-14
 * @Version 1.0
 */
@Data
public class ApproveFeeModParam implements Serializable {

    private static final long serialVersionUID = 814403651754118500L;

    //开票价
    private BigDecimal billingPrice;
    //车辆贷款金额
    private BigDecimal carLoanAmount;
    //是否融购置税：0 否，1是
    private Integer hasPurchaseTax;
    //购置税
    private BigDecimal purchaseTax;
    //车辆盗抢服务费
    private BigDecimal decorateAmount;
    //保险金额
    private BigDecimal insuranceAmount;
    //人身意外险
    private BigDecimal accidentInsurance;
    //贷款金额
    private BigDecimal loanAmount;
    //手续费率
    private BigDecimal handingFeeRate;
    //服务费计算方式：1 无需返利，2 按贷款总额，3 按车辆贷款额
    private Integer feeCalcType;
    //车商保底费率
    private BigDecimal dealerRateLower;
    //服务费上浮费率
    private BigDecimal serviceFeeUpRate;
    //车商服务费比例
    private BigDecimal dealerServiceFeeRate;
    //车商服务费金额
    private BigDecimal dealerServiceFeeAmount;
    //首付金额
    private BigDecimal downpaymentAmount;
    //首付比例
    private BigDecimal downpaymentRate;
    //分期金额
    private BigDecimal installmentAmount;
    //附加费金额
    private BigDecimal extraFeeAmount;
    //附加费比例
    private BigDecimal extraFeeRate;
    //参考月供
    private BigDecimal monthlySupply;
    //贷款比例
    private BigDecimal loanRatio;
    //分期手续费
    private BigDecimal installmentHandingFee;
    //附加费手续费
    private BigDecimal extraHandingFee;
    //担保服务费
    private BigDecimal guaranteeServiceFee;
    //应还总额
    private BigDecimal totalRepayAmount;
}
