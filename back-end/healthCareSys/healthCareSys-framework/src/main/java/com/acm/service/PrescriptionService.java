package com.acm.service;

import com.acm.entity.Prescription;
import com.acm.vo.ResponseResult;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 * (Prescription)表服务接口
 *
 * @author makejava
 * @since 2023-07-21 15:10:56
 */
public interface PrescriptionService extends IService<Prescription> {

    ResponseResult getPrescriptionById(String prescriptionId);
}
