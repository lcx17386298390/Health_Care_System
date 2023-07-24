package com.acm.service.impl;

import com.acm.entity.Patient;
import com.acm.mapper.PatientMapper;
import com.acm.service.PatientService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * (Patient)表服务实现类
 *
 * @author makejava
 * @since 2023-07-21 15:10:56
 */
@Service("patientService")
public class PatientServiceImpl extends ServiceImpl<PatientMapper, Patient> implements PatientService {

}
