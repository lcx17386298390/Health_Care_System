package com.acm.entity;

import java.math.BigDecimal;

import com.acm.annotation.Excel;
import com.acm.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 药品信息对象 sys_drug
 * 
 * @author ruoyi
 * @date 2023-07-28
 */
public class SysDrug extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 药品id */
    @TableId(type= IdType.ASSIGN_UUID)
    private String id;

    /** 药品名字 */
    @Excel(name = "药品名字")
    private String drugName;

    /** 药品价格 */
    @Excel(name = "药品价格")
    private BigDecimal drugPrice;

    /** 药品数量 */
    @Excel(name = "药品数量")
    private Long drugNums;

    /** 药品用法 */
    @Excel(name = "药品用法")
    private String drugUsage;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setDrugName(String drugName) 
    {
        this.drugName = drugName;
    }

    public String getDrugName() 
    {
        return drugName;
    }
    public void setDrugPrice(BigDecimal drugPrice) 
    {
        this.drugPrice = drugPrice;
    }

    public BigDecimal getDrugPrice() 
    {
        return drugPrice;
    }
    public void setDrugNums(Long drugNums) 
    {
        this.drugNums = drugNums;
    }

    public Long getDrugNums() 
    {
        return drugNums;
    }
    public void setDrugUsage(String drugUsage) 
    {
        this.drugUsage = drugUsage;
    }

    public String getDrugUsage() 
    {
        return drugUsage;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("drugName", getDrugName())
            .append("drugPrice", getDrugPrice())
            .append("drugNums", getDrugNums())
            .append("drugUsage", getDrugUsage())
            .toString();
    }
}
