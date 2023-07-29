package com.acm.entity;

import com.acm.annotation.Excel;
import com.acm.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 患者信息对象 sys_patient
 * 
 * @author ruoyi
 * @date 2023-07-28
 */
public class SysPatient extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 患者id */
    @TableId(type= IdType.ASSIGN_UUID)
    private String id;

    /** 患者邮箱 */
    @Excel(name = "患者邮箱")
    private String email;

    /** 患者用户名 */
    @Excel(name = "患者用户名")
    private String username;

    /** 患者手机号 */
    @Excel(name = "患者手机号")
    private String phonenumber;

    /** 患者地址 */
    @Excel(name = "患者地址")
    private String address;

    /** 患者性别 */
    @Excel(name = "患者性别")
    private String sex;

    /** 患者用户密码 */
    @Excel(name = "患者用户密码")
    private String password;

    /** 患者年龄 */
    @Excel(name = "患者年龄")
    private Integer age;

    /** 患者身份证号 */
    @Excel(name = "患者身份证号")
    private String identityinfo;

    /** 患者真实姓名 */
    @Excel(name = "患者真实姓名")
    private String realname;

    /** 头像 */
    @Excel(name = "头像")
    private String avatar;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setPhonenumber(String phonenumber) 
    {
        this.phonenumber = phonenumber;
    }

    public String getPhonenumber() 
    {
        return phonenumber;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setAge(Integer age) 
    {
        this.age = age;
    }

    public Integer getAge() 
    {
        return age;
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
    public void setAvatar(String avatar) 
    {
        this.avatar = avatar;
    }

    public String getAvatar() 
    {
        return avatar;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("email", getEmail())
            .append("username", getUsername())
            .append("phonenumber", getPhonenumber())
            .append("address", getAddress())
            .append("sex", getSex())
            .append("password", getPassword())
            .append("age", getAge())
            .append("identityinfo", getIdentityinfo())
            .append("realname", getRealname())
            .append("avatar", getAvatar())
            .toString();
    }
}
