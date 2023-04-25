package com.zkjd.business.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zkjd.common.annotation.Excel;
import com.zkjd.common.core.domain.BaseEntity;

/**
 * 附着式升降脚手架提升及维护保养记录(app中的维护保养)对象 tab_maintain
 *
 * @author zkjd
 * @date 2021-12-02
 */
public class Maintain extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 关联项目表主键ID */
    @Excel(name = "关联项目表主键ID")
    private Long projectId;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 维护主项名称(爬升机构等) */
    @Excel(name = "维护主项名称(爬升机构等)")
    private String mainName;

    /** 维护分项键值(maintain01等) */
    @Excel(name = "维护分项键值(maintain01等)")
    private String itemKey;

    /** 维护分项名称(附墙支座等) */
    @Excel(name = "维护分项名称(附墙支座等)")
    private String itemName;

    /** 主要维护内容 */
    @Excel(name = "主要维护内容")
    private String content;

    /** 维护人签字图片路径 */
    @Excel(name = "维护人签字图片路径")
    private String manSign;

    /** 维护日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "维护日期", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date mainTime;

    /** 删除标志 */
    private Integer delFlag;

    /** 关联爬架表主键ID */
    private Integer climbFrameId;

    /** 爬架名称 */
    private String climbFrameName;

    public Integer getClimbFrameId() {
        return climbFrameId;
    }

    public void setClimbFrameId(Integer climbFrameId) {
        this.climbFrameId = climbFrameId;
    }

    public String getClimbFrameName() {
        return climbFrameName;
    }

    public void setClimbFrameName(String climbFrameName) {
        this.climbFrameName = climbFrameName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setMainName(String mainName) {
        this.mainName = mainName;
    }

    public String getMainName() {
        return mainName;
    }

    public void setItemKey(String itemKey) {
        this.itemKey = itemKey;
    }

    public String getItemKey() {
        return itemKey;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setManSign(String manSign) {
        this.manSign = manSign;
    }

    public String getManSign() {
        return manSign;
    }

    public void setMainTime(Date mainTime) {
        this.mainTime = mainTime;
    }

    public Date getMainTime() {
        return mainTime;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    @Override
    public String toString() {
        return "Maintain{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", mainName='" + mainName + '\'' +
                ", itemKey='" + itemKey + '\'' +
                ", itemName='" + itemName + '\'' +
                ", content='" + content + '\'' +
                ", manSign='" + manSign + '\'' +
                ", mainTime=" + mainTime +
                ", delFlag=" + delFlag +
                ", climbFrameId=" + climbFrameId +
                ", climbFrameName='" + climbFrameName + '\'' +
                '}';
    }
}
