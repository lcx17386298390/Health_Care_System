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

//    修改记录信息
@RequestMapping("/appointmentrevise")
    public ResponseResult appointmentrevise(String appointmentId ,String status){
        return appointmentService.appointmentrevise(appointmentId,status);
}

}
