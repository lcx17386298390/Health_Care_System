package com.acm.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorVo {

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
    //医生真实姓名
    private String realname;
    //医生身份证号
    private String identityinfo;
}
