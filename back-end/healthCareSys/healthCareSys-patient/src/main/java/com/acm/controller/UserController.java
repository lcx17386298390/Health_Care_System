package com.acm.controller;

import com.acm.entity.Patient;
import com.acm.service.PatientService;
import com.acm.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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


    @PostMapping("/infoApp")
    public ResponseResult infoApp(String idNo,String name) throws IOException {
        return patientService.infoApp(idNo,name);
    }

    @PostMapping("/saveinfo")
    public ResponseResult saveInfo(String realname,String phonenumber
                                    ,String sex,String email,
                                   String identityinfo,Integer age,
                                String address,String id){
        return patientService.saveInfo(realname,phonenumber,sex,email,identityinfo,age,address,id);
    }

    @PostMapping("/transAvatar")
    public ResponseResult transAvatar(String url,String id){
        return patientService.transAvatar(url,id);
    }

    @GetMapping("/getinfo")
    public ResponseResult getinfo(String username){
        return patientService.getInfo(username);
    }
}
