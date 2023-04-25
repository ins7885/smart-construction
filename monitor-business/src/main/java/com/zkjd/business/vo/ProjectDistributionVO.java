package com.zkjd.business.vo;

import java.util.List;

/**
 * @Author: wangtao
 * @CreateTime: 2022-01-26 21:28
 * @Description:
 */
public class ProjectDistributionVO {

    /**
     * 标题
     */
    private List<String> titles;

    /**
     * 占比
     */
    private List<Double> ratio;

    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    public List<Double> getRatio() {
        return ratio;
    }

    public void setRatio(List<Double> ratio) {
        this.ratio = ratio;
    }

    @Override
    public String toString() {
        return "ProjectDistributionVO{" +
                "titles=" + titles +
                ", ratio=" + ratio +
                '}';
    }
}
