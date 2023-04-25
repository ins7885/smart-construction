package com.zkjd.business.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zkjd.common.annotation.Excel;
import com.zkjd.common.core.domain.BaseEntity;

/**
 * 升降脚手架提升作业前检查对象 tab_rise_check
 *
 * @author zkjd
 * @date 2021-12-01
 */
public class RiseCheck extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 删除标志(0:未删除;1:已删除) */
    private Integer delFlag;

    /** 关联项目表id */
    @Excel(name = "关联项目表id")
    private Long projectId;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 关联爬架id(待定) */
    @Excel(name = "关联爬架id")
    private Long climbFrameId;

    /** 爬架名称 */
    @Excel(name = "爬架名称")
    private String climbFrameName;

    /** 楼栋名称(弃用) */
    @Excel(name = "楼栋名称(弃用)")
    private String monomer;

    /** 结构形式 */
    @Excel(name = "结构形式")
    private String structure;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String deviceName;

    /** 型号 */
    @Excel(name = "型号")
    private String model;

    /** 制造单位 */
    @Excel(name = "制造单位")
    private String productUnit;

    /** 提升日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "提升日期", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date riseDate;

    /** 检查时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "检查时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date checkDate;

    /** 提升楼层 */
    @Excel(name = "提升楼层")
    private String riseFloor;

    /** 提升次数 */
    @Excel(name = "提升次数")
    private Long riseNumber;

    /** 总包单位 */
    @Excel(name = "总包单位")
    private String generalUnit;

    /** 项目负责人 */
    @Excel(name = "项目负责人")
    private String projectMan;

    /** 安拆单位 */
    @Excel(name = "安拆单位")
    private String underUnit;

    /** 安拆单位负责人 */
    @Excel(name = "安拆单位负责人")
    private String underUnitMan;

    /** 检查结论(1:符合要求; 2:不符合要求) */
    @Excel(name = "检查结论(1:符合要求; 2:不符合要求)")
    private Integer checkConclusion;

    /** 搭设单位负责人签名图片路径 */
    @Excel(name = "搭设单位负责人签名图片路径")
    private String erectionManSign;

    /** 栋号检收员签名图片路径 */
    @Excel(name = "栋号检收员签名图片路径")
    private String monomerCheckSign;

    /** 项目技术负责人签名图片路径 */
    @Excel(name = "项目技术负责人签名图片路径")
    private String projectManagerSign;

    /** 项目安全人员签名图片路径 */
    @Excel(name = "项目安全人员签名图片路径")
    private String projectSafeSign;

    /** 生产经理签名图片路径 */
    @Excel(name = "生产经理签名图片路径")
    private String productionSign;

    /** 所属的检查类别 */
    @Excel(name = "所属的检查类别")
    private String dictType;

    /** 经度 */
    private Double lat;

    /** 纬度 */
    private Double lon;

    /** 检查记录中勾选的配置项及结果列表 */
    private String checkValues;

    /** 关联的子表数据 */
    private List<RiseCheckSub> riseCheckSubs;

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public String getClimbFrameName() {
        return climbFrameName;
    }

    public void setClimbFrameName(String climbFrameName) {
        this.climbFrameName = climbFrameName;
    }
    public String getCheckValues() {
        return checkValues;
    }

    public void setCheckValues(String checkValues) {
        this.checkValues = checkValues;
    }

    public List<RiseCheckSub> getRiseCheckSubs() {
        return riseCheckSubs;
    }

    public void setRiseCheckSubs(List<RiseCheckSub> riseCheckSubs) {
        this.riseCheckSubs = riseCheckSubs;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag() {
        return delFlag;
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

    public void setClimbFrameId(Long climbFrameId) {
        this.climbFrameId = climbFrameId;
    }

    public Long getClimbFrameId() {
        return climbFrameId;
    }

    public void setMonomer(String monomer) {
        this.monomer = monomer;
    }

    public String getMonomer() {
        return monomer;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getStructure() {
        return structure;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setRiseDate(Date riseDate) {
        this.riseDate = riseDate;
    }

    public Date getRiseDate() {
        return riseDate;
    }

    public void setRiseFloor(String riseFloor) {
        this.riseFloor = riseFloor;
    }

    public String getRiseFloor() {
        return riseFloor;
    }

    public void setRiseNumber(Long riseNumber) {
        this.riseNumber = riseNumber;
    }

    public Long getRiseNumber() {
        return riseNumber;
    }

    public void setGeneralUnit(String generalUnit) {
        this.generalUnit = generalUnit;
    }

    public String getGeneralUnit() {
        return generalUnit;
    }

    public void setProjectMan(String projectMan) {
        this.projectMan = projectMan;
    }

    public String getProjectMan() {
        return projectMan;
    }

    public void setUnderUnit(String underUnit) {
        this.underUnit = underUnit;
    }

    public String getUnderUnit() {
        return underUnit;
    }

    public void setUnderUnitMan(String underUnitMan) {
        this.underUnitMan = underUnitMan;
    }

    public String getUnderUnitMan() {
        return underUnitMan;
    }

    public void setCheckConclusion(Integer checkConclusion) {
        this.checkConclusion = checkConclusion;
    }

    public Integer getCheckConclusion() {
        return checkConclusion;
    }

    public void setErectionManSign(String erectionManSign) {
        this.erectionManSign = erectionManSign;
    }

    public String getErectionManSign() {
        return erectionManSign;
    }

    public void setMonomerCheckSign(String monomerCheckSign) {
        this.monomerCheckSign = monomerCheckSign;
    }

    public String getMonomerCheckSign() {
        return monomerCheckSign;
    }

    public void setProjectManagerSign(String projectManagerSign) {
        this.projectManagerSign = projectManagerSign;
    }

    public String getProjectManagerSign() {
        return projectManagerSign;
    }

    public void setProjectSafeSign(String projectSafeSign) {
        this.projectSafeSign = projectSafeSign;
    }

    public String getProjectSafeSign() {
        return projectSafeSign;
    }

    public void setProductionSign(String productionSign) {
        this.productionSign = productionSign;
    }

    public String getProductionSign() {
        return productionSign;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getDictType() {
        return dictType;
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
        return "RiseCheck{" +
                "id=" + id +
                ", delFlag=" + delFlag +
                ", projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", climbFrameId=" + climbFrameId +
                ", climbFrameName='" + climbFrameName + '\'' +
                ", monomer='" + monomer + '\'' +
                ", structure='" + structure + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", model='" + model + '\'' +
                ", productUnit='" + productUnit + '\'' +
                ", riseDate=" + riseDate +
                ", checkDate=" + checkDate +
                ", riseFloor='" + riseFloor + '\'' +
                ", riseNumber=" + riseNumber +
                ", generalUnit='" + generalUnit + '\'' +
                ", projectMan='" + projectMan + '\'' +
                ", underUnit='" + underUnit + '\'' +
                ", underUnitMan='" + underUnitMan + '\'' +
                ", checkConclusion=" + checkConclusion +
                ", erectionManSign='" + erectionManSign + '\'' +
                ", monomerCheckSign='" + monomerCheckSign + '\'' +
                ", projectManagerSign='" + projectManagerSign + '\'' +
                ", projectSafeSign='" + projectSafeSign + '\'' +
                ", productionSign='" + productionSign + '\'' +
                ", dictType='" + dictType + '\'' +
                ", checkValues='" + checkValues + '\'' +
                ", riseCheckSubs=" + riseCheckSubs + '\'' +
                ", lat='" + lat + '\'' +
                ", lon=" + lon +
                '}';
    }
}
