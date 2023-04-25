package com.zkjd.business.vo;

/**
 * @author: Xu Xiang  @createTime: 2021/11/17 14:10
 * Description: 后台管理系统 - 提升次数
 */
public class RiseDataVO {
    private String dateStr;
    private Integer number;

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "WarnDataVO{" +
                "dateStr='" + dateStr + '\'' +
                ", number=" + number +
                '}';
    }
}
