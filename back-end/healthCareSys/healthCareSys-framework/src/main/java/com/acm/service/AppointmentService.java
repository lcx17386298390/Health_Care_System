package com.acm.service;

import com.acm.entity.Appointment;
import com.acm.vo.ResponseResult;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 * (Appointment)表服务接口
 *
 * @author makejava
 * @since 2023-07-21 15:11:24
 */
public interface AppointmentService extends IService<Appointment> {

    ResponseResult appointRegister(Appointment appointment);

    ResponseResult getappointmentBydname(Integer pageNum, Integer pageSize, String docName);

    ResponseResult getappointstatus(String orderId,String status);

    ResponseResult getAcceptappointmentBydname(Integer pageNum, Integer pageSize, String docName);
    ResponseResult appointmentrevise(String appointmentId, String status);
}
