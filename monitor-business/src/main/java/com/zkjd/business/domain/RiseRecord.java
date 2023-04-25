package com.zkjd.business.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zkjd.common.annotation.Excel;
import com.zkjd.common.core.domain.BaseEntity;

/**
 * 提升记录对象 tab_rise_record
 *
 * @author zkjd
 * @date 2021-11-18
 */
public class RiseRecord extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 项目ID */
    private Long projectId;

    /** 爬架ID */
    private Long climbFrameId;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 单体名称 */
    @Excel(name = "楼栋名称")
    private String monomer;

    /** 提升时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "提升时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date riseTime;

    /** 操作人员 */
    @Excel(name = "操作人员")
    private String operateMan;

    /** 提升楼层 */
    @Excel(name = "提升楼层")
    private String riseFloor;

    /** 提升次数 */
    @Excel(name = "提升次数")
    private Long riseNumber;

    /** 提升作业前检查ID */
    private Long checkId;

    /** 删除标志 */
    private Integer flag;

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

    public void setRiseTime(Date riseTime) {
        this.riseTime = riseTime;
    }

    public Date getRiseTime() {
        return riseTime;
    }

    public void setOperateMan(String operateMan) {
        this.operateMan = operateMan;
    }

    public String getOperateMan() {
        return operateMan;
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

    public void setCheckId(Long checkId) {
        this.checkId = checkId;
    }

    public Long getCheckId() {
        return checkId;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setMonomer(String monomer) {
        this.monomer = monomer;
    }

    public String getMonomer() {
        return monomer;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("projectId", getProjectId())
                .append("climbFrameId", getClimbFrameId())
                .append("riseTime", getRiseTime())
                .append("operateMan", getOperateMan())
                .append("riseFloor", getRiseFloor())
                .append("riseNumber", getRiseNumber())
                .append("checkId", getCheckId())
                .append("createTime", getCreateTime())
                .append("createBy", getCreateBy())
                .append("updateTime", getUpdateTime())
                .append("updateBy", getUpdateBy())
                .append("flag", getFlag())
                .append("monomer", getMonomer())
                .append("projectName", getProjectName())
                .toString();
    }
}
