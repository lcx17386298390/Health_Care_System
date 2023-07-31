package com.acm.entity;

import com.acm.annotation.Excel;
import com.acm.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 科室信息对象 sys_department
 * 
 * @author ruoyi
 * @date 2023-07-28
 */
public class SysDepartment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 科室id */
    @TableId(type= IdType.ASSIGN_UUID)
    private String id;

    /** 科室名 */
    @Excel(name = "科室名")
    private String name;

    /** 医生姓名 */
    @Excel(name = "医生姓名")
    private String dname;

    /** 医生id */
    @Excel(name = "医生id")
    private String did;

    /** 科室挂号数量 */
    @Excel(name = "科室挂号数量")
    private Long orders;

    /** 挂号信息id */
    @Excel(name = "挂号信息id")
    private String aid;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setDname(String dname) 
    {
        this.dname = dname;
    }

    public String getDname() 
    {
        return dname;
    }
    public void setDid(String did) 
    {
        this.did = did;
    }

    public String getDid() 
    {
        return did;
    }
    public void setOrders(Long orders) 
    {
        this.orders = orders;
    }

    public Long getOrders() 
    {
        return orders;
    }
    public void setAid(String aid) 
    {
        this.aid = aid;
    }

    public String getAid() 
    {
        return aid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("dname", getDname())
            .append("did", getDid())
            .append("orders", getOrders())
            .append("aid", getAid())
            .toString();
    }
}
