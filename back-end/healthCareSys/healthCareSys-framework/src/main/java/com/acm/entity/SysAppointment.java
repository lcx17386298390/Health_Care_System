package com.acm.entity;

import com.acm.annotation.Excel;
import com.acm.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 患者预约对象 sys_appointment
 * 
 * @author ruoyi
 * @date 2023-07-28
 */
public class SysAppointment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 预约id */
    @TableId(type= IdType.ASSIGN_UUID)
    private String id;

    /** 预约日期 */
    @Excel(name = "预约日期")
    private String appointmentDate;

    /** 预约状态（是否通过） */
    @Excel(name = "预约状态", readConverterExp = "是=否通过")
    private String appointmentStatus;

    /** 医生姓名 */
    @Excel(name = "医生姓名")
    private String doctorName;

    /** 患者姓名 */
    @Excel(name = "患者姓名")
    private String patientName;

    /** 预约科室信息 */
    @Excel(name = "预约科室信息")
    private String appointmentDepartment;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setAppointmentDate(String appointmentDate) 
    {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentDate() 
    {
        return appointmentDate;
    }
    public void setAppointmentStatus(String appointmentStatus) 
    {
        this.appointmentStatus = appointmentStatus;
    }

    public String getAppointmentStatus() 
    {
        return appointmentStatus;
    }
    public void setDoctorName(String doctorName) 
    {
        this.doctorName = doctorName;
    }

    public String getDoctorName() 
    {
        return doctorName;
    }
    public void setPatientName(String patientName) 
    {
        this.patientName = patientName;
    }

    public String getPatientName() 
    {
        return patientName;
    }
    public void setAppointmentDepartment(String appointmentDepartment) 
    {
        this.appointmentDepartment = appointmentDepartment;
    }

    public String getAppointmentDepartment() 
    {
        return appointmentDepartment;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("appointmentDate", getAppointmentDate())
            .append("appointmentStatus", getAppointmentStatus())
            .append("doctorName", getDoctorName())
            .append("patientName", getPatientName())
            .append("appointmentDepartment", getAppointmentDepartment())
            .toString();
    }
}
