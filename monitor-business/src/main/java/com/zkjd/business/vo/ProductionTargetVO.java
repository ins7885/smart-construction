package com.zkjd.business.vo;

import java.io.Serializable;

/**
 * @author: Xu Xiang  @createTime: 2021/11/10 9:14
 * Description: app中管理员角色查看的生产指标数据
 */
public class ProductionTargetVO implements Serializable {
    /**
     * 年产量
     */
    private Integer AnnualProduction;

    /**
     * 月产量
     */
    private Integer MonthlyProduction;

    /**
     * 年度已完成产量
     */
    private Integer CompleteAnnualProduction;

    /**
     * 月出货量
     */
    private Integer AnnualShipments;

    public ProductionTargetVO(Integer annualProduction, Integer monthlyProduction, Integer completeAnnualProduction, Integer annualShipments) {
        AnnualProduction = annualProduction;
        MonthlyProduction = monthlyProduction;
        CompleteAnnualProduction = completeAnnualProduction;
        AnnualShipments = annualShipments;
    }

    public ProductionTargetVO() {
    }

    public Integer getAnnualProduction() {
        return AnnualProduction;
    }

    public void setAnnualProduction(Integer annualProduction) {
        AnnualProduction = annualProduction;
    }

    public Integer getMonthlyProduction() {
        return MonthlyProduction;
    }

    public void setMonthlyProduction(Integer monthlyProduction) {
        MonthlyProduction = monthlyProduction;
    }

    public Integer getCompleteAnnualProduction() {
        return CompleteAnnualProduction;
    }

    public void setCompleteAnnualProduction(Integer completeAnnualProduction) {
        CompleteAnnualProduction = completeAnnualProduction;
    }

    public Integer getAnnualShipments() {
        return AnnualShipments;
    }

    public void setAnnualShipments(Integer annualShipments) {
        AnnualShipments = annualShipments;
    }

    @Override
    public String toString() {
        return "ProductionTargetVO{" +
                "AnnualProduction=" + AnnualProduction +
                ", MonthlyProduction=" + MonthlyProduction +
                ", CompleteAnnualProduction=" + CompleteAnnualProduction +
                ", AnnualShipments=" + AnnualShipments +
                '}';
    }
}
