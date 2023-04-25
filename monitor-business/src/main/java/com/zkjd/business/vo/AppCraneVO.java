package com.zkjd.business.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zkjd.business.domain.MonitorPoint;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: Xu Xiang  @createTime: 2021/11/4 15:06
 * Description: app端接收的电葫芦VO
 */
public class AppCraneVO  implements Serializable {

    /** 电葫芦ID */
    private Long craneId;

    /** 拉力比例 */
    private Double forceRate;

    /** 电葫芦荷载 */
    private String pull;

    /** 电流 */
    private Double electric;

    /** A相电压 */
    private Double aVoltage;

    /** B相电压 */
    private Double bVoltage;

    /** c相电压 */
    private Double cVoltage;

    /** 限位 */
    private String limit;

    /** 顶撑受力 */
    private Double stress;

    /** 电葫芦状态 */
    private String status;

    /** 预警值 */
    private Double warnValue;

    /** 差值 */
    private Double diffValue;

    public Double getWarnValue() {
        return warnValue;
    }

    public Double getaVoltage() {
        return aVoltage;
    }

    public void setaVoltage(Double aVoltage) {
        this.aVoltage = aVoltage;
    }

    public Double getbVoltage() {
        return bVoltage;
    }

    public void setbVoltage(Double bVoltage) {
        this.bVoltage = bVoltage;
    }

    public Double getcVoltage() {
        return cVoltage;
    }

    public void setcVoltage(Double cVoltage) {
        this.cVoltage = cVoltage;
    }

    public void setWarnValue(Double warnValue) {
        this.warnValue = warnValue;
    }

    public Double getDiffValue() {
        return diffValue;
    }

    public void setDiffValue(Double diffValue) {
        this.diffValue = diffValue;
    }

    /** 采集时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date recordTime;

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCraneId() {
        return craneId;
    }

    public void setCraneId(Long craneId) {
        this.craneId = craneId;
    }

    public Double getForceRate() {
        return forceRate;
    }

    public void setForceRate(Double forceRate) {
        this.forceRate = forceRate;
    }

    public Double getElectric() {
        return electric;
    }

    public void setElectric(Double electric) {
        this.electric = electric;
    }


    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public Double getStress() {
        return stress;
    }

    public void setStress(Double stress) {
        this.stress = stress;
    }

    public String getPull() {
        return pull;
    }

    public void setPull(String pull) {
        this.pull = pull;
    }

    @Override
    public String toString() {
        return "AppCraneVO{" +
                "craneId=" + craneId +
                ", forceRate=" + forceRate +
                ", pull='" + pull + '\'' +
                ", electric=" + electric +
                ", aVoltage=" + aVoltage +
                ", bVoltage=" + bVoltage +
                ", cVoltage=" + cVoltage +
                ", limit='" + limit + '\'' +
                ", stress=" + stress +
                ", status='" + status + '\'' +
                ", warnValue=" + warnValue +
                ", diffValue=" + diffValue +
                ", recordTime=" + recordTime +
                '}';
    }
}
