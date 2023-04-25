package com.zkjd.business.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zkjd.common.annotation.Excel;
import com.zkjd.common.core.domain.BaseEntity;

/**
 * 设备操作记录对象 tab_operate_record
 *
 * @author zkjd
 * @date 2022-06-21
 */
public class OperateRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 操作记录主键 */
    private Long operateId;

    /** 删除标记 */
    private Integer delFlag;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 爬架名称 */
    @Excel(name = "爬架名称")
    private String climbFrameName;

    /** 操作人员 */
    @Excel(name = "操作人员")
    private String operator;

    /** 操作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "操作时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date operateTime;

    /** 主控编号 */
    @Excel(name = "主控编号")
    private Long masterControlNum;

    public void setOperateId(Long operateId)
    {
        this.operateId = operateId;
    }

    public Long getOperateId()
    {
        return operateId;
    }
    public void setDelFlag(Integer delFlag)
    {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag()
    {
        return delFlag;
    }
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
    public void setOperator(String operator)
    {
        this.operator = operator;
    }

    public String getOperator()
    {
        return operator;
    }
    public void setOperateTime(Date operateTime)
    {
        this.operateTime = operateTime;
    }

    public Date getOperateTime()
    {
        return operateTime;
    }
    public void setMasterControlNum(Long masterControlNum)
    {
        this.masterControlNum = masterControlNum;
    }

    public Long getMasterControlNum()
    {
        return masterControlNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("operateId", getOperateId())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("projectName", getProjectName())
                .append("climbFrameName", getClimbFrameName())
                .append("operator", getOperator())
                .append("operateTime", getOperateTime())
                .append("masterControlNum", getMasterControlNum())
                .toString();
    }
}

