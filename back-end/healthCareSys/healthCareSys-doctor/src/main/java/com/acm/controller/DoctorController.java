package com.acm.controller;

import com.acm.entity.Doctor;
import com.acm.enums.AppHttpCodeEnum;
import com.acm.exception.SystemException;
import com.acm.service.DoctorService;
import com.acm.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/login")
    public ResponseResult login(Doctor doctor){
      if(!StringUtils.hasText(doctor.getUsername())){
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        return doctorService.login(doctor);
    }

    @PostMapping("/logout")
    public ResponseResult logout(){
        return doctorService.logout();
    }

    @PostMapping("/register")
    public ResponseResult register(Doctor doctor){
        return doctorService.register(doctor);
    }
    //    根据科室来查询医生
    @RequestMapping("/getDoctorsByDepartment")
    public ResponseResult getDoctorsByDepartment(String departmentname){
        return doctorService.getDoctorsByDepartment(departmentname);
    }


//    医生修改个人主页

    @RequestMapping("/docrevise")
    public ResponseResult revise(Integer doctorId,String username,
                                 String gender,String phonenumber,
                                 String email,String password,
                                 String qualification,String department,
                                 String identityinfo,String realname){
        return doctorService.revise(doctorId,username,
                gender,phonenumber,
                email,password,
                qualification,department,
                identityinfo,realname);
    }
//查询医生
    @RequestMapping("/getDoctorId")
    public ResponseResult getDoctorId(Integer doctorId){
        return doctorService.getDoctorId(doctorId);
    }

    @PostMapping("/changepassword")
    public ResponseResult changePassword(String doctorId,String currentPassword,String newPassword){
        return doctorService.changePassword(doctorId,currentPassword,newPassword);
    }

}
