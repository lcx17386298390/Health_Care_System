package com.acm.controller;

import com.acm.service.DiseaseService;
import com.acm.vo.ResponseResult;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class diseaseInfoController {

    @Autowired
    private DiseaseService diseaseService;



    @GetMapping("/diseaseInfo")
    public ResponseResult diseaseInfo(Integer pageNo,Integer pageSize,String patientId){
        return diseaseService.diseaseInfo(pageNo,pageSize,patientId);
    }

}
