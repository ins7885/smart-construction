package com.zkjd.business.vo;

import java.util.List;

/**
 * @author: Xu Xiang  @createTime: 2021/11/17 14:10
 * Description: 后台管理系统 - 荷载数据
 */
public class StressDataVO {
    private List<String> dateStr;
    private Long craneId;
    private String craneName;
    private List<String> stress;

    public List<String> getDateStr() {
        return dateStr;
    }

    public void setDateStr(List<String> dateStr) {
        this.dateStr = dateStr;
    }

    public Long getCraneId() {
        return craneId;
    }

    public void setCraneId(Long craneId) {
        this.craneId = craneId;
    }

    public String getCraneName() {
        return craneName;
    }

    public void setCraneName(String craneName) {
        this.craneName = craneName;
    }

    public List<String> getStress() {
        return stress;
    }

    public void setStress(List<String> stress) {
        this.stress = stress;
    }

    @Override
    public String toString() {
        return "StressDataVO{" +
                "dateStr=" + dateStr +
                ", craneId=" + craneId +
                ", craneName='" + craneName + '\'' +
                ", stress=" + stress +
                '}';
    }
}
