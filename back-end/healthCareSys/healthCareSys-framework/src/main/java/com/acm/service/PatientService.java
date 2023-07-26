package com.acm.service;

import com.acm.entity.Patient;
import com.acm.vo.ResponseResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


/**
 * (Patient)表服务接口
 *
 * @author makejava
 * @since 2023-07-21 15:10:56
 */
public interface PatientService extends IService<Patient> {


    List<Patient> findByRealname(String realname);

    ResponseResult register(Patient patient);
}
