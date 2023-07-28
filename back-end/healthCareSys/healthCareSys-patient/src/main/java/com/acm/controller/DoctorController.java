package com.acm.controller;


import com.acm.service.DoctorService;
import com.acm.vo.ResponseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Resource
    private DoctorService doctorService;

//    根据科室来查询医生
    @RequestMapping("/getDoctorsByDepartment")
    public ResponseResult getDoctorsByDepartment(String departmentname){
        return doctorService.getDoctorsByDepartment(departmentname);
    }


}
