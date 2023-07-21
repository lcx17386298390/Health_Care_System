package com.acm.entity;

import java.util.Date;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * (Appointment)表实体类
 *
 * @author makejava
 * @since 2023-07-21 15:11:24
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sg_appointment")
public class Appointment  {
    //预约id@TableId
    private String id;

    //医生id
    private String did;
    //病人id
    private String pid;
    //预约日期
    private Date appointmentDate;
    //预约状态（是否通过）
    private String appointmentStatus;
    //医生姓名
    private String doctorName;
    //患者姓名
    private String patientName;
    //预约科室信息
    private String appointmentDepartment;



}

