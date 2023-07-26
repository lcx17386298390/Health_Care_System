package com.acm.controller;

import com.acm.entity.Patient;
import com.acm.service.PatientService;
import com.acm.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseResult register(Patient patient){
        return patientService.register(patient);
    }

    @RequestMapping("/test")
    public List<Patient> tset(@RequestParam("realname")String realname){
        List<Patient> patients=patientService.findByRealname(realname);
        if (patients!= null && !patients.isEmpty()) {
            for(Patient patient:patients){
                patient.getAddress();
                patient.getPassword();
                patient.getEmail();
                patient.getAge();
                patient.getUsername();
                patient.getId();
                patient.getIdentityinfo();
                patient.getRealname();
                patient.getSex();
                patient.getPhonenumber();
                System.out.println("成功" + " =" + patient);
            }
        }
        return patients;
    }

}
