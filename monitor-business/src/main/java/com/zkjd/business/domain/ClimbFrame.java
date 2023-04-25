package com.zkjd.business.domain;

import com.zkjd.common.core.domain.BaseEntity;

/**
 * @Author: wangtao
 * @CreateTime: 2021-11-01 19:10
 * @Description: 爬架
 */
public class ClimbFrame extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long climbFrameId;

    /**
     * 爬架名称
     */
    private String climbFrameName;

    /**
     * 爬架类型
     */
    private String climbFrameType;

    /**
     * 项目Id
     */
    private Long projectId;

    /**
     * 单体
     */
    private String monomer;

    /**
     * 单体Id
     */
    private Long monomerId;


    /**
     * 设备安装状态
     */
    private Integer installState;

    /**
     * 删除标记
     */
    private Integer delFlag;

    /**
     * 模型ID
     */
    private Long modelId;

    /**
     * 爬架平面图URL
     */
    private String imageUrl;

    /**
     * 爬架平面图文件名称
     */
    private String imageName;

    /**
     * 操作人员名称
     */
    private String operator;

    /**
     * 联系手机号码
     */
    private String phone;

    /**
     * 人脸闸机编号
     */
    private String deviceSerial;

    /**
     * 人脸闸机密码
     */
    private String devicePassword;

    /**
     * 人脸闸机编号
     */
    private String deviceNo;

    /**
     * 人脸闸机密码
     */
    private String deviceMac;

    /**
     * 锁定状态(1：锁定，2:解锁)
     */
    private Integer lockState;

    public Long getClimbFrameId() {
        return climbFrameId;
    }

    public void setClimbFrameId(Long climbFrameId) {
        this.climbFrameId = climbFrameId;
    }

    public String getClimbFrameName() {
        return climbFrameName;
    }

    public void setClimbFrameName(String climbFrameName) {
        this.climbFrameName = climbFrameName;
    }

    public String getClimbFrameType() {
        return climbFrameType;
    }

    public void setClimbFrameType(String climbFrameType) {
        this.climbFrameType = climbFrameType;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getMonomer() {
        return monomer;
    }

    public void setMonomer(String monomer) {
        this.monomer = monomer;
    }

    public Long getMonomerId() {
        return monomerId;
    }

    public void setMonomerId(Long monomerId) {
        this.monomerId = monomerId;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getInstallState() {
        return installState;
    }

    public void setInstallState(Integer installState) {
        this.installState = installState;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }


    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getLockState() {
        return lockState;
    }

    public void setLockState(Integer lockState) {
        this.lockState = lockState;
    }

    public String getDeviceSerial() {
        return deviceSerial;
    }

    public void setDeviceSerial(String deviceSerial) {
        this.deviceSerial = deviceSerial;
    }

    public String getDevicePassword() {
        return devicePassword;
    }

    public void setDevicePassword(String devicePassword) {
        this.devicePassword = devicePassword;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public String getDeviceMac() {
        return deviceMac;
    }

    public void setDeviceMac(String deviceMac) {
        this.deviceMac = deviceMac;
    }

    @Override
    public String toString() {
        return "ClimbFrame{" +
                "climbFrameId=" + climbFrameId +
                ", climbFrameName='" + climbFrameName + '\'' +
                ", climbFrameType='" + climbFrameType + '\'' +
                ", projectId=" + projectId +
                ", monomer='" + monomer + '\'' +
                ", monomerId=" + monomerId +
                ", installState=" + installState +
                ", delFlag=" + delFlag +
                ", modelId=" + modelId +
                ", imageUrl=" + imageUrl +
                ", imageName=" + imageName +
                ", operator=" + operator +
                ", phone=" + phone +
                ", lockState=" + lockState +
                ", deviceSerial=" + deviceSerial +
                ", devicePassword=" + devicePassword +
                ", deviceNo=" + deviceNo +
                ", deviceMac=" + deviceMac +
                '}';
    }
}
