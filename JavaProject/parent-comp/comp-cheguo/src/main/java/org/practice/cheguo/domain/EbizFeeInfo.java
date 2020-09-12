package org.practice.cheguo.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class EbizFeeInfo implements Serializable {
    private static final long serialVersionUID = -2607943329091063522L;
    private Integer id;

    private Date createDate;

    private Date modifyDate;

    private Integer approveNodeId;

    private BigDecimal billingPrice;

    private BigDecimal carLoanAmount;

    private Integer hasPurchaseTax;

    private BigDecimal purchaseTax;

    private BigDecimal decorateAmount;

    private BigDecimal insuranceAmount;

    private BigDecimal accidentInsurance;

    private BigDecimal loanAmount;

    private BigDecimal handingFeeRate;

    private Integer feeCalcType;

    private BigDecimal dealerRateLower;

    private BigDecimal serviceFeeUpRate;

    private BigDecimal dealerServiceFeeRate;

    private BigDecimal dealerServiceFeeAmount;

    private BigDecimal downpaymentAmount;

    private BigDecimal downpaymentRate;

    private BigDecimal installmentAmount;

    private BigDecimal extraFeeAmount;

    private BigDecimal extraFeeRate;

    private BigDecimal monthlySupply;

    private BigDecimal loanRatio;

    private BigDecimal installmentHandingFee;

    private BigDecimal extraHandingFee;

    private BigDecimal guaranteeServiceFee;

    private BigDecimal totalRepayAmount;

    private String ftcsFinancialProductId;

    private String ftcsFeeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getApproveNodeId() {
        return approveNodeId;
    }

    public void setApproveNodeId(Integer approveNodeId) {
        this.approveNodeId = approveNodeId;
    }

    public BigDecimal getBillingPrice() {
        return billingPrice;
    }

    public void setBillingPrice(BigDecimal billingPrice) {
        this.billingPrice = billingPrice;
    }

    public BigDecimal getCarLoanAmount() {
        return carLoanAmount;
    }

    public void setCarLoanAmount(BigDecimal carLoanAmount) {
        this.carLoanAmount = carLoanAmount;
    }

    public Integer getHasPurchaseTax() {
        return hasPurchaseTax;
    }

    public void setHasPurchaseTax(Integer hasPurchaseTax) {
        this.hasPurchaseTax = hasPurchaseTax;
    }

    public BigDecimal getPurchaseTax() {
        return purchaseTax;
    }

    public void setPurchaseTax(BigDecimal purchaseTax) {
        this.purchaseTax = purchaseTax;
    }

    public BigDecimal getDecorateAmount() {
        return decorateAmount;
    }

    public void setDecorateAmount(BigDecimal decorateAmount) {
        this.decorateAmount = decorateAmount;
    }

    public BigDecimal getInsuranceAmount() {
        return insuranceAmount;
    }

    public void setInsuranceAmount(BigDecimal insuranceAmount) {
        this.insuranceAmount = insuranceAmount;
    }

    public BigDecimal getAccidentInsurance() {
        return accidentInsurance;
    }

    public void setAccidentInsurance(BigDecimal accidentInsurance) {
        this.accidentInsurance = accidentInsurance;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public BigDecimal getHandingFeeRate() {
        return handingFeeRate;
    }

    public void setHandingFeeRate(BigDecimal handingFeeRate) {
        this.handingFeeRate = handingFeeRate;
    }

    public Integer getFeeCalcType() {
        return feeCalcType;
    }

    public void setFeeCalcType(Integer feeCalcType) {
        this.feeCalcType = feeCalcType;
    }

    public BigDecimal getDealerRateLower() {
        return dealerRateLower;
    }

    public void setDealerRateLower(BigDecimal dealerRateLower) {
        this.dealerRateLower = dealerRateLower;
    }

    public BigDecimal getServiceFeeUpRate() {
        return serviceFeeUpRate;
    }

    public void setServiceFeeUpRate(BigDecimal serviceFeeUpRate) {
        this.serviceFeeUpRate = serviceFeeUpRate;
    }

    public BigDecimal getDealerServiceFeeRate() {
        return dealerServiceFeeRate;
    }

    public void setDealerServiceFeeRate(BigDecimal dealerServiceFeeRate) {
        this.dealerServiceFeeRate = dealerServiceFeeRate;
    }

    public BigDecimal getDealerServiceFeeAmount() {
        return dealerServiceFeeAmount;
    }

    public void setDealerServiceFeeAmount(BigDecimal dealerServiceFeeAmount) {
        this.dealerServiceFeeAmount = dealerServiceFeeAmount;
    }

    public BigDecimal getDownpaymentAmount() {
        return downpaymentAmount;
    }

    public void setDownpaymentAmount(BigDecimal downpaymentAmount) {
        this.downpaymentAmount = downpaymentAmount;
    }

    public BigDecimal getDownpaymentRate() {
        return downpaymentRate;
    }

    public void setDownpaymentRate(BigDecimal downpaymentRate) {
        this.downpaymentRate = downpaymentRate;
    }

    public BigDecimal getInstallmentAmount() {
        return installmentAmount;
    }

    public void setInstallmentAmount(BigDecimal installmentAmount) {
        this.installmentAmount = installmentAmount;
    }

    public BigDecimal getExtraFeeAmount() {
        return extraFeeAmount;
    }

    public void setExtraFeeAmount(BigDecimal extraFeeAmount) {
        this.extraFeeAmount = extraFeeAmount;
    }

    public BigDecimal getExtraFeeRate() {
        return extraFeeRate;
    }

    public void setExtraFeeRate(BigDecimal extraFeeRate) {
        this.extraFeeRate = extraFeeRate;
    }

    public BigDecimal getMonthlySupply() {
        return monthlySupply;
    }

    public void setMonthlySupply(BigDecimal monthlySupply) {
        this.monthlySupply = monthlySupply;
    }

    public BigDecimal getLoanRatio() {
        return loanRatio;
    }

    public void setLoanRatio(BigDecimal loanRatio) {
        this.loanRatio = loanRatio;
    }

    public BigDecimal getInstallmentHandingFee() {
        return installmentHandingFee;
    }

    public void setInstallmentHandingFee(BigDecimal installmentHandingFee) {
        this.installmentHandingFee = installmentHandingFee;
    }

    public BigDecimal getExtraHandingFee() {
        return extraHandingFee;
    }

    public void setExtraHandingFee(BigDecimal extraHandingFee) {
        this.extraHandingFee = extraHandingFee;
    }

    public BigDecimal getGuaranteeServiceFee() {
        return guaranteeServiceFee;
    }

    public void setGuaranteeServiceFee(BigDecimal guaranteeServiceFee) {
        this.guaranteeServiceFee = guaranteeServiceFee;
    }

    public BigDecimal getTotalRepayAmount() {
        return totalRepayAmount;
    }

    public void setTotalRepayAmount(BigDecimal totalRepayAmount) {
        this.totalRepayAmount = totalRepayAmount;
    }

    public String getFtcsFinancialProductId() {
        return ftcsFinancialProductId;
    }

    public void setFtcsFinancialProductId(String ftcsFinancialProductId) {
        this.ftcsFinancialProductId = ftcsFinancialProductId == null ? null : ftcsFinancialProductId.trim();
    }

    public String getFtcsFeeId() {
        return ftcsFeeId;
    }

    public void setFtcsFeeId(String ftcsFeeId) {
        this.ftcsFeeId = ftcsFeeId == null ? null : ftcsFeeId.trim();
    }
}