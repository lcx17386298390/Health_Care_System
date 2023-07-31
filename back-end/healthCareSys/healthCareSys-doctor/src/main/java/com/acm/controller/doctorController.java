package com.acm.controller;

import com.acm.entity.Doctor;
import com.acm.entity.Patient;
import com.acm.enums.AppHttpCodeEnum;
import com.acm.exception.SystemException;
import com.acm.service.DoctorService;
import com.acm.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class doctorController {

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
}
