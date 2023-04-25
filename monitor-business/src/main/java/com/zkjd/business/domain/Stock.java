package com.zkjd.business.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zkjd.common.annotation.Excel;
import com.zkjd.common.core.domain.BaseEntity;

/**
 * 存货信息对象 tab_stock
 * 
 * @author wangtao
 * @date 2021-11-04
 */
public class Stock extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 发货ID */
    private Long stockId;

    /** 项目ID */
    @Excel(name = "项目ID")
    private Long projectId;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 货物名称 */
    @Excel(name = "货物名称")
    private String goods;

    /** 货物编码 */
    @Excel(name = "货物编码")
    private String goodsCode;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
    private String supplier;

    /** 发货数量 */
    @Excel(name = "发货数量")
    private Long number;

    /** 收货时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "收货时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date receiptTime;

    /** 经办人 */
    @Excel(name = "经办人")
    private String manager;

    /** 删除标记 */
    private Integer delFlag;

    /** 存货类型（1:发货，2:退货） */
    @Excel(name = "存货类型", readConverterExp = "1=:发货，2:退货")
    private Long type;

    public void setStockId(Long stockId) 
    {
        this.stockId = stockId;
    }

    public Long getStockId() 
    {
        return stockId;
    }
    public void setProjectId(Long projectId) 
    {
        this.projectId = projectId;
    }

    public Long getProjectId()
    {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public void setGoods(String goods)
    {
        this.goods = goods;
    }

    public String getGoods()
    {
        return goods;
    }
    public void setGoodsCode(String goodsCode) 
    {
        this.goodsCode = goodsCode;
    }

    public String getGoodsCode() 
    {
        return goodsCode;
    }
    public void setSupplier(String supplier) 
    {
        this.supplier = supplier;
    }

    public String getSupplier() 
    {
        return supplier;
    }
    public void setNumber(Long number) 
    {
        this.number = number;
    }

    public Long getNumber() 
    {
        return number;
    }
    public void setReceiptTime(Date receiptTime) 
    {
        this.receiptTime = receiptTime;
    }

    public Date getReceiptTime() 
    {
        return receiptTime;
    }
    public void setManager(String manager) 
    {
        this.manager = manager;
    }

    public String getManager() 
    {
        return manager;
    }
    public void setDelFlag(Integer delFlag) 
    {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag() 
    {
        return delFlag;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockId=" + stockId +
                ", projectId=" + projectId +
                ", projectName=" + projectName +
                ", goods='" + goods + '\'' +
                ", goodsCode='" + goodsCode + '\'' +
                ", supplier='" + supplier + '\'' +
                ", number=" + number +
                ", receiptTime=" + receiptTime +
                ", manager='" + manager + '\'' +
                ", delFlag=" + delFlag +
                ", type=" + type +
                '}';
    }
}
