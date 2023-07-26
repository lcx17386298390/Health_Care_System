package com.acm.controller;

import com.acm.entity.Patient;
import com.acm.enums.AppHttpCodeEnum;
import com.acm.exception.SystemException;
import com.acm.service.PatientLoginService;
import com.acm.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class patientLoginController {

    @Autowired
    private PatientLoginService patientLoginService;

    @PostMapping("/login")
    public ResponseResult login(Patient patient){
      if(!StringUtils.hasText(patient.getUsername())){
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        return patientLoginService.login(patient);
    }

    @PostMapping("/logout")
    public ResponseResult logout(){
        return patientLoginService.logout();
    }
}
