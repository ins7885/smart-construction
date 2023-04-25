package com.zkjd.business.vo;

import java.util.List;

/**
 * @Author: wangtao
 * @Description: 视频监控设备
 * @Date: create in 2022/7/1 10:44
 */
public class VideoDevice {

    private int total;

    private List<ItemsBean> items;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {

        private String name;
        private int type;
        private String nsId;
        private String nsName;
        private String gbId;
        private String state;
        private String username;
        private String password;
        private boolean pullIfRegister;
        private int createdAt;
        private int updatedAt;
        private int channels;
        private int lastRegisterAt;
        private int lastKeepaliveAt;
        private boolean alarmEnable;
        private String alarmMethods;
        private boolean localRecordPushEnable;
        private String localRecordTemplate;
        private String batchId;
        private LocationBean location;
        private List<?> cruiseGroups;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getNsId() {
            return nsId;
        }

        public void setNsId(String nsId) {
            this.nsId = nsId;
        }

        public String getNsName() {
            return nsName;
        }

        public void setNsName(String nsName) {
            this.nsName = nsName;
        }

        public String getGbId() {
            return gbId;
        }

        public void setGbId(String gbId) {
            this.gbId = gbId;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public boolean isPullIfRegister() {
            return pullIfRegister;
        }

        public void setPullIfRegister(boolean pullIfRegister) {
            this.pullIfRegister = pullIfRegister;
        }

        public int getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(int createdAt) {
            this.createdAt = createdAt;
        }

        public int getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(int updatedAt) {
            this.updatedAt = updatedAt;
        }

        public int getChannels() {
            return channels;
        }

        public void setChannels(int channels) {
            this.channels = channels;
        }

        public int getLastRegisterAt() {
            return lastRegisterAt;
        }

        public void setLastRegisterAt(int lastRegisterAt) {
            this.lastRegisterAt = lastRegisterAt;
        }

        public int getLastKeepaliveAt() {
            return lastKeepaliveAt;
        }

        public void setLastKeepaliveAt(int lastKeepaliveAt) {
            this.lastKeepaliveAt = lastKeepaliveAt;
        }

        public boolean isAlarmEnable() {
            return alarmEnable;
        }

        public void setAlarmEnable(boolean alarmEnable) {
            this.alarmEnable = alarmEnable;
        }

        public String getAlarmMethods() {
            return alarmMethods;
        }

        public void setAlarmMethods(String alarmMethods) {
            this.alarmMethods = alarmMethods;
        }

        public boolean isLocalRecordPushEnable() {
            return localRecordPushEnable;
        }

        public void setLocalRecordPushEnable(boolean localRecordPushEnable) {
            this.localRecordPushEnable = localRecordPushEnable;
        }

        public String getLocalRecordTemplate() {
            return localRecordTemplate;
        }

        public void setLocalRecordTemplate(String localRecordTemplate) {
            this.localRecordTemplate = localRecordTemplate;
        }

        public String getBatchId() {
            return batchId;
        }

        public void setBatchId(String batchId) {
            this.batchId = batchId;
        }

        public LocationBean getLocation() {
            return location;
        }

        public void setLocation(LocationBean location) {
            this.location = location;
        }

        public List<?> getCruiseGroups() {
            return cruiseGroups;
        }

        public void setCruiseGroups(List<?> cruiseGroups) {
            this.cruiseGroups = cruiseGroups;
        }

        public static class LocationBean {

            private boolean enable;
            private int type;

            public boolean isEnable() {
                return enable;
            }

            public void setEnable(boolean enable) {
                this.enable = enable;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }
    }
}
