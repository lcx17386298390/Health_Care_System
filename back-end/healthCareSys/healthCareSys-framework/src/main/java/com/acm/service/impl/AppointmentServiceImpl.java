package com.acm.service.impl;

import com.acm.entity.Appointment;
import com.acm.enums.AppHttpCodeEnum;
import com.acm.exception.SystemException;
import com.acm.mapper.AppointmentMapper;
import com.acm.service.AppointmentService;
import com.acm.utils.BeanCopyUtils;
import com.acm.vo.AppointmentVo;
import com.acm.vo.ResponseResult;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Appointment)表服务实现类
 *
 * @author makejava
 * @since 2023-07-21 15:11:24
 */
@Service("appointmentService")
public class AppointmentServiceImpl extends ServiceImpl<AppointmentMapper, Appointment> implements AppointmentService {

    @Autowired
    private AppointmentMapper appointmentMapper;

    /**
     * 用户预约挂号
     * @param appointment
     * @return
     */
    @Override
    public ResponseResult appointRegister(Appointment appointment) {
        if(appointment.getAppointmentDate() == null){
            throw new SystemException(AppHttpCodeEnum.APPOINTDATE_NOT_NULL);
        }
        if(appointment.getDoctorName() == null){
            throw new SystemException(AppHttpCodeEnum.DOCTORNAME_NOT_NULL);
        }
        appointment.setAppointmentStatus(AppHttpCodeEnum.SUCCESS.getMsg());
        appointmentMapper.insert(appointment);
        return ResponseResult.okResult();
    }

    //    查询就诊记录

    @Override
    public ResponseResult getappointmentBydname(Integer pageNum, Integer pageSize, String docName) {
        if (pageNum == null || pageNum <= 0) {
            pageNum = 1;
        }
        if (pageSize == null || pageSize <= 0) {
            pageSize = 10;
        }

        Page<Appointment> page = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<Appointment> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Appointment::getDoctorName, docName);

        IPage<Appointment> appointmentPage = appointmentMapper.selectPage(page, queryWrapper);
        List<AppointmentVo> appointmentVos = BeanCopyUtils.copyBeanList(appointmentPage.getRecords(), AppointmentVo.class);

        // 判断查询结果是否为空
        if (appointmentVos.isEmpty()) {
            return ResponseResult.errorResult(AppHttpCodeEnum.APPOINTMENT_NULL);
        } else {
            return ResponseResult.okResult(appointmentVos);
        }
    }
}
