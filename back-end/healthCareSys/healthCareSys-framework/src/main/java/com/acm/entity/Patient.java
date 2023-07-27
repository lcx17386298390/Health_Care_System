package com.acm.entity;


import java.io.Serializable;
import java.util.Objects;

import lombok.*;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * (Patient)表实体类
 *
 * @author makejava
 * @since 2023-07-21 15:10:56
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@TableName("sys_patient")
public class Patient  {
    //患者id@TableId
    private String id;
    //患者邮箱
    private String email;
    //患者用户名
    private String username;
    //患者手机号
    private String phonenumber;
    //患者地址
    private String address;
    //患者性别
    private String sex;
    //患者用户密码
    private String password;
    //患者年龄
    private Integer age;
    //患者身份证号
    private String identityinfo;
    //患者真实姓名
    private String realname;
    //患者头像
    private String avatar;

}

