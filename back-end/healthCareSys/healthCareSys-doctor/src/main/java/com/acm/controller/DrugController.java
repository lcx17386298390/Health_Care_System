package com.acm.controller;

import com.acm.service.DrugService;
import com.acm.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DrugController {
    @Autowired
    private DrugService drugService;

    //    根据用途查询药品,价格升序
    @RequestMapping("/getByAscUsageDrugs")
    public ResponseResult getByAscUsageDrugs(Integer pageNum,Integer pageSize,String drugUsage){
        ResponseResult result =drugService.getByAscUsageDrugs(pageNum,pageSize,drugUsage);
        return result;
    }
    //    根据用途查询药品,价格降序
    @RequestMapping("/getByDescUsageDrugs")
    public ResponseResult getByDescUsageDrugs(Integer pageNum,Integer pageSize,String drugUsage){
        ResponseResult result =drugService.getByDescUsageDrugs(pageNum,pageSize,drugUsage);
        return result;
    }



}
