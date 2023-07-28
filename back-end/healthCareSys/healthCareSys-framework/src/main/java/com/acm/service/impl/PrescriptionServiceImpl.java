package com.acm.service.impl;

import com.acm.entity.Disease;
import com.acm.entity.Prescription;
import com.acm.enums.AppHttpCodeEnum;
import com.acm.mapper.PrescriptionMapper;
import com.acm.service.PrescriptionService;
import com.acm.utils.BeanCopyUtils;
import com.acm.vo.PrescriptionVo;
import com.acm.vo.ResponseResult;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Prescription)表服务实现类
 *
 * @author makejava
 * @since 2023-07-21 15:10:56
 */
@Service("prescriptionService")
public class PrescriptionServiceImpl extends ServiceImpl<PrescriptionMapper, Prescription> implements PrescriptionService {

    @Resource
    private PrescriptionMapper prescriptionMapper;

    @Override
    public ResponseResult getPrescriptionById(String prescriptionId) {
        LambdaQueryWrapper<Prescription> queryWrapper =new LambdaQueryWrapper<>();
        queryWrapper.eq(Prescription::getId,prescriptionId);
        Prescription prescription=prescriptionMapper.selectOne(queryWrapper);
        if(prescription!=null){
            PrescriptionVo prescriptionVo= BeanCopyUtils.copyBean(prescription,PrescriptionVo.class);
            return ResponseResult.okResult(prescriptionVo);
        }else {
            return ResponseResult.errorResult(AppHttpCodeEnum.APPOINTDATE_NOT_NULL);
        }
    }

}
