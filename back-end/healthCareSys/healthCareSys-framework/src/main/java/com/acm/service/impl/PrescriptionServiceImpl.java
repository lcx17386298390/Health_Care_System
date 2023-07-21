package com.acm.service.impl;

import com.acm.entity.Prescription;
import com.acm.mapper.PrescriptionMapper;
import com.acm.service.PrescriptionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * (Prescription)表服务实现类
 *
 * @author makejava
 * @since 2023-07-21 15:10:56
 */
@Service("prescriptionService")
public class PrescriptionServiceImpl extends ServiceImpl<PrescriptionMapper, Prescription> implements PrescriptionService {

}
