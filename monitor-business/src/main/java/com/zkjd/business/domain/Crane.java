package com.zkjd.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zkjd.common.annotation.Excel;
import com.zkjd.common.core.domain.BaseEntity;

/**
 * 电葫芦设备对象 tab_crane
 * 
 * @author wangtao
 * @date 2021-11-17
 */
public class Crane extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long craneId;

    /** 电葫芦名称 */
    @Excel(name = "电葫芦名称")
    private String craneName;

    /** 爬架ID */
//    @Excel(name = "爬架ID")
    private Long climbFrameId;

    /** 爬架名称 */
    @Excel(name = "爬架名称")
    private String climbFrameName;

    /** 电葫芦编号 */
    @Excel(name = "电葫芦编号")
    private String code;

    /** 删除标记 */
    private Integer delFlag;

    /** 所属面向 */
//    @Excel(name = "所属面向")
    private String direction;

    /** 项目Id */
    private Long projectId;

    private String status;

    /** 项目名称 */
    @Excel(name = "项目名称",sort = 0)
    private String projectName;

    /** 所属面向名称 */
    @Excel(name = "所属面向名称")
    private String directionName;

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
    public void setClimbFrameId(Long climbFrameId) 
    {
        this.climbFrameId = climbFrameId;
    }

    public Long getClimbFrameId() 
    {
        return climbFrameId;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setDelFlag(Integer delFlag) 
    {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag() 
    {
        return delFlag;
    }

    public String getClimbFrameName() {
        return climbFrameName;
    }

    public void setClimbFrameName(String climbFrameName) {
        this.climbFrameName = climbFrameName;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDirectionName() {
        return directionName;
    }

    public void setDirectionName(String directionName) {
        this.directionName = directionName;
    }

    @Override
    public String toString() {
        return "Crane{" +
                "craneId=" + craneId +
                ", craneName='" + craneName + '\'' +
                ", climbFrameId=" + climbFrameId +
                ", climbFrameName='" + climbFrameName + '\'' +
                ", code='" + code + '\'' +
                ", delFlag=" + delFlag +
                ", direction='" + direction + '\'' +
                ", projectId=" + projectId +
                ", status=" + status +
                ", projectName=" + projectName +
                ", directionName=" + directionName +
                '}';
    }
}
