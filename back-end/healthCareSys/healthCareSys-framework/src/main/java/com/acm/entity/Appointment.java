package com.acm.entity;

import java.sql.Timestamp;
import java.util.Date;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("sys_appointment")
public class Appointment  {
    //预约id@TableId
    @TableId(type=IdType.ASSIGN_UUID)
    private String id;

    //预约日期
    private String appointmentDate;
    //预约状态（是否通过）
    private String appointmentStatus;
    //医生姓名
    private String doctorName;
    //患者姓名
    private String patientName;
    //预约科室信息
    private String appointmentDepartment;



}

