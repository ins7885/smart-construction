package com.zkjd.business.vo;

import com.zkjd.business.domain.ClimbFrame;

/**
 * @author: Xu Xiang  @createTime: 2021/11/10 9:29
 * Description: 
 */
public class ClimbFrameVO extends ClimbFrame {
    private String month;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public ClimbFrameVO(String month) {
        this.month = month;
    }

    public ClimbFrameVO() {
    }

    @Override
    public String toString() {
        return "ClimbFrameVO{" +
                "month='" + month + '\'' +
                '}';
    }
}
