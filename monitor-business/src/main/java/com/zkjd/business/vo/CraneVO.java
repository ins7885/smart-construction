package com.zkjd.business.vo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zkjd.business.domain.Crane;
import com.zkjd.business.domain.MonitorPoint;
import com.zkjd.common.annotation.Excel;

/**
 * @author: Xu Xiang  @createTime: 2021/11/4 15:06
 * Description: app端接收的电葫芦VO
 */
public class CraneVO extends Crane implements Serializable {

    /** 主键 */
    private Long monitorPid;

    /** 测点类型 */
    private String type;

    /** 阈值上限 */
    private Double maxValue;

    /** 阈值下限 */
    private Double minValue;

    /** 监测值 */
    private String recordValue;

    /** 监测点名称 */
    private String pointName;

    /** 采集时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date recordTime;

    /** 时间字符串 */
    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public Long getMonitorPid() {
        return monitorPid;
    }

    public void setMonitorPid(Long monitorPid) {
        this.monitorPid = monitorPid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Double maxValue) {
        this.maxValue = maxValue;
    }

    public Double getMinValue() {
        return minValue;
    }

    public void setMinValue(Double minValue) {
        this.minValue = minValue;
    }

    public String getRecordValue() {
        return recordValue;
    }

    public void setRecordValue(String recordValue) {
        this.recordValue = recordValue;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    @Override
    public String toString() {
        return "CraneVO{" +
                "monitorPid=" + monitorPid +
                ", type='" + type + '\'' +
                ", maxValue=" + maxValue +
                ", minValue=" + minValue +
                ", recordValue='" + recordValue + '\'' +
                ", pointName='" + pointName + '\'' +
                ", recordTime=" + recordTime +
                ", time='" + time + '\'' +
                '}';
    }
}
