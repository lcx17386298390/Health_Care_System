package com.acm.entity;

import com.acm.annotation.Excel;
import com.acm.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * prescription对象 sys_prescription
 * 
 * @author ruoyi
 * @date 2023-08-01
 */
public class SysPrescription extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 处方id */
    private String id;

    /** 病名 */
    @Excel(name = "病名")
    private String diseaseName;

    /** 患病的简介 */
    @Excel(name = "患病的简介")
    private String diseaseDesc;

    /** 医生姓名 */
    @Excel(name = "医生姓名")
    private String dname;

    /** 患者姓名 */
    @Excel(name = "患者姓名")
    private String pname;

    /** 药瓶信息 */
    @Excel(name = "药瓶信息")
    private String drugs;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setDiseaseName(String diseaseName) 
    {
        this.diseaseName = diseaseName;
    }

    public String getDiseaseName() 
    {
        return diseaseName;
    }
    public void setDiseaseDesc(String diseaseDesc) 
    {
        this.diseaseDesc = diseaseDesc;
    }

    public String getDiseaseDesc() 
    {
        return diseaseDesc;
    }
    public void setDname(String dname) 
    {
        this.dname = dname;
    }

    public String getDname() 
    {
        return dname;
    }
    public void setPname(String pname) 
    {
        this.pname = pname;
    }

    public String getPname() 
    {
        return pname;
    }
    public void setDrugs(String drugs) 
    {
        this.drugs = drugs;
    }

    public String getDrugs() 
    {
        return drugs;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("diseaseName", getDiseaseName())
            .append("diseaseDesc", getDiseaseDesc())
            .append("dname", getDname())
            .append("pname", getPname())
            .append("drugs", getDrugs())
            .toString();
    }
}
