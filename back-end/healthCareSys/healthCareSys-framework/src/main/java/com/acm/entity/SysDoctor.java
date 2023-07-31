package com.acm.entity;

import com.acm.annotation.Excel;
import com.acm.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 医生信息对象 sys_doctor
 * 
 * @author ruoyi
 * @date 2023-07-28
 */
public class SysDoctor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 医生id */
    @TableId(type= IdType.ASSIGN_UUID)
    private String id;

    /** 医生用户名 */
    @Excel(name = "医生用户名")
    private String username;

    /** 医生性别 */
    @Excel(name = "医生性别")
    private String gender;

    /** 医生手机电话号码 */
    @Excel(name = "医生手机电话号码")
    private String phonenumber;

    /** 医生邮箱 */
    @Excel(name = "医生邮箱")
    private String email;

    /** 医生密码 */
    @Excel(name = "医生密码")
    private String password;

    /** 医生资历 */
    @Excel(name = "医生资历")
    private String qualification;

    /** 所属科室 */
    @Excel(name = "所属科室")
    private String department;

    /** 医生身份证号 */
    @Excel(name = "医生身份证号")
    private String identityinfo;

    /** 医生真实姓名 */
    @Excel(name = "医生真实姓名")
    private String realname;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getGender() 
    {
        return gender;
    }
    public void setPhonenumber(String phonenumber) 
    {
        this.phonenumber = phonenumber;
    }

    public String getPhonenumber() 
    {
        return phonenumber;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setQualification(String qualification) 
    {
        this.qualification = qualification;
    }

    public String getQualification() 
    {
        return qualification;
    }
    public void setDepartment(String department) 
    {
        this.department = department;
    }

    public String getDepartment() 
    {
        return department;
    }
    public void setIdentityinfo(String identityinfo) 
    {
        this.identityinfo = identityinfo;
    }

    public String getIdentityinfo() 
    {
        return identityinfo;
    }
    public void setRealname(String realname) 
    {
        this.realname = realname;
    }

    public String getRealname() 
    {
        return realname;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("username", getUsername())
            .append("gender", getGender())
            .append("phonenumber", getPhonenumber())
            .append("email", getEmail())
            .append("password", getPassword())
            .append("qualification", getQualification())
            .append("department", getDepartment())
            .append("identityinfo", getIdentityinfo())
            .append("realname", getRealname())
            .toString();
    }
}
