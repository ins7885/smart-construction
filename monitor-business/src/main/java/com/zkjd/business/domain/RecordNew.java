package com.zkjd.business.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zkjd.common.annotation.Excel;
import com.zkjd.common.core.domain.BaseEntity;

/**
 * 实时数据对象 tab_record_new
 *
 * @author zkjd
 * @date 2021-12-11
 */
public class RecordNew extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 实时数据Id */
    private String recordId;

    /** 测点id */
    @Excel(name = "测点id")
    private String pointId;

    /** 监测值 */
    @Excel(name = "监测值")
    private String recordValue;

    /** 采集时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "采集时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date recordTime;

    /** 是否告警 */
    @Excel(name = "是否告警")
    private String isWarn;

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setPointId(String pointId) {
        this.pointId = pointId;
    }

    public String getPointId() {
        return pointId;
    }

    public void setRecordValue(String recordValue) {
        this.recordValue = recordValue;
    }

    public String getRecordValue() {
        return recordValue;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setIsWarn(String isWarn) {
        this.isWarn = isWarn;
    }

    public String getIsWarn() {
        return isWarn;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("recordId", getRecordId())
                .append("pointId", getPointId())
                .append("recordValue", getRecordValue())
                .append("recordTime", getRecordTime())
                .append("isWarn", getIsWarn())
                .toString();
    }
}
