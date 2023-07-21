package com.acm.service.impl;

import com.acm.entity.Appointment;
import com.acm.mapper.AppointmentMapper;
import com.acm.service.AppointmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * (Appointment)表服务实现类
 *
 * @author makejava
 * @since 2023-07-21 15:11:24
 */
@Service("appointmentService")
public class AppointmentServiceImpl extends ServiceImpl<AppointmentMapper, Appointment> implements AppointmentService {

}
