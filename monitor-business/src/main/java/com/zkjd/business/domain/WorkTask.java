package com.zkjd.business.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zkjd.common.annotation.Excel;
import com.zkjd.common.core.domain.BaseEntity;

/**
 * 工作任务对象 tab_work_task
 *
 * @author zkjd
 * @date 2022-02-22
 */
public class WorkTask extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long taskId;

    /** 项目ID */
    @Excel(name = "项目ID")
    private Long projectId;

    /** 任务内容 */
    @Excel(name = "任务内容")
    private String taskContent;

    /** 执行时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "执行时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date implementTime;

    /** 执行状态 */
    @Excel(name = "执行状态")
    private String status;

    /** 删除标记 */
    private Integer delFlag;

    public void setTaskId(Long taskId)
    {
        this.taskId = taskId;
    }

    public Long getTaskId()
    {
        return taskId;
    }
    public void setProjectId(Long projectId)
    {
        this.projectId = projectId;
    }

    public Long getProjectId()
    {
        return projectId;
    }
    public void setTaskContent(String taskContent)
    {
        this.taskContent = taskContent;
    }

    public String getTaskContent()
    {
        return taskContent;
    }
    public void setImplementTime(Date implementTime)
    {
        this.implementTime = implementTime;
    }

    public Date getImplementTime()
    {
        return implementTime;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setDelFlag(Integer delFlag)
    {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag()
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("taskId", getTaskId())
                .append("projectId", getProjectId())
                .append("taskContent", getTaskContent())
                .append("implementTime", getImplementTime())
                .append("status", getStatus())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}

