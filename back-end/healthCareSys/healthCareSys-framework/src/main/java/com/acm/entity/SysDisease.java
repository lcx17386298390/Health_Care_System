package com.acm.entity;

import java.util.Date;

import com.acm.annotation.Excel;
import com.acm.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 患者病历对象 sys_disease
 * 
 * @author ruoyi
 * @date 2023-07-28
 */
public class SysDisease extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 疾病id */
    @TableId(type= IdType.ASSIGN_UUID)
    private String id;

    /** 患者id */
    @Excel(name = "患者id")
    private String pid;

    /** 患者姓名 */
    @Excel(name = "患者姓名")
    private String pname;

    /** 患者病名 */
    @Excel(name = "患者病名")
    private String diseaseName;

    /** 接诊时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "接诊时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date clinicDate;

    /** 接诊医生id */
    @Excel(name = "接诊医生id")
    private String did;

    /** 接诊医生姓名 */
    @Excel(name = "接诊医生姓名")
    private String dname;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setPid(String pid) 
    {
        this.pid = pid;
    }

    public String getPid() 
    {
        return pid;
    }
    public void setPname(String pname) 
    {
        this.pname = pname;
    }

    public String getPname() 
    {
        return pname;
    }
    public void setDiseaseName(String diseaseName) 
    {
        this.diseaseName = diseaseName;
    }

    public String getDiseaseName() 
    {
        return diseaseName;
    }
    public void setClinicDate(Date clinicDate) 
    {
        this.clinicDate = clinicDate;
    }

    public Date getClinicDate() 
    {
        return clinicDate;
    }
    public void setDid(String did) 
    {
        this.did = did;
    }

    public String getDid() 
    {
        return did;
    }
    public void setDname(String dname) 
    {
        this.dname = dname;
    }

    public String getDname() 
    {
        return dname;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("pid", getPid())
            .append("pname", getPname())
            .append("diseaseName", getDiseaseName())
            .append("clinicDate", getClinicDate())
            .append("did", getDid())
            .append("dname", getDname())
            .toString();
    }
}
