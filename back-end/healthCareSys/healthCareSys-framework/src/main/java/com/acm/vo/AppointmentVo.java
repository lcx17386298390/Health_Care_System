package com.acm.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentVo {


    private String id;
    //预约日期
    private String appointmentDate;
    //预约状态（是否通过）
    private String appointmentStatus;

    //患者姓名
    private String patientName;

    //预约科室信息
    private String appointmentDepartment;
}
