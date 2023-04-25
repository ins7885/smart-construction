package com.zkjd.business.vo;

import java.util.List;

/**
 * @Author: wangtao
 * @CreateTime: 2022-01-24 16:15
 * @Description:
 */
public class ChartVO {

    private List<Double> yData;

    private List<String> xData;

    public List<Double> getyData() {
        return yData;
    }

    public void setyData(List<Double> yData) {
        this.yData = yData;
    }

    public List<String> getxData() {
        return xData;
    }

    public void setxData(List<String> xData) {
        this.xData = xData;
    }

    @Override
    public String toString() {
        return "ChartVO{" +
                "yData=" + yData +
                ", xData=" + xData +
                '}';
    }
}
