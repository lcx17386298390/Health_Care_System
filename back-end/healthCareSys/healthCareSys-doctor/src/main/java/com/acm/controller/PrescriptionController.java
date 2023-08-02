package com.acm.controller;


import com.acm.service.PrescriptionService;
import com.acm.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/doctor")
public class PrescriptionController {


    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    //查询处方单
    @RequestMapping("/getPrescriptionById")
    public ResponseResult getPrescriptionById(String prescriptionId){
        return prescriptionService.getPrescriptionById(prescriptionId);
    }

    //添加处方单
    @RequestMapping("/addPrescription")
    public ResponseResult addPrescription(
            String diseaseName,
            String pname,
            String dname,
            String diseaseDesc,
            String drugs){
        return prescriptionService.addPrescription(diseaseName,pname,dname,diseaseDesc,drugs);
    }
    @RequestMapping("/previse")
    public ResponseResult previse(
                                    String prescriptionId,
                                    String diseaseName,
                                    String diseaseDesc,String drugs){
        return prescriptionService.previse(prescriptionId,diseaseName,diseaseDesc,drugs);
    }



}
