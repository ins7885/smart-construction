package com.zkjd.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zkjd.common.annotation.Excel;
import com.zkjd.common.core.domain.BaseEntity;

/**
 * 爬架卸料平台验收记录子对象 tab_accept_sub
 *
 * @author zkjd
 * @date 2021-12-01
 */
public class AcceptSub extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 字典类型(存储检查类别:爬架卸料平台验收记录) */
    @Excel(name = "字典类型(存储检查类别:爬架卸料平台验收记录)")
    private String dictType;

    /** 字典键值(存储检查项的dict_value) */
    @Excel(name = "字典键值(存储检查项的dict_value)")
    private String dictValue;

    /** 关联爬架卸料平台验收记录表主键ID */
    @Excel(name = "关联爬架卸料平台验收记录表主键ID")
    private Long acceptId;

    /** 检查值(0:不合格;1:合格) */
    @Excel(name = "检查值(0:不合格;1:合格)")
    private Integer checkValue;

    /** 删除标志(0:未删除;1:已删除) */
    private Integer delFlag;

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

    public void setAcceptId(Long acceptId) {
        this.acceptId = acceptId;
    }

    public Long getAcceptId() {
        return acceptId;
    }

    public void setCheckValue(Integer checkValue) {
        this.checkValue = checkValue;
    }

    public Integer getCheckValue() {
        return checkValue;
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
                .append("dictType", getDictType())
                .append("dictValue", getDictValue())
                .append("acceptId", getAcceptId())
                .append("checkValue", getCheckValue())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("delFlag", getDelFlag())
                .toString();
    }
}
