package com.zkjd.business.vo;

import java.util.List;

/**
 * @Author: wangtao
 * @Description: 视频监控封装树形数据
 * @Date: create in 2022/6/21 13:38
 */
public class TreeData {

    /**
     * 唯一标识
     */
    private Long id;

    /**
     * 标题
     */
    private String label;

    /**
     * 是否禁用
     */
    private boolean disabled;

    /**
     * 是否为子节点
     */
    private boolean isLeaf;

    /**
     * 视频监控URL
     */
    private String videoUrl;

    /**
     * 命名空间
     */
    private String nameSpace;

    /**
     * 监控设备
     */
    private String deviceId;

    /**
     * 子级数据
     */
    private List<TreeData> children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    public List<TreeData> getChildren() {
        return children;
    }

    public void setChildren(List<TreeData> children) {
        this.children = children;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getNameSpace() {
        return nameSpace;
    }

    public void setNameSpace(String nameSpace) {
        this.nameSpace = nameSpace;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
