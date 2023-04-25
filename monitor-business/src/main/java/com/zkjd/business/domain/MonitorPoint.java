package com.zkjd.business.domain;

import com.zkjd.common.annotation.Excel;
import com.zkjd.common.core.domain.BaseEntity;

/**
 * 监测点对象 tab_monitor_point
 * 
 * @author wangtao
 * @date 2021-12-01
 */
public class MonitorPoint extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long monitorPid;

    /** 测点名称 */
    @Excel(name = "测点名称")
    private String pointName;

    /** 测点类型 */
//    @Excel(name = "测点类型")
    private String type;

    /** 测点类型名称 */
    @Excel(name = "测点类型")
    private String typeName;

    /** 主控地址 */
    @Excel(name = "主控地址")
    private String masterControl;

    /** 分控地址 */
    @Excel(name = "分控地址")
    private String subControl;

    /** 爬架ID */
//    @Excel(name = "爬架ID")
    private Long climbFrameId;

    /** 爬架名称 */
    @Excel(name = "爬架名称")
    private String climbFrameName;

    /** 电葫芦ID */
//    @Excel(name = "电葫芦ID")
    private Long craneId;

    /** 电葫芦名称 */
    @Excel(name = "电葫芦名称")
    private String craneName;

    /** 删除标记 */
    private Integer delFlag;

    /** 项目Id */
    private Long projectId;

    /** 阈值上限 */
    @Excel(name = "阈值上限")
    private Double maxValue;

    /** 阈值下限 */
    @Excel(name = "阈值下限")
    private Double minValue;

    /** 初始值 */
    @Excel(name = "初始值")
    private Double initValue;

    /** 项目名称 */
    @Excel(name = "项目名称",sort = 0)
    private String projectName;

    /** 监控视频链接 */
    private String videoUrl;

    /** 命名空间 */
    private String nameSpace;

    /** 监控设备id */
    private String deviceId;

    public Long getMonitorPid() {
        return monitorPid;
    }

    public void setMonitorPid(Long monitorPid) {
        this.monitorPid = monitorPid;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setMasterControl(String masterControl) 
    {
        this.masterControl = masterControl;
    }

    public String getMasterControl() 
    {
        return masterControl;
    }
    public void setSubControl(String subControl) 
    {
        this.subControl = subControl;
    }

    public String getSubControl() 
    {
        return subControl;
    }
    public void setClimbFrameId(Long climbFrameId) 
    {
        this.climbFrameId = climbFrameId;
    }

    public Long getClimbFrameId() 
    {
        return climbFrameId;
    }
    public void setClimbFrameName(String climbFrameName) 
    {
        this.climbFrameName = climbFrameName;
    }

    public String getClimbFrameName() 
    {
        return climbFrameName;
    }
    public void setCraneId(Long craneId) 
    {
        this.craneId = craneId;
    }

    public Long getCraneId() 
    {
        return craneId;
    }
    public void setCraneName(String craneName) 
    {
        this.craneName = craneName;
    }

    public String getCraneName() 
    {
        return craneName;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
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

    public Double getInitValue() {
        return initValue;
    }

    public void setInitValue(Double initValue) {
        this.initValue = initValue;
    }


    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }


    public String getNameSpace() {
        return nameSpace;
    }

    public void setNamespace(String nameSpace) {
        this.nameSpace = nameSpace;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public String toString() {
        return "MonitorPoint{" +
                "monitorPid=" + monitorPid +
                ", pointName='" + pointName + '\'' +
                ", type='" + type + '\'' +
                ", masterControl='" + masterControl + '\'' +
                ", subControl='" + subControl + '\'' +
                ", climbFrameId=" + climbFrameId +
                ", climbFrameName='" + climbFrameName + '\'' +
                ", craneId=" + craneId +
                ", craneName='" + craneName + '\'' +
                ", delFlag=" + delFlag +
                ", projectId=" + projectId +
                ", maxValue=" + maxValue +
                ", minValue=" + minValue +
                ", initValue=" + initValue +
                ", typeName=" + typeName +
                ", projectName=" + projectName +
                ", videoUrl=" + videoUrl +
                '}';
    }
}
