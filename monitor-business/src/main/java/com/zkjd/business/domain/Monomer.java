package com.zkjd.business.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zkjd.common.annotation.Excel;
import com.zkjd.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * @Author: wangtao
 * @CreateTime: 2021-11-17 10:50
 * @Description:
 */
public class Monomer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 单体ID */
    private Long monomerId;

    /** 楼栋名称 */
    @Excel(name = "楼栋名称")
    private String monomer;

    /**
     * 计划开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    /**
     * 计划竣工时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date finishedDate;

    /**
     * 进度
     */
    private Double rate;

    /** 项目Id */
    @Excel(name = "项目Id")
    private Long projectId;

    /** 删除标记 */
    private Integer delFlag;

    /** 操作标记 */
    private Integer operate;

    public Long getMonomerId() {
        return monomerId;
    }

    public void setMonomerId(Long monomerId) {
        this.monomerId = monomerId;
    }

    public String getMonomer() {
        return monomer;
    }

    public void setMonomer(String monomer) {
        this.monomer = monomer;
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

    public Integer getOperate() {
        return operate;
    }

    public void setOperate(Integer operate) {
        this.operate = operate;
    }


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishedDate() {
        return finishedDate;
    }

    public void setFinishedDate(Date finishedDate) {
        this.finishedDate = finishedDate;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Monomer{" +
                "monomerId=" + monomerId +
                ", monomer='" + monomer + '\'' +
                ", projectId=" + projectId +
                ", delFlag=" + delFlag +
                ", operate=" + operate +
                ", startDate=" + startDate +
                ", finishedDate=" + finishedDate +
                ", rate=" + rate +
                '}';
    }
}
