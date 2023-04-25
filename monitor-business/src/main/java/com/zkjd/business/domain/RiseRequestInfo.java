package com.zkjd.business.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zkjd.common.annotation.Excel;
import com.zkjd.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * @Description 爬架提升流程申请
 * @Author luckyS
 * @Date 11.8 22:00
 **/
public class RiseRequestInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 项目ID
     */
    private Long projectId;

    /**
     * 爬架ID
     */
    private Long climbFrameId;

    /**
     * 项目名称
     */
    @Excel(name = "项目名称")
    private String projectName;

    /**
     * 单体名称
     */
    @Excel(name = "楼栋名称")
    private String monomer;
    /**
     * 爬架名称
     */
    @Excel(name = "爬架名称")
    private String climbFrameName;
    /**
     * 爬架名称
     */
    @Excel(name = "操作类型")
    private Long riseType;

    /**
     * 提升时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 提升时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "提升时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date riseTime;

    /**
     * 操作人员
     */
    @Excel(name = "操作人员")
    private String operateMan;

    /**
     * 提升楼层
     */
    @Excel(name = "提升楼层")
    private String riseFloor;

    /**
     * 提升次数
     */
    @Excel(name = "提升次数")
    private Long riseNumber;

    /**
     * 提升作业前检查ID
     */
    private Long checkId;

    /**
     * 当前流程（0：区域管理员审核，1：项目安全人员审核，2：审批结束，3：审批结束）
     */
    private Integer currentProcess;

    /**
     * 审核结果(-1:不通过，1：通过)
     */
    private Integer requestResult;

    /**
     * 删除标志
     */
    private Integer flag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getClimbFrameId() {
        return climbFrameId;
    }

    public void setClimbFrameId(Long climbFrameId) {
        this.climbFrameId = climbFrameId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getMonomer() {
        return monomer;
    }

    public void setMonomer(String monomer) {
        this.monomer = monomer;
    }

    public String getClimbFrameName() {
        return climbFrameName;
    }

    public void setClimbFrameName(String climbFrameName) {
        this.climbFrameName = climbFrameName;
    }

    public Long getRiseType() {
        return riseType;
    }

    public void setRiseType(Long riseType) {
        this.riseType = riseType;
    }

    public Date getRiseTime() {
        return riseTime;
    }

    public void setRiseTime(Date riseTime) {
        this.riseTime = riseTime;
    }

    public String getOperateMan() {
        return operateMan;
    }

    public void setOperateMan(String operateMan) {
        this.operateMan = operateMan;
    }

    public String getRiseFloor() {
        return riseFloor;
    }

    public void setRiseFloor(String riseFloor) {
        this.riseFloor = riseFloor;
    }

    public Long getRiseNumber() {
        return riseNumber;
    }

    public void setRiseNumber(Long riseNumber) {
        this.riseNumber = riseNumber;
    }

    public Long getCheckId() {
        return checkId;
    }

    public void setCheckId(Long checkId) {
        this.checkId = checkId;
    }

    public Integer getCurrentProcess() {
        return currentProcess;
    }

    public void setCurrentProcess(Integer currentProcess) {
        this.currentProcess = currentProcess;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getRequestResult() {
        return requestResult;
    }

    public void setRequestResult(Integer requestResult) {
        this.requestResult = requestResult;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
