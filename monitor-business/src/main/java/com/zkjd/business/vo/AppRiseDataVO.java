package com.zkjd.business.vo;

/**
 * @author: Xu Xiang  @createTime: 2021/11/17 15:15
 * Description: app端封装提升次数数据
 */
public class AppRiseDataVO {
    private Integer janData;
    private Integer febData;
    private Integer marData;
    private Integer aprData;
    private Integer mayData;
    private Integer juneData;
    private Integer julyData;
    private Integer augData;
    private Integer septData;
    private Integer octData;
    private Integer novData;
    private Integer deceData;

    public AppRiseDataVO(Integer janData, Integer febData, Integer marData, Integer aprData, Integer mayData, Integer juneData, Integer julyData, Integer augData, Integer septData, Integer octData, Integer novData, Integer deceData) {
        this.janData = janData;
        this.febData = febData;
        this.marData = marData;
        this.aprData = aprData;
        this.mayData = mayData;
        this.juneData = juneData;
        this.julyData = julyData;
        this.augData = augData;
        this.septData = septData;
        this.octData = octData;
        this.novData = novData;
        this.deceData = deceData;
    }

    public AppRiseDataVO() {
    }

    public Integer getJanData() {
        return janData;
    }

    public void setJanData(Integer janData) {
        this.janData = janData;
    }

    public Integer getFebData() {
        return febData;
    }

    public void setFebData(Integer febData) {
        this.febData = febData;
    }

    public Integer getMarData() {
        return marData;
    }

    public void setMarData(Integer marData) {
        this.marData = marData;
    }

    public Integer getAprData() {
        return aprData;
    }

    public void setAprData(Integer aprData) {
        this.aprData = aprData;
    }

    public Integer getMayData() {
        return mayData;
    }

    public void setMayData(Integer mayData) {
        this.mayData = mayData;
    }

    public Integer getJuneData() {
        return juneData;
    }

    public void setJuneData(Integer juneData) {
        this.juneData = juneData;
    }

    public Integer getJulyData() {
        return julyData;
    }

    public void setJulyData(Integer julyData) {
        this.julyData = julyData;
    }

    public Integer getAugData() {
        return augData;
    }

    public void setAugData(Integer augData) {
        this.augData = augData;
    }

    public Integer getSeptData() {
        return septData;
    }

    public void setSeptData(Integer septData) {
        this.septData = septData;
    }

    public Integer getOctData() {
        return octData;
    }

    public void setOctData(Integer octData) {
        this.octData = octData;
    }

    public Integer getNovData() {
        return novData;
    }

    public void setNovData(Integer novData) {
        this.novData = novData;
    }

    public Integer getDeceData() {
        return deceData;
    }

    public void setDeceData(Integer deceData) {
        this.deceData = deceData;
    }

    @Override
    public String toString() {
        return "AppRiseDataVO{" +
                "janData=" + janData +
                ", febData=" + febData +
                ", marData=" + marData +
                ", aprData=" + aprData +
                ", mayData=" + mayData +
                ", juneData=" + juneData +
                ", julyData=" + julyData +
                ", augData=" + augData +
                ", septData=" + septData +
                ", octData=" + octData +
                ", novData=" + novData +
                ", deceData=" + deceData +
                '}';
    }
}
