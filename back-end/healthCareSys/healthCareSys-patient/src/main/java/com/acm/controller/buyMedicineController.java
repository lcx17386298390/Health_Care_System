package com.acm.controller;


import com.acm.service.DrugService;
import com.acm.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class buyMedicineController {


    @Autowired
    private DrugService drugService;


    @GetMapping("/druglist")
    public ResponseResult buyDrug(Integer pageNum,Integer pageSize){
        return  drugService.druglist(pageNum,pageSize);
    }


}
