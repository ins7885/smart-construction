package com.zkjd.business.qo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zkjd.common.core.domain.BaseEntity;

import java.io.Serializable;

/**
 * @author: Xu Xiang  @createTime: 2022-02-24 10:40
 * Description: 统计分析QO
 */
public class StatisticsQO extends BaseEntity implements Serializable {
    private Long projectId;

    private Long climbFrameId;

    private String startTime;

    private String endTime;

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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "statisticsQO{" +
                "projectId=" + projectId +
                ", climbFrameId=" + climbFrameId +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
