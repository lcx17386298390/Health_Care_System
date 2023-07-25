package com.acm.controller;


import com.acm.entity.Appointment;
import com.acm.service.AppointmentService;
import com.acm.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class appointController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/appoint")
    public ResponseResult appointRegister(Appointment appointment){
        return appointmentService.appointRegister(appointment);
    }


}
