package com.zkjd.business.vo;

/**
 * @author: Xu Xiang  @createTime: 2021/11/17 14:10
 * Description: app封装每个月告警数量
 */
public class WarningDataVO {
    private String month;
    private Integer number;

    public WarningDataVO(String month, Integer number) {
        this.month = month;
        this.number = number;
    }

    public WarningDataVO() {
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "WarningDataVO{" +
                "month='" + month + '\'' +
                ", number=" + number +
                '}';
    }
}
