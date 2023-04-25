package com.zkjd.business.vo;

import java.util.List;
import java.util.Map;

/**
 * @Author: wangtao
 * @CreateTime: 2022-01-24 16:15
 * @Description:
 */
public class LineChartVO {

    private Map yData;

    private List<String> xData;

    public Map getyData() {
        return yData;
    }

    public void setyData(Map yData) {
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
