package com.zkjd.business.vo;

/**
 * @author: Xu Xiang  @createTime: 2021/11/10 10:00
 * Description: 项目和设备数量统计
 */
public class QuantityStatisticsVO {
    /**
     * 已安装项目
     */
    private Integer InstalledItems;

    /**
     * 已安装设备
     */
    private Integer InstalledEquipment;

    /**
     * 告警项目
     */
    private Integer AlertItems;

    /**
     * 告警设备
     */
    private Integer AlertEquipment;

    public QuantityStatisticsVO(Integer installedItems, Integer installedEquipment, Integer alertItems, Integer alertEquipment) {
        InstalledItems = installedItems;
        InstalledEquipment = installedEquipment;
        AlertItems = alertItems;
        AlertEquipment = alertEquipment;
    }

    public QuantityStatisticsVO() {
    }

    public Integer getInstalledItems() {
        return InstalledItems;
    }

    public void setInstalledItems(Integer installedItems) {
        InstalledItems = installedItems;
    }

    public Integer getInstalledEquipment() {
        return InstalledEquipment;
    }

    public void setInstalledEquipment(Integer installedEquipment) {
        InstalledEquipment = installedEquipment;
    }

    public Integer getAlertItems() {
        return AlertItems;
    }

    public void setAlertItems(Integer alertItems) {
        AlertItems = alertItems;
    }

    public Integer getAlertEquipment() {
        return AlertEquipment;
    }

    public void setAlertEquipment(Integer alertEquipment) {
        AlertEquipment = alertEquipment;
    }

    @Override
    public String toString() {
        return "QuantityStatisticsVO{" +
                "InstalledItems=" + InstalledItems +
                ", InstalledEquipment=" + InstalledEquipment +
                ", AlertItems=" + AlertItems +
                ", AlertEquipment=" + AlertEquipment +
                '}';
    }
}
