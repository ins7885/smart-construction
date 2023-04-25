package com.zkjd.business.vo;

import java.io.Serializable;

/**
 * @author: Xu Xiang  @createTime: 2022-02-24 10:46
 * Description: 统计分析VO
 */
public class StatisticsVO implements Serializable {
    /** 提升次数 */
    private int riseNumber;

    /** 安全检查总数 */
    private int safeCheckNumber;

    /** 安全检查-整改数 */
    private int safeModifyNumber;

    /** 安全检查-验收数 */
    private int safePassNumber;

    /** 使用前检查验收数 */
    private int useCheckNumber;

    /** 提升作业前检查验收数 */
    private int riseCheckNumber;

    /** 告警数 */
    private int warnNumber;

    public int getRiseNumber() {
        return riseNumber;
    }

    public void setRiseNumber(int riseNumber) {
        this.riseNumber = riseNumber;
    }

    public int getSafeCheckNumber() {
        return safeCheckNumber;
    }

    public void setSafeCheckNumber(int safeCheckNumber) {
        this.safeCheckNumber = safeCheckNumber;
    }

    public int getSafeModifyNumber() {
        return safeModifyNumber;
    }

    public void setSafeModifyNumber(int safeModifyNumber) {
        this.safeModifyNumber = safeModifyNumber;
    }

    public int getSafePassNumber() {
        return safePassNumber;
    }

    public void setSafePassNumber(int safePassNumber) {
        this.safePassNumber = safePassNumber;
    }

    public int getUseCheckNumber() {
        return useCheckNumber;
    }

    public void setUseCheckNumber(int useCheckNumber) {
        this.useCheckNumber = useCheckNumber;
    }

    public int getRiseCheckNumber() {
        return riseCheckNumber;
    }

    public void setRiseCheckNumber(int riseCheckNumber) {
        this.riseCheckNumber = riseCheckNumber;
    }

    public int getWarnNumber() {
        return warnNumber;
    }

    public void setWarnNumber(int warnNumber) {
        this.warnNumber = warnNumber;
    }

    @Override
    public String toString() {
        return "StatisticsVO{" +
                "riseNumber=" + riseNumber +
                ", safeCheckNumber=" + safeCheckNumber +
                ", safeModifyNumber=" + safeModifyNumber +
                ", safePassNumber=" + safePassNumber +
                ", useCheckNumber=" + useCheckNumber +
                ", riseCheckNumber=" + riseCheckNumber +
                ", warnNumber=" + warnNumber +
                '}';
    }
}
