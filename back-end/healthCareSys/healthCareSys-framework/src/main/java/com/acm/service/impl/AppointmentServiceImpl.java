package com.acm.service.impl;

import com.acm.entity.Appointment;
import com.acm.enums.AppHttpCodeEnum;
import com.acm.exception.SystemException;
import com.acm.mapper.AppointmentMapper;
import com.acm.service.AppointmentService;
import com.acm.vo.ResponseResult;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (Appointment)表服务实现类
 *
 * @author makejava
 * @since 2023-07-21 15:11:24
 */
@Service("appointmentService")
public class AppointmentServiceImpl extends ServiceImpl<AppointmentMapper, Appointment> implements AppointmentService {

    @Autowired
    private AppointmentMapper appointmentMapper;

    /**
     * 用户预约挂号
     * @param appointment
     * @return
     */
    @Override
    public ResponseResult appointRegister(Appointment appointment) {
        if(appointment.getAppointmentDate() == null){
            throw new SystemException(AppHttpCodeEnum.APPOINTDATE_NOT_NULL);
        }
        if(appointment.getDoctorName() == null){
            throw new SystemException(AppHttpCodeEnum.DOCTORNAME_NOT_NULL);
        }
        appointment.setAppointmentStatus(AppHttpCodeEnum.SUCCESS.getMsg());
        appointmentMapper.insert(appointment);
        return ResponseResult.okResult();
    }
}
