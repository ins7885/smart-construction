package com.zkjd.business.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zkjd.common.annotation.Excel;
import com.zkjd.common.core.domain.BaseEntity;

/**
 * 告警记录对象 tab_warn
 *
 * @author XuXiang
 * @date 2021-11-10
 */
public class Warn extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 告警记录Id */
    private String warnId;

    /** 测点id */
    @Excel(name = "测点id")
    private String pointId;

    /** 历史记录Id */
    @Excel(name = "历史记录Id")
    private String recordId;

    /** 告警值 */
    @Excel(name = "告警值")
    private String warnValue;

    /** 告警类型 */
    @Excel(name = "告警类型")
    private String warnType;

    /** 告警时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "告警时间", width = 30, dateFormat = "yyyy-MM-dd  HH:mm:ss")
    private Date warnTime;

    /** 告警阈值上限 */
    @Excel(name = "告警阈值上限")
    private String maxValue;

    /** 告警阈值上限 */
    @Excel(name = "告警阈值上限")
    private String minValue;

    /** 告警描述 */
    @Excel(name = "告警描述")
    private String warnDesc;

    /** 是否处理 */
    @Excel(name = "是否处理")
    private String warnDeal;

    /** 删除标识 */
    private String delFlag;

    public void setWarnId(String warnId) {
        this.warnId = warnId;
    }

    public String getWarnId() {
        return warnId;
    }

    public void setPointId(String pointId) {
        this.pointId = pointId;
    }

    public String getPointId() {
        return pointId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setWarnValue(String warnValue) {
        this.warnValue = warnValue;
    }

    public String getWarnValue() {
        return warnValue;
    }

    public void setWarnType(String warnType) {
        this.warnType = warnType;
    }

    public String getWarnType() {
        return warnType;
    }

    public void setWarnTime(Date warnTime) {
        this.warnTime = warnTime;
    }

    public Date getWarnTime() {
        return warnTime;
    }

    public void setMaxValue(String maxValue) {
        this.maxValue = maxValue;
    }

    public String getMaxValue() {
        return maxValue;
    }

    public void setMinValue(String minValue) {
        this.minValue = minValue;
    }

    public String getMinValue() {
        return minValue;
    }

    public void setWarnDesc(String warnDesc) {
        this.warnDesc = warnDesc;
    }

    public String getWarnDesc() {
        return warnDesc;
    }

    public void setWarnDeal(String warnDeal) {
        this.warnDeal = warnDeal;
    }

    public String getWarnDeal() {
        return warnDeal;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDelFlag() {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("warnId", getWarnId())
                .append("pointId", getPointId())
                .append("recordId", getRecordId())
                .append("warnValue", getWarnValue())
                .append("warnType", getWarnType())
                .append("warnTime", getWarnTime())
                .append("maxValue", getMaxValue())
                .append("minValue", getMinValue())
                .append("warnDesc", getWarnDesc())
                .append("remark", getRemark())
                .append("warnDeal", getWarnDeal())
                .append("delFlag", getDelFlag())
                .toString();
    }
}
