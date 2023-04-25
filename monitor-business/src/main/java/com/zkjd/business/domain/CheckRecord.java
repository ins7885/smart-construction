package com.zkjd.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zkjd.common.annotation.Excel;
import com.zkjd.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 使用前检查对象 tab_check_record
 *
 * @author zkjd
 * @date 2021-11-16
 */
public class CheckRecord extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 项目(工程)ID */
    @Excel(name = "项目(工程)ID")
    private Long projectId;

    /** 爬架ID */
    @Excel(name = "爬架ID")
    private Long climbFrameId;

    /** 楼栋号(单体名称) */
    @Excel(name = "楼栋号(单体名称)")
    private String monomer;

    /** 楼层位置 */
    @Excel(name = "楼层位置")
    private String monomerSite;

    /** 总包单位名称 */
    @Excel(name = "总包单位名称")
    private String generalUnit;

    /** 分包单位名称 */
    @Excel(name = "分包单位名称")
    private String subUnit;

    /** 安拆单位名称 */
    @Excel(name = "安拆单位名称")
    private String underUnit;

    /** 总包单位经理 */
    @Excel(name = "总包单位经理")
    private String generalUnitMan;

    /** 分包单位经理 */
    @Excel(name = "分包单位经理")
    private String subUnitMan;

    /** 安拆单位经理 */
    @Excel(name = "安拆单位经理")
    private String underUnitMan;

    /** 检查结论(1:符合要求; 2:不符合要求) */
    @Excel(name = "检查结论(1:符合要求; 2:不符合要求)")
    private Integer checkConclusion;

    /** 分包现场负责人签名图片路径 */
    @Excel(name = "分包现场负责人签名图片路径")
    private String subManSign;

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

    /** 删除标志 */
    private Integer delFlag;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 所属的检查类别 */
    @Excel(name = "所属的检查类别")
    private String dictType;

    /** 检查记录中勾选的配置项及结果列表 */
    private String checkValues;

    /** 经度 */
    private Double lat;

    /** 纬度 */
    private Double lon;

    /** 关联的子表数据 */
    private List<CheckSub> checkSubs;

    public List<CheckSub> getCheckSubs() {
        return checkSubs;
    }

    public void setCheckSubs(List<CheckSub> checkSubs) {
        this.checkSubs = checkSubs;
    }

    public String getCheckValues() {
        return checkValues;
    }

    public void setCheckValues(String checkValues) {
        this.checkValues = checkValues;
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

    public void setMonomerSite(String monomerSite) {
        this.monomerSite = monomerSite;
    }

    public String getMonomerSite() {
        return monomerSite;
    }

    public void setGeneralUnit(String generalUnit) {
        this.generalUnit = generalUnit;
    }

    public String getGeneralUnit() {
        return generalUnit;
    }

    public void setSubUnit(String subUnit) {
        this.subUnit = subUnit;
    }

    public String getSubUnit() {
        return subUnit;
    }

    public void setUnderUnit(String underUnit) {
        this.underUnit = underUnit;
    }

    public String getUnderUnit() {
        return underUnit;
    }

    public void setGeneralUnitMan(String generalUnitMan) {
        this.generalUnitMan = generalUnitMan;
    }

    public String getGeneralUnitMan() {
        return generalUnitMan;
    }

    public void setSubUnitMan(String subUnitMan) {
        this.subUnitMan = subUnitMan;
    }

    public String getSubUnitMan() {
        return subUnitMan;
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

    public void setSubManSign(String subManSign) {
        this.subManSign = subManSign;
    }

    public String getSubManSign() {
        return subManSign;
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

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName;
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
        return "CheckRecord{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", climbFrameId=" + climbFrameId +
                ", monomer='" + monomer + '\'' +
                ", monomerSite='" + monomerSite + '\'' +
                ", generalUnit='" + generalUnit + '\'' +
                ", subUnit='" + subUnit + '\'' +
                ", underUnit='" + underUnit + '\'' +
                ", generalUnitMan='" + generalUnitMan + '\'' +
                ", subUnitMan='" + subUnitMan + '\'' +
                ", underUnitMan='" + underUnitMan + '\'' +
                ", checkConclusion=" + checkConclusion +
                ", subManSign='" + subManSign + '\'' +
                ", monomerCheckSign='" + monomerCheckSign + '\'' +
                ", projectManagerSign='" + projectManagerSign + '\'' +
                ", projectSafeSign='" + projectSafeSign + '\'' +
                ", productionSign='" + productionSign + '\'' +
                ", delFlag=" + delFlag +
                ", projectName='" + projectName + '\'' +
                ", dictType='" + dictType + '\'' +
                ", checkValues='" + checkValues + '\'' +
                ", checkSubs=" + checkSubs + '\'' +
                ", lat='" + lat + '\'' +
                ", lon=" + lon +
                '}';
    }
}
