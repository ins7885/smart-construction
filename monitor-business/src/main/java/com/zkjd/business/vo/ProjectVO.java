package com.zkjd.business.vo;


/**
 * @Author: wangtao
 * @CreateTime: 2022-01-26 21:41
 * @Description: 项目封装类
 */
public class ProjectVO {

    /**
     * 省份
     */
    private String province;

    /**
     * 数量
     */
    private Integer number;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "ProjectVO{" +
                "province='" + province + '\'' +
                ", number=" + number +
                '}';
    }
}
