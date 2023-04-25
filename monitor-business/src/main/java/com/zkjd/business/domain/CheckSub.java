package com.zkjd.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zkjd.common.annotation.Excel;
import com.zkjd.common.core.domain.BaseEntity;

/**
 * 设备检查子对象 tab_check_sub
 *
 * @author zkjd
 * @date 2021-11-16
 */
public class CheckSub extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 字典类型(存储检查类别) */
    @Excel(name = "字典类型(存储检查类别)")
    private String dictType;

    /** 字典键值(存储检查项的dict_value) */
    @Excel(name = "字典键值(存储检查项的dict_value)")
    private String dictValue;

    /** 使用前检查主键ID */
    private Long checkId;

    /** 检查值 检查值（0：不合格，1：合格） */
    private Integer checkValue;

    /** 删除标志 */
    private Integer delFlag;

    public Long getCheckId() {
        return checkId;
    }

    public void setCheckId(Long checkId) {
        this.checkId = checkId;
    }

    public Integer getCheckValue() {
        return checkValue;
    }

    public void setCheckValue(Integer checkValue) {
        this.checkValue = checkValue;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    @Override
    public String toString() {
        return "CheckSub{" +
                "id=" + id +
                ", dictType='" + dictType + '\'' +
                ", dictValue='" + dictValue + '\'' +
                ", checkId=" + checkId +
                ", checkValue=" + checkValue +
                ", delFlag=" + delFlag +
                '}';
    }
}
