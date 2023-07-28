package com.acm.service.impl;

import com.acm.entity.Doctor;
import com.acm.enums.AppHttpCodeEnum;
import com.acm.mapper.DoctorMapper;
import com.acm.service.DoctorService;
import com.acm.utils.BeanCopyUtils;
import com.acm.vo.DoctorsByDepartmentVo;
import com.acm.vo.ResponseResult;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * (Doctor)表服务实现类
 *
 * @author makejava
 * @since 2023-07-21 15:10:56
 */
@Service("doctorService")
public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor> implements DoctorService {


    @Resource
    private DoctorMapper doctorMapper;

    //    根据科室来查询医生
    @Override
    public ResponseResult getDoctorsByDepartment(String departmentname) {
        LambdaQueryWrapper<Doctor> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(Doctor::getDepartment,departmentname);
        List<Doctor> doctors = doctorMapper.selectList(queryWrapper);
        List<DoctorsByDepartmentVo> doctorsByDepartmentVos = new ArrayList<>();
        if(doctors!=null){
            doctorsByDepartmentVos= BeanCopyUtils.copyBeanList(doctors,DoctorsByDepartmentVo.class);
            return ResponseResult.okResult(doctorsByDepartmentVos);
        }else {
            return ResponseResult.errorResult(AppHttpCodeEnum.DOCTOR_DEPARTMENT_NOT_NULL);
        }
    }
}
