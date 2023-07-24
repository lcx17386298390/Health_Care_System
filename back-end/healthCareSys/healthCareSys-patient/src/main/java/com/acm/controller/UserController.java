package com.acm.controller;

import com.acm.entity.Patient;
import com.acm.service.PatientService;
import com.acm.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private PatientService patientService;
//    @GetMapping("/userinfo")
//    public ResponseResult userinfo(){
//        return patientService.userinfo();
//    }
//
//    @PutMapping("/updateUserInfo")
//    public ResponseResult updateUserInfo(@RequestBody Patient user){
//        return patientService.updateUserInfo(user);
//    }

    @PostMapping("/register")
    public ResponseResult register(@RequestBody Patient patient){
        return patientService.register(patient);
    }
}
