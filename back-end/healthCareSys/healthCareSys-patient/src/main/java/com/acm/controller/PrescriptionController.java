package com.acm.controller;


import com.acm.service.PrescriptionService;
import com.acm.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/prescription")
public class PrescriptionController {


    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @RequestMapping("/getPrescriptionById")
    public ResponseResult getPrescriptionById(String prescriptionId){
        return prescriptionService.getPrescriptionById(prescriptionId);
    }

}
