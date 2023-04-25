package com.zkjd.business.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zkjd.common.annotation.Excel;
import com.zkjd.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * @Description
 * @Author luckyS
 * @Date 11.8 22:10
 **/
public class RiseRequestProcess extends BaseEntity {

    /**
     * 主键
     */
    private Long id;
    /**
     * 提升申请Id
     */
    private Long riseRequestId;

    /**
     * 操作人员
     */
    @Excel(name = "操作人员")
    private String operateMan;
    /**
     * 提升时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 当前流程（0：发起申请，1：等待区域管理人员审核，2：等待项目安全人员审批，3：审批结束）
     */
    private Integer currentProcess;
    /**
     * 审核结果(-1:不通过，1：通过，2：流转)
     */
    private Integer requestResult;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRiseRequestId() {
        return riseRequestId;
    }

    public void setRiseRequestId(Long riseRequestId) {
        this.riseRequestId = riseRequestId;
    }

    public String getOperateMan() {
        return operateMan;
    }

    public void setOperateMan(String operateMan) {
        this.operateMan = operateMan;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getRequestResult() {
        return requestResult;
    }

    public void setRequestResult(Integer requestResult) {
        this.requestResult = requestResult;
    }

    public Integer getCurrentProcess() {
        return currentProcess;
    }

    public void setCurrentProcess(Integer currentProcess) {
        this.currentProcess = currentProcess;
    }
}
