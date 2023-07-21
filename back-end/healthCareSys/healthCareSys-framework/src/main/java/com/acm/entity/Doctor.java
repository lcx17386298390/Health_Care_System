package com.acm.entity;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Doctor)表实体类
 *
 * @author makejava
 * @since 2023-07-21 15:10:56
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_doctor")
public class Doctor  {
    //医生id@TableId
    private String id;

    //医生用户名
    private String username;
    //医生性别
    private String gender;
    //医生手机电话号码
    private String phonenumber;
    //医生邮箱
    private String email;
    //医生密码
    private String password;
    //医生资历
    private String qualification;
    //所属科室
    private String department;
    //医生身份证号
    private String identityinfo;
    //医生真实姓名
    private String realname;



}

