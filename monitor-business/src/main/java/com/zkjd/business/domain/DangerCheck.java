package com.zkjd.business.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zkjd.common.annotation.Excel;
import com.zkjd.common.core.domain.BaseEntity;

/**
 * 安全隐患排查对象 tab_danger_check
 *
 * @author zkjd
 * @date 2022-01-26
 */
public class DangerCheck extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 检查人 */
    @Excel(name = "检查人")
    private String checkMan;

    /** 检查时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "检查时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date checkTime;

    /** 责任区域 */
    @Excel(name = "责任区域")
    private String dutyArea;

    /** 责任单位 */
    @Excel(name = "责任单位")
    private String dutyUnit;

    /** 问题描述 */
    @Excel(name = "问题描述")
    private String problemDesc;

    /** 问题类别(1：一般； 2：重大) */
    @Excel(name = "问题类别(1：一般； 2：重大)")
    private String problemType;

    /** 问题类型(注意和问题类别区分) */
    @Excel(name = "问题类型")
    private String problemCut;

    /** 检查现场图片路径 */
    @Excel(name = "检查现场图片路径")
    private String imageUrl;

    /** 整改期限 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "整改期限", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date modifyTime;

    /** 整改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "整改时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date modifiedTime;

    /** 整改人 */
    @Excel(name = "整改人")
    private String modifyMan;

    /** 整改要求 */
    @Excel(name = "整改要求")
    private String modifyRequest;

    /** 复查人 */
    @Excel(name = "复查人")
    private String reviewMan;

    /** 删除标志 */
    private Integer delFlag;

    /** 问题状态(1：未整改；2：待复查；3：已复查) */
    @Excel(name = "问题状态(1：未整改；2：待复查；3：已复查)")
    private Integer status;

    /** 整改回复 */
    @Excel(name = "整改回复")
    private String modifyContent;

    /** 整改现场图片路径 */
    @Excel(name = "整改现场图片路径")
    private String modifyImage;

    /** 复查结果(1：合格；2：不合格) */
    @Excel(name = "复查结果(1：合格；2：不合格)")
    private Integer reviewResult;

    /** 复查说明 */
    @Excel(name = "复查说明")
    private String reviewRemark;

    /** 复查现场图片路径 */
    @Excel(name = "复查现场图片路径")
    private String reviewImage;

    /** 检查人的用户ID */
    @Excel(name = "检查人的用户ID")
    private Long checkManId;

    /** 整改人的用户ID */
    @Excel(name = "整改人的用户ID")
    private Long modifyManId;

    /** 复查人的用户ID */
    @Excel(name = "复查人的用户ID")
    private Long reviewManId;

    /** 所属项目ID */
    @Excel(name = "复查人的用户ID")
    private Long projectId;

    /** 所属项目名称 */
    @Excel(name = "复查人的用户ID")
    private String projectName;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProblemCut() {
        return problemCut;
    }

    public void setProblemCut(String problemCut) {
        this.problemCut = problemCut;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setCheckMan(String checkMan) {
        this.checkMan = checkMan;
    }

    public String getCheckMan() {
        return checkMan;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setDutyArea(String dutyArea) {
        this.dutyArea = dutyArea;
    }

    public String getDutyArea() {
        return dutyArea;
    }

    public void setDutyUnit(String dutyUnit) {
        this.dutyUnit = dutyUnit;
    }

    public String getDutyUnit() {
        return dutyUnit;
    }

    public void setProblemDesc(String problemDesc) {
        this.problemDesc = problemDesc;
    }

    public String getProblemDesc() {
        return problemDesc;
    }

    public void setProblemType(String problemType) {
        this.problemType = problemType;
    }

    public String getProblemType() {
        return problemType;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyMan(String modifyMan) {
        this.modifyMan = modifyMan;
    }

    public String getModifyMan() {
        return modifyMan;
    }

    public void setModifyRequest(String modifyRequest) {
        this.modifyRequest = modifyRequest;
    }

    public String getModifyRequest() {
        return modifyRequest;
    }

    public void setReviewMan(String reviewMan) {
        this.reviewMan = reviewMan;
    }

    public String getReviewMan() {
        return reviewMan;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setModifyContent(String modifyContent) {
        this.modifyContent = modifyContent;
    }

    public String getModifyContent() {
        return modifyContent;
    }

    public void setModifyImage(String modifyImage) {
        this.modifyImage = modifyImage;
    }

    public String getModifyImage() {
        return modifyImage;
    }

    public void setReviewResult(Integer reviewResult) {
        this.reviewResult = reviewResult;
    }

    public Integer getReviewResult() {
        return reviewResult;
    }

    public void setReviewRemark(String reviewRemark) {
        this.reviewRemark = reviewRemark;
    }

    public String getReviewRemark() {
        return reviewRemark;
    }

    public void setReviewImage(String reviewImage) {
        this.reviewImage = reviewImage;
    }

    public String getReviewImage() {
        return reviewImage;
    }

    public void setCheckManId(Long checkManId) {
        this.checkManId = checkManId;
    }

    public Long getCheckManId() {
        return checkManId;
    }

    public void setModifyManId(Long modifyManId) {
        this.modifyManId = modifyManId;
    }

    public Long getModifyManId() {
        return modifyManId;
    }

    public void setReviewManId(Long reviewManId) {
        this.reviewManId = reviewManId;
    }

    public Long getReviewManId() {
        return reviewManId;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }


    @Override
    public String toString() {
        return "DangerCheck{" +
                "id=" + id +
                ", checkMan='" + checkMan + '\'' +
                ", checkTime=" + checkTime +
                ", dutyArea='" + dutyArea + '\'' +
                ", dutyUnit='" + dutyUnit + '\'' +
                ", problemDesc='" + problemDesc + '\'' +
                ", problemType='" + problemType + '\'' +
                ", problemCut='" + problemCut + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", modifyTime=" + modifyTime +
                ", modifiedTime=" + modifiedTime +
                ", modifyMan='" + modifyMan + '\'' +
                ", modifyRequest='" + modifyRequest + '\'' +
                ", reviewMan='" + reviewMan + '\'' +
                ", delFlag=" + delFlag +
                ", status=" + status +
                ", modifyContent='" + modifyContent + '\'' +
                ", modifyImage='" + modifyImage + '\'' +
                ", reviewResult=" + reviewResult +
                ", reviewRemark='" + reviewRemark + '\'' +
                ", reviewImage='" + reviewImage + '\'' +
                ", checkManId=" + checkManId +
                ", modifyManId=" + modifyManId +
                ", reviewManId=" + reviewManId +
                ", projectId=" + projectId +
                ", projectName=" + projectName +
                '}';
    }
}
