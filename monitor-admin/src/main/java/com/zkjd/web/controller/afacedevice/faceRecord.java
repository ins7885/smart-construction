package com.zkjd.web.controller.afacedevice;

/**
 * @PackageName: com.zkjd.web.controller.afacedevice
 * @ProjectName: intelligent-monitor-server
 * @Description:
 * @version: v1.0.0
 * @author: HuangXiang Email:HuangXiang@youotech.com
 * @date: 2023-03-13  19:57
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2023-03-13     HuangXiang           v1.0.0            创建文件
 */
public class faceRecord {
    private String serial;
    private String count;
    private String cardNo;
    private String openTime;
    private String openType;
    private String status;

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getOpenType() {
        return openType;
    }

    public void setOpenType(String openType) {
        this.openType = openType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
