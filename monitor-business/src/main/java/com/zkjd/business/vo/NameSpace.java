package com.zkjd.business.vo;

import java.util.List;

/**
 * @Author: wangtao
 * @Description: 七牛云namespace
 * @Date: create in 2022/7/1 10:03
 */
public class NameSpace {

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

        private String id;
        private String name;
        private String desc;
        private String accessType;
        private int rtmpUrlType;
        private int urlMode;
        private String zone;
        private boolean hlsLowLatency;
        private String authMode;
        private boolean onDemandPull;
        private int createdAt;
        private int updatedAt;
        private int deviceCount;
        private int platformCount;
        private int streamCount;
        private int onlineStreamCount;
        private int disabledStreamCount;
        private int onlineDeviceCount;
        private int offlineDeviceCount;
        private int unRegDeviceCount;
        private boolean recordTemplateApplyAll;
        private boolean snapshotTemplateApplyAll;
        private boolean disabled;
        private boolean rtpAudio;
        private int retryInterval;
        private int retryCount;
        private List<?> domains;
        private List<SipAddrsBean> sipAddrs;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getAccessType() {
            return accessType;
        }

        public void setAccessType(String accessType) {
            this.accessType = accessType;
        }

        public int getRtmpUrlType() {
            return rtmpUrlType;
        }

        public void setRtmpUrlType(int rtmpUrlType) {
            this.rtmpUrlType = rtmpUrlType;
        }

        public int getUrlMode() {
            return urlMode;
        }

        public void setUrlMode(int urlMode) {
            this.urlMode = urlMode;
        }

        public String getZone() {
            return zone;
        }

        public void setZone(String zone) {
            this.zone = zone;
        }

        public boolean isHlsLowLatency() {
            return hlsLowLatency;
        }

        public void setHlsLowLatency(boolean hlsLowLatency) {
            this.hlsLowLatency = hlsLowLatency;
        }

        public String getAuthMode() {
            return authMode;
        }

        public void setAuthMode(String authMode) {
            this.authMode = authMode;
        }

        public boolean isOnDemandPull() {
            return onDemandPull;
        }

        public void setOnDemandPull(boolean onDemandPull) {
            this.onDemandPull = onDemandPull;
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

        public int getDeviceCount() {
            return deviceCount;
        }

        public void setDeviceCount(int deviceCount) {
            this.deviceCount = deviceCount;
        }

        public int getPlatformCount() {
            return platformCount;
        }

        public void setPlatformCount(int platformCount) {
            this.platformCount = platformCount;
        }

        public int getStreamCount() {
            return streamCount;
        }

        public void setStreamCount(int streamCount) {
            this.streamCount = streamCount;
        }

        public int getOnlineStreamCount() {
            return onlineStreamCount;
        }

        public void setOnlineStreamCount(int onlineStreamCount) {
            this.onlineStreamCount = onlineStreamCount;
        }

        public int getDisabledStreamCount() {
            return disabledStreamCount;
        }

        public void setDisabledStreamCount(int disabledStreamCount) {
            this.disabledStreamCount = disabledStreamCount;
        }

        public int getOnlineDeviceCount() {
            return onlineDeviceCount;
        }

        public void setOnlineDeviceCount(int onlineDeviceCount) {
            this.onlineDeviceCount = onlineDeviceCount;
        }

        public int getOfflineDeviceCount() {
            return offlineDeviceCount;
        }

        public void setOfflineDeviceCount(int offlineDeviceCount) {
            this.offlineDeviceCount = offlineDeviceCount;
        }

        public int getUnRegDeviceCount() {
            return unRegDeviceCount;
        }

        public void setUnRegDeviceCount(int unRegDeviceCount) {
            this.unRegDeviceCount = unRegDeviceCount;
        }

        public boolean isRecordTemplateApplyAll() {
            return recordTemplateApplyAll;
        }

        public void setRecordTemplateApplyAll(boolean recordTemplateApplyAll) {
            this.recordTemplateApplyAll = recordTemplateApplyAll;
        }

        public boolean isSnapshotTemplateApplyAll() {
            return snapshotTemplateApplyAll;
        }

        public void setSnapshotTemplateApplyAll(boolean snapshotTemplateApplyAll) {
            this.snapshotTemplateApplyAll = snapshotTemplateApplyAll;
        }

        public boolean isDisabled() {
            return disabled;
        }

        public void setDisabled(boolean disabled) {
            this.disabled = disabled;
        }

        public boolean isRtpAudio() {
            return rtpAudio;
        }

        public void setRtpAudio(boolean rtpAudio) {
            this.rtpAudio = rtpAudio;
        }

        public int getRetryInterval() {
            return retryInterval;
        }

        public void setRetryInterval(int retryInterval) {
            this.retryInterval = retryInterval;
        }

        public int getRetryCount() {
            return retryCount;
        }

        public void setRetryCount(int retryCount) {
            this.retryCount = retryCount;
        }

        public List<?> getDomains() {
            return domains;
        }

        public void setDomains(List<?> domains) {
            this.domains = domains;
        }

        public List<SipAddrsBean> getSipAddrs() {
            return sipAddrs;
        }

        public void setSipAddrs(List<SipAddrsBean> sipAddrs) {
            this.sipAddrs = sipAddrs;
        }

        public static class SipAddrsBean {

            private String sipServerId;
            private String sipServerIP;
            private String proxyNode;
            private List<String> sipServerPort;

            public String getSipServerId() {
                return sipServerId;
            }

            public void setSipServerId(String sipServerId) {
                this.sipServerId = sipServerId;
            }

            public String getSipServerIP() {
                return sipServerIP;
            }

            public void setSipServerIP(String sipServerIP) {
                this.sipServerIP = sipServerIP;
            }

            public String getProxyNode() {
                return proxyNode;
            }

            public void setProxyNode(String proxyNode) {
                this.proxyNode = proxyNode;
            }

            public List<String> getSipServerPort() {
                return sipServerPort;
            }

            public void setSipServerPort(List<String> sipServerPort) {
                this.sipServerPort = sipServerPort;
            }
        }
    }
}
