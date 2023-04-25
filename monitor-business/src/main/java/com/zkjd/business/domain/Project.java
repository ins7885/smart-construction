package com.zkjd.business.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zkjd.common.core.domain.BaseEntity;

import java.util.Date;
import java.util.List;

/**
 * @Author: wangtao
 * @CreateTime: 2021-11-01 18:58
 * @Description: 项目
 */
public class Project extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long projectId;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目类型
     */
    private String projectType;

    /**
     * 资金来源
     */
    private String fundSource;

    /**
     * 施工许可证号
     */
    private String permitNumber;

    /**
     * 工程地址
     */
    private String address;

    /**
     * 重要性
     */
    private Integer importance;

    /**
     * 单体个数
     */
    private Integer monomerNumber;

    /**
     * 计划开工时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date planStartTime;

    /**
     * 计划竣工时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date planFinishedTime;

    /**
     * 绿色建筑面积
     */
    private Double greenArea;

    /**
     * 建筑面积
     */
    private Double area;

    /**
     * 造价
     */
    private Double cost;

    /**
     * 工程状态
     */
    private String state;

    /**
     * 经度
     */
    private Double lat;

    /**
     * 纬度
     */
    private Double lon;

    /**
     * 实际开工时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /**
     * 注册号
     */
    private String registerNumber;

    /**
     * 删除标记
     */
    private Integer delFlag;

    /**
     * 省份信息
     */
    private String province;

    /**
     * 楼栋信息
     */
    private List<Monomer> monomers;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getFundSource() {
        return fundSource;
    }

    public void setFundSource(String fundSource) {
        this.fundSource = fundSource;
    }

    public String getPermitNumber() {
        return permitNumber;
    }

    public void setPermitNumber(String permitNumber) {
        this.permitNumber = permitNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getImportance() {
        return importance;
    }

    public void setImportance(Integer importance) {
        this.importance = importance;
    }

    public Integer getMonomerNumber() {
        return monomerNumber;
    }

    public void setMonomerNumber(Integer monomerNumber) {
        this.monomerNumber = monomerNumber;
    }

    public Date getPlanStartTime() {
        return planStartTime;
    }

    public void setPlanStartTime(Date planStartTime) {
        this.planStartTime = planStartTime;
    }

    public Date getPlanFinishedTime() {
        return planFinishedTime;
    }

    public void setPlanFinishedTime(Date planFinishedTime) {
        this.planFinishedTime = planFinishedTime;
    }

    public Double getGreenArea() {
        return greenArea;
    }

    public void setGreenArea(Double greenArea) {
        this.greenArea = greenArea;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public List<Monomer> getMonomers() {
        return monomers;
    }

    public void setMonomers(List<Monomer> monomers) {
        this.monomers = monomers;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", projectType='" + projectType + '\'' +
                ", fundSource='" + fundSource + '\'' +
                ", permitNumber='" + permitNumber + '\'' +
                ", address='" + address + '\'' +
                ", importance=" + importance +
                ", monomerNumber=" + monomerNumber +
                ", planStartTime=" + planStartTime +
                ", planFinishedTime=" + planFinishedTime +
                ", greenArea=" + greenArea +
                ", area=" + area +
                ", cost=" + cost +
                ", state=" + state +
                ", lat=" + lat +
                ", lon=" + lon +
                ", startTime=" + startTime +
                ", registerNumber='" + registerNumber + '\'' +
                ", delFlag=" + delFlag +
                ", delFlag=" + delFlag +
                '}';
    }
}
