package com.zkjd.business.vo;

/**
 * @Author: wangtao
 * @CreateTime: 2022-01-26 09:10
 * @Description: 指标数量
 */
public class TargetCountVO {

    /**
     * 项目数量
     */
    private Integer proCount;

    /**
     * 爬架数量
     */
    private Integer  cfCount;

    /**
     * 提升数量
     */
    private Integer rrCount;

    /**
     * 告警数量
     */
    private Integer wCount;

    public Integer getProCount() {
        return proCount;
    }

    public void setProCount(Integer proCount) {
        this.proCount = proCount;
    }

    public Integer getCfCount() {
        return cfCount;
    }

    public void setCfCount(Integer cfCount) {
        this.cfCount = cfCount;
    }

    public Integer getRrCount() {
        return rrCount;
    }

    public void setRrCount(Integer rrCount) {
        this.rrCount = rrCount;
    }

    public Integer getwCount() {
        return wCount;
    }

    public void setwCount(Integer wCount) {
        this.wCount = wCount;
    }

    @Override
    public String toString() {
        return "TargetCountVO{" +
                "proCount=" + proCount +
                ", cfCount=" + cfCount +
                ", rrCount=" + rrCount +
                ", wCount=" + wCount +
                '}';
    }
}
