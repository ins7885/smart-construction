package com.zkjd.business.vo;

import java.util.Date;

/**
 * @Author: wangtao
 * @CreateTime: 2022-01-26 11:12
 * @Description:
 */
public class CheckRecordVO {

    /**
     * 时间
     */
    private Date time;

    /**
     * 楼栋 xx
     */
    private String monomer;

    /**
     * 检查结果(合格或不合格) xx
     */
    private String checkConclusionText;

    /**
     * 检查内容
     */
    private String content;

    /**
     * 检查项
     */
    private String checkItem;

    /**
     * 设备ID
     */
    private String deviceId;

    /**
     * 时间字符串
     */
    private String timeStr;

    /**
     * 爬架Id
     */
    private Long climbFrameId;

    /**
     * 检查人
     */
    private String inspect;

    /**
     * 检查结果
     */
    private String result;

    /**
     * 检查类型
     */
    private String type;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getMonomer() {
        return monomer;
    }

    public void setMonomer(String monomer) {
        this.monomer = monomer;
    }

    public String getCheckConclusionText() {
        return checkConclusionText;
    }

    public void setCheckConclusionText(String checkConclusionText) {
        this.checkConclusionText = checkConclusionText;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCheckItem() {
        return checkItem;
    }

    public void setCheckItem(String checkItem) {
        this.checkItem = checkItem;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getTimeStr() {
        return timeStr;
    }

    public void setTimeStr(String timeStr) {
        this.timeStr = timeStr;
    }

    public Long getClimbFrameId() {
        return climbFrameId;
    }

    public void setClimbFrameId(Long climbFrameId) {
        this.climbFrameId = climbFrameId;
    }

    public String getInspect() {
        return inspect;
    }

    public void setInspect(String inspect) {
        this.inspect = inspect;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CheckRecordVO{" +
                "time=" + time +
                ", monomer='" + monomer + '\'' +
                ", checkConclusionText='" + checkConclusionText + '\'' +
                ", content='" + content + '\'' +
                ", checkItem='" + checkItem + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", timeStr='" + timeStr + '\'' +
                ", climbFrameId=" + climbFrameId +
                ", inspect='" + inspect + '\'' +
                ", result='" + result + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
