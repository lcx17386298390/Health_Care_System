package com.acm.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientInfoVo {

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
    private Integer age;
    //患者身份证号
    private String identityinfo;
    //患者真实姓名
    private String realname;
}
