package com.zkjd.business.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zkjd.common.annotation.Excel;
import com.zkjd.common.core.domain.BaseEntity;

/**
 * 爬架卸料平台验收记录对象 tab_accept_record
 *
 * @author zkjd
 * @date 2021-12-01
 */
public class AcceptRecord extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 关联项目表主键ID */
    @Excel(name = "关联项目表主键ID")
    private Long projectId;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 作业班组 */
    @Excel(name = "作业班组")
    private String workTeam;

    /** 安装部位 */
    @Excel(name = "安装部位")
    private String installPosition;

    /** 载重量 */
    @Excel(name = "载重量")
    private String loadCapacity;

    /** 验收意见 */
    @Excel(name = "验收意见")
    private String conclusion;

    /** 验收时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "验收时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date acceptTime;

    /** 所属检查类别 */
    @Excel(name = "所属检查类别")
    private String dictType;

    /** 删除标志(0:未删除;1:已删除) */
    private Integer delFlag;

    /** 安装班组签名图片路径 */
    @Excel(name = "安装班组签名图片路径")
    private String installTeamSign;

    /** 使用班组签名图片路径 */
    @Excel(name = "使用班组签名图片路径")
    private String useTeamSign;

    /** 责任工程师签名图片路径 */
    @Excel(name = "责任工程师签名图片路径")
    private String dutyManSign;

    /** 安全部签名图片路径 */
    @Excel(name = "安全部签名图片路径")
    private String safeTeamSign;

    /** 技术负责人签名图片路径 */
    @Excel(name = "技术负责人签名图片路径")
    private String technologyManSign;

    /** 检查记录中勾选的配置项及结果列表 */
    private String checkValues;

    /** 经度 */
    private Double lat;

    /** 纬度 */
    private Double lon;

    /** 关联的子表数据 */
    private List<AcceptSub> acceptSubs;

    public String getCheckValues() {
        return checkValues;
    }

    public void setCheckValues(String checkValues) {
        this.checkValues = checkValues;
    }

    public List<AcceptSub> getAcceptSubs() {
        return acceptSubs;
    }

    public void setAcceptSubs(List<AcceptSub> acceptSubs) {
        this.acceptSubs = acceptSubs;
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

    public void setWorkTeam(String workTeam) {
        this.workTeam = workTeam;
    }

    public String getWorkTeam() {
        return workTeam;
    }

    public void setInstallPosition(String installPosition) {
        this.installPosition = installPosition;
    }

    public String getInstallPosition() {
        return installPosition;
    }

    public void setLoadCapacity(String loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public String getLoadCapacity() {
        return loadCapacity;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setAcceptTime(Date acceptTime) {
        this.acceptTime = acceptTime;
    }

    public Date getAcceptTime() {
        return acceptTime;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setInstallTeamSign(String installTeamSign) {
        this.installTeamSign = installTeamSign;
    }

    public String getInstallTeamSign() {
        return installTeamSign;
    }

    public void setUseTeamSign(String useTeamSign) {
        this.useTeamSign = useTeamSign;
    }

    public String getUseTeamSign() {
        return useTeamSign;
    }

    public void setDutyManSign(String dutyManSign) {
        this.dutyManSign = dutyManSign;
    }

    public String getDutyManSign() {
        return dutyManSign;
    }

    public void setSafeTeamSign(String safeTeamSign) {
        this.safeTeamSign = safeTeamSign;
    }

    public String getSafeTeamSign() {
        return safeTeamSign;
    }

    public void setTechnologyManSign(String technologyManSign) {
        this.technologyManSign = technologyManSign;
    }

    public String getTechnologyManSign() {
        return technologyManSign;
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

    @Override
    public String toString() {
        return "AcceptRecord{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", workTeam='" + workTeam + '\'' +
                ", installPosition='" + installPosition + '\'' +
                ", loadCapacity='" + loadCapacity + '\'' +
                ", conclusion='" + conclusion + '\'' +
                ", acceptTime=" + acceptTime +
                ", dictType='" + dictType + '\'' +
                ", delFlag=" + delFlag +
                ", installTeamSign='" + installTeamSign + '\'' +
                ", useTeamSign='" + useTeamSign + '\'' +
                ", dutyManSign='" + dutyManSign + '\'' +
                ", safeTeamSign='" + safeTeamSign + '\'' +
                ", technologyManSign='" + technologyManSign + '\'' +
                ", checkValues='" + checkValues + '\'' +
                ", acceptSubs=" + acceptSubs + '\'' +
                ", lat='" + lat + '\'' +
                ", lon=" + lon +
                '}';
    }
}
