package com.zkjd.business.vo;

/**
 * @Author: wangtao
 * @Description: 监控视频流
 * @Date: create in 2022/7/1 11:12
 */
public class VideoStream {

    private String publishUrl;
    private PlayUrlsBean playUrls;
    private int publishUrlExpired;

    public String getPublishUrl() {
        return publishUrl;
    }

    public void setPublishUrl(String publishUrl) {
        this.publishUrl = publishUrl;
    }

    public PlayUrlsBean getPlayUrls() {
        return playUrls;
    }

    public void setPlayUrls(PlayUrlsBean playUrls) {
        this.playUrls = playUrls;
    }

    public int getPublishUrlExpired() {
        return publishUrlExpired;
    }

    public void setPublishUrlExpired(int publishUrlExpired) {
        this.publishUrlExpired = publishUrlExpired;
    }

    public static class PlayUrlsBean {

        private String rtmp;
        private String flv;
        private String hls;
        private String webrtc;

        public String getRtmp() {
            return rtmp;
        }

        public void setRtmp(String rtmp) {
            this.rtmp = rtmp;
        }

        public String getFlv() {
            return flv;
        }

        public void setFlv(String flv) {
            this.flv = flv;
        }

        public String getHls() {
            return hls;
        }

        public void setHls(String hls) {
            this.hls = hls;
        }

        public String getWebrtc() {
            return webrtc;
        }

        public void setWebrtc(String webrtc) {
            this.webrtc = webrtc;
        }
    }
}
