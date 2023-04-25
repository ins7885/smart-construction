package com.zkjd.business.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zkjd.business.domain.RiseRecord;
import com.zkjd.common.annotation.Excel;

import java.util.Date;

/**
 * @author: Xu Xiang  @createTime: 2022-03-14 9:35
 * Description: 分装统计分析中系统自动获取的提升记录
 */
public class RiseDataByTimeRangeVO extends RiseRecord {
    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "RiseDataByTimeRangeVO{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
