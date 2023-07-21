package com.acm.service.impl;

import com.acm.entity.Doctor;
import com.acm.mapper.DoctorMapper;
import com.acm.service.DoctorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * (Doctor)表服务实现类
 *
 * @author makejava
 * @since 2023-07-21 15:10:56
 */
@Service("doctorService")
public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor> implements DoctorService {

}
