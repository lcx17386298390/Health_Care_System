package com.acm.controller;

import com.acm.service.DrugService;
import com.acm.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DrugController {
    @Autowired
    private DrugService drugService;

    @RequestMapping("/getUsageDrugs")
    public ResponseResult getUsageDrugs(Integer pageNum,Integer pageSize,String drugUsage){
        ResponseResult result =drugService.getUsageDrugs(pageNum,pageSize,drugUsage);
        return result;
    }



}
