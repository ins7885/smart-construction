package com.zkjd.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zkjd.common.annotation.Excel;
import com.zkjd.common.core.domain.BaseEntity;

/**
 * 升降脚手架提升作业前检查子对象 tab_rise_check_sub
 *
 * @author zkjd
 * @date 2021-12-01
 */
public class RiseCheckSub extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 字典类型(存储检查类别:升降脚手架提升作业前检查) */
    @Excel(name = "字典类型(存储检查类别:升降脚手架提升作业前检查)")
    private String dictType;

    /** 字典键值(存储检查项的dict_value) */
    @Excel(name = "字典键值(存储检查项的dict_value)")
    private String dictValue;

    /** 删除标志 */
    private Integer delFlag;

    /** 关联升降脚手架提升作业前检查表ID */
    @Excel(name = "关联升降脚手架提升作业前检查表ID")
    private Long riseCheckId;

    /** 检查值(0:不合格;1:合格) */
    @Excel(name = "检查值(0:不合格;1:合格)")
    private Integer checkValue;

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

    public void setRiseCheckId(Long riseCheckId) {
        this.riseCheckId = riseCheckId;
    }

    public Long getRiseCheckId() {
        return riseCheckId;
    }

    public void setCheckValue(Integer checkValue) {
        this.checkValue = checkValue;
    }

    public Integer getCheckValue() {
        return checkValue;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("dictType", getDictType())
                .append("dictValue", getDictValue())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("delFlag", getDelFlag())
                .append("riseCheckId", getRiseCheckId())
                .append("checkValue", getCheckValue())
                .toString();
    }
}
