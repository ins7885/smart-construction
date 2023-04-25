package com.zkjd.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zkjd.common.annotation.Excel;
import com.zkjd.common.core.domain.BaseEntity;

/**
 * BIM点位对象 tab_model_point
 * 
 * @author wangtao
 * @date 2021-12-02
 */
public class ModelPoint extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long modelPointId;

    /** 模型ID */
    @Excel(name = "模型ID")
    private Long modelId;

    /** 倾角 */
    @Excel(name = "倾角")
    private Long dipAngle;

    /** 风速 */
    @Excel(name = "风速")
    private Long windSpeed;

    /** 位置信息 */
    @Excel(name = "位置信息")
    private String position;

    /** 删除标记 */
    private Integer delFlag;

    /** 监测点ID */
    private Long monitorPid;

    /** 测点类型 */
    private String monitorType;

    public void setModelPointId(Long modelPointId) 
    {
        this.modelPointId = modelPointId;
    }

    public Long getModelPointId() 
    {
        return modelPointId;
    }
    public void setModelId(Long modelId) 
    {
        this.modelId = modelId;
    }

    public Long getModelId() 
    {
        return modelId;
    }
    public void setDipAngle(Long dipAngle) 
    {
        this.dipAngle = dipAngle;
    }

    public Long getDipAngle() 
    {
        return dipAngle;
    }
    public void setWindSpeed(Long windSpeed) 
    {
        this.windSpeed = windSpeed;
    }

    public Long getWindSpeed() 
    {
        return windSpeed;
    }
    public void setPosition(String position) 
    {
        this.position = position;
    }

    public String getPosition() 
    {
        return position;
    }
    public void setDelFlag(Integer delFlag) 
    {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag() 
    {
        return delFlag;
    }


    public Long getMonitorPid() {
        return monitorPid;
    }

    public void setMonitorPid(Long monitorPid) {
        this.monitorPid = monitorPid;
    }

    public String getMonitorType() {
        return monitorType;
    }

    public void setMonitorType(String monitorType) {
        this.monitorType = monitorType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("modelPointId", getModelPointId())
            .append("modelId", getModelId())
            .append("dipAngle", getDipAngle())
            .append("windSpeed", getWindSpeed())
            .append("position", getPosition())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
