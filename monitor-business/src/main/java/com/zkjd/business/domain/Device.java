package com.zkjd.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zkjd.common.annotation.Excel;
import com.zkjd.common.core.domain.BaseEntity;

/**
 * 监测设备对象 tab_device
 *
 * @author xuxiang
 * @date 2021-11-04
 */
public class Device extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 设备Id */
    private String deviceId;

    /** 设备名称 */
    private String deviceName;

    /** 设备类型Id */
    private String deviceTypeId;

    /** 设备编号 */
    private String deviceNo;

    /** 删除标识 */
    private String delFlag;

    /** 爬架ID */
    private Long climbFrameId;

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceTypeId(String deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    public String getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setClimbFrameId(Long climbFrameId) {
        this.climbFrameId = climbFrameId;
    }

    public Long getClimbFrameId() {
        return climbFrameId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("deviceId", getDeviceId())
                .append("deviceName", getDeviceName())
                .append("deviceTypeId", getDeviceTypeId())
                .append("deviceNo", getDeviceNo())
                .append("remark", getRemark())
                .append("delFlag", getDelFlag())
                .append("climbFrameId", getClimbFrameId())
                .toString();
    }
}
