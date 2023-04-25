package com.zkjd.business.domain;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zkjd.common.annotation.Excel;
import com.zkjd.common.core.domain.BaseEntity;

/**
 * 历史记录对象 v_record
 *
 * @author zkjd
 * @date 2021-12-12
 */
public class Record implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 爬架名称 */
    @Excel(name = "爬架名称")
    private String climbFrameName;

    /** 项目ID */
    @Excel(name = "项目ID")
    private Long projectId;

    /** 爬架ID */
    @Excel(name = "爬架ID")
    private Long climbFrameId;

    /** 单体名称 */
    @Excel(name = "单体名称")
    private String monomer;

    /** 监测类型 */
    @Excel(name = "监测类型")
    private String type;

    /** 主键 */
    @Excel(name = "主键")
    private Long monitorPid;

    /** 监测值 */
    @Excel(name = "监测值")
    private String recordValue;

    /** 测点名称 */
    @Excel(name = "测点名称")
    private String pointName;

    /** 是否告警 */
    @Excel(name = "是否告警")
    private String isWarn;

    /** 采集时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "采集时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date recordTime;

    @Excel(name = "时间点字符串")
    private String time;

    @Excel(name = "每页行数")
    private Integer size;

    @Excel(name = "页码")
    private Integer num;

    public void setProjectName(String projectName)
    {
        this.projectName = projectName;
    }

    public String getProjectName()
    {
        return projectName;
    }
    public void setClimbFrameName(String climbFrameName)
    {
        this.climbFrameName = climbFrameName;
    }

    public String getClimbFrameName()
    {
        return climbFrameName;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getClimbFrameId() {
        return climbFrameId;
    }

    public void setClimbFrameId(Long climbFrameId) {
        this.climbFrameId = climbFrameId;
    }

    public void setMonomer(String monomer)
    {
        this.monomer = monomer;
    }

    public String getMonomer()
    {
        return monomer;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }
    public void setMonitorPid(Long monitorPid)
    {
        this.monitorPid = monitorPid;
    }

    public Long getMonitorPid()
    {
        return monitorPid;
    }
    public void setRecordValue(String recordValue)
    {
        this.recordValue = recordValue;
    }

    public String getRecordValue()
    {
        return recordValue;
    }
    public void setIsWarn(String isWarn)
    {
        this.isWarn = isWarn;
    }

    public String getIsWarn()
    {
        return isWarn;
    }
    public void setRecordTime(Date recordTime)
    {
        this.recordTime = recordTime;
    }

    public Date getRecordTime()
    {
        return recordTime;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("projectName", getProjectName())
                .append("climbFrameName", getClimbFrameName())
                .append("projectId", getProjectId())
                .append("climbFrameId", getClimbFrameId())
                .append("monomer", getMonomer())
                .append("type", getType())
                .append("monitorPid", getMonitorPid())
                .append("recordValue", getRecordValue())
                .append("isWarn", getIsWarn())
                .append("recordTime", getRecordTime())
                .append("pointName", getPointName())
                .toString();
    }
}
