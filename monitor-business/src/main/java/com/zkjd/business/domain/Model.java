package com.zkjd.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zkjd.common.annotation.Excel;
import com.zkjd.common.core.domain.BaseEntity;

import java.util.List;

/**
 * BIM模型对象 tab_model
 * 
 * @author wangtao
 * @date 2021-12-02
 */
public class Model extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long modelId;

    /** 模型名称 */
    @Excel(name = "模型名称")
    private String modelName;

    /** 模型编码 */
    @Excel(name = "模型编码")
    private String modelCode;

    /** 删除标记 */
    private Integer delFlag;

    /** 爬架名称 */
    @Excel(name = "爬架名称")
    private String climbFrameName;

    /** 爬架ID */
    private Long climbFrameId;

    /** 项目ID */
    private Long projectId;

    /** 项目名称 */
    @Excel(name = "项目名称",sort = 0)
    private String projectName;

    /** 模型标注点 */
    private List<ModelPoint> positions;

    private String fileId;

    public void setModelId(Long modelId) 
    {
        this.modelId = modelId;
    }

    public Long getModelId() 
    {
        return modelId;
    }
    public void setModelName(String modelName) 
    {
        this.modelName = modelName;
    }

    public String getModelName() 
    {
        return modelName;
    }
    public void setModelCode(String modelCode) 
    {
        this.modelCode = modelCode;
    }

    public String getModelCode() 
    {
        return modelCode;
    }
    public void setDelFlag(Integer delFlag) 
    {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag() 
    {
        return delFlag;
    }

    public List<ModelPoint> getPositions() {
        return positions;
    }

    public void setPositions(List<ModelPoint> positions) {
        this.positions = positions;
    }

    public Long getClimbFrameId() {
        return climbFrameId;
    }

    public void setClimbFrameId(Long climbFrameId) {
        this.climbFrameId = climbFrameId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getClimbFrameName() {
        return climbFrameName;
    }

    public void setClimbFrameName(String climbFrameName) {
        this.climbFrameName = climbFrameName;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("modelId", getModelId())
            .append("modelName", getModelName())
            .append("modelCode", getModelCode())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("fileId", getFileId())
            .append("projectName", getProjectName())
            .toString();
    }
}
