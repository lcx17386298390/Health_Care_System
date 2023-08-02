package com.acm.enums;

public enum AppHttpCodeEnum {
    // 成功
    SUCCESS(200,"操作成功"),
    // 登录
    NEED_LOGIN(401,"需要登录后操作"),
    NO_OPERATOR_AUTH(403,"无权限操作"),
    SYSTEM_ERROR(500,"出现错误"),
    USERNAME_EXIST(501,"用户名已存在"),
    PHONENUMBER_EXIST(502,"手机号已存在"),
    EMAIL_EXIST(503, "邮箱已存在"),
    REQUIRE_USERNAME(504, "必需填写用户名"),
    LOGIN_ERROR(505,"用户名或密码错误"),
    CONTENT_NOT_NULL(506, "内容不能为空"),
    FILE_TYPE_ERROR(507,"文件类型错误!"),
    USERNAME_NOT_NULL(508, "用户名不能为空"),
    NICKNAME_NOT_NULL(509, "昵称不能为空"),
    EMAIL_NOT_NULL(511, "邮箱不能为空"),
    NICKNAME_EXIST(512, "昵称已存在"),
    PASSWORD_NOT_NULL(510, "密码不能为空"),
    APPOINTDATE_NOT_NULL(514,"预约日期不能为空"),
    DOCTORNAME_NOT_NULL(515,"预约医生姓名不能为空"),
//    查询药品
    DRUGS_NOT_NULL(516,"未找到符合该药品用途的药品"),
    PRESCRIPTION_NOT_NULL(517,"还没有处方单"),
    DOCTOR_DEPARTMENT_NOT_NULL(518,"找不到该科室的医生"),
    PATIENT_NOT_EXIST(519,"找不到该患者" ),
    DOCTOR_NOT_EXIST(520,"尚未注册成为医生"),
    ADDPRESCRIPTION_YES(521,"添加处方单成功"),

    ADDPRESCRIPTION_NOT(522,"添加处方单失败"),

    REVISE_YES(523,"信息修改成功"),
    REVISE_NOT(524,"信息修改失败"),
    CASES_NOT_NULL(525,"添加病例单失败"),

    CASES_NULL(526,"找不到该患者的病例单"),
    DATA_NULL(300,"参数不能为空"),
    APPOINTMENT_NULL(527,"目前还没有该医生的预约"),

    WAIT_ACCESS(528,"等待接收"),
    HAVE_ACCESS(529,"通过"),
    DATA_NOT(600,"参数错误"), PASSWORD_ERROR(530,"输入的原密码错误!" );



    int code;
    String msg;

    AppHttpCodeEnum(int code, String errorMessage){
        this.code = code;
        this.msg = errorMessage;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
