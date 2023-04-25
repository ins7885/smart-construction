package com.zkjd.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zkjd.common.annotation.Excel;
import com.zkjd.common.core.domain.BaseEntity;

/**
 * app版本配置对象 tab_app_version
 *
 * @author zkjd
 * @date 2022-02-21
 */
public class AppVersion extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** app版本号 */
    @Excel(name = "app版本号")
    private String versionCode;

    /** 下载地址 */
    @Excel(name = "下载地址")
    private String versionUrl;

    /** 是否是当前版本(1:是; 2:否) */
    @Excel(name = "是否是当前版本(1:是; 2:否)")
    private Integer isCurrent;

    /** 删除标志 */
    private Integer delFlag;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionUrl(String versionUrl) {
        this.versionUrl = versionUrl;
    }

    public String getVersionUrl() {
        return versionUrl;
    }

    public void setIsCurrent(Integer isCurrent) {
        this.isCurrent = isCurrent;
    }

    public Integer getIsCurrent() {
        return isCurrent;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("versionCode", getVersionCode())
                .append("versionUrl", getVersionUrl())
                .append("remark", getRemark())
                .append("isCurrent", getIsCurrent())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("delFlag", getDelFlag())
                .toString();
    }
}
