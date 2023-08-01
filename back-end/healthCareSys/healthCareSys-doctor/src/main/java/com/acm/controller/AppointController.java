package com.acm.controller;


import com.acm.service.AppointmentService;
import com.acm.vo.ResponseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/doctor")
public class AppointController {


    @Resource
    private AppointmentService appointmentService;

//    查询就诊记录
    @RequestMapping("/getappointmentBydname")
    public ResponseResult getappointmentBydname(Integer pageNum,Integer pageSize,String docName){
        return appointmentService.getappointmentBydname(pageNum,pageSize,docName);
    }

    //appointstatus
    @RequestMapping("/appointstatus")
    public ResponseResult getappointstatus(String orderId,String status){
        return appointmentService.getappointstatus(orderId,status);
    }

    @RequestMapping("/getAcceptappointmentBydname")
    public ResponseResult getAcceptappointmentBydname(Integer pageNum,Integer pageSize,String docName){
        return appointmentService.getAcceptappointmentBydname(pageNum,pageSize,docName);
    }
}
