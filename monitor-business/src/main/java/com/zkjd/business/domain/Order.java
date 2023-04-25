package com.zkjd.business.domain;

import com.zkjd.common.core.domain.BaseEntity;

/**
 * @Author: wangtao
 * @CreateTime: 2022-04-18 20:59
 * @Description: 指令表
 */
public class Order extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 指令Id
     */
    private Long orderId;

    /**
     * 爬架Id
     */
    private Long climbFrameId;

    /**
     * 删除标记
     */
    private Integer delFlag;

    /**
     * 操作
     */
    private Integer operate;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getClimbFrameId() {
        return climbFrameId;
    }

    public void setClimbFrameId(Long climbFrameId) {
        this.climbFrameId = climbFrameId;
    }

    public Integer getOperate() {
        return operate;
    }

    public void setOperate(Integer operate) {
        this.operate = operate;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
}
