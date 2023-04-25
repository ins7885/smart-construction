package com.zkjd.business.vo;

import com.zkjd.business.domain.Device;

import java.io.Serializable;

/**
 * @author: Xu Xiang  @createTime: 2021/11/4 15:06
 * Description: app端接收的设备VO
 */
public class AppDeviceVO extends Device implements Serializable {
    /** 项目ID */
    private Long projectId;

    /** 项目名称 */
    private String projectName;

    /** 爬架ID */
    private Long climbFrameId;

    /** 爬架名称 */
    private String climbFrameName;

    public AppDeviceVO(Long projectId, String projectName, Long climbFrameId, String climbFrameName) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.climbFrameId = climbFrameId;
        this.climbFrameName = climbFrameName;
    }

    public AppDeviceVO() {
    }

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

    @Override
    public Long getClimbFrameId() {
        return climbFrameId;
    }

    @Override
    public void setClimbFrameId(Long climbFrameId) {
        this.climbFrameId = climbFrameId;
    }

    public String getClimbFrameName() {
        return climbFrameName;
    }

    public void setClimbFrameName(String climbFrameName) {
        this.climbFrameName = climbFrameName;
    }

    @Override
    public String toString() {
        return "AppDeviceVO{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", climbFrameId=" + climbFrameId +
                ", climbFrameName='" + climbFrameName + '\'' +
                '}';
    }
}
