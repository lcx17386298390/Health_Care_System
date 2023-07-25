package com.acm.service.impl;

import com.acm.entity.Disease;
import com.acm.entity.Patient;
import com.acm.mapper.DiseaseMapper;
import com.acm.service.DiseaseService;
import com.acm.utils.BeanCopyUtils;
import com.acm.vo.DiseaseInfoVo;
import com.acm.vo.ResponseResult;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Disease)表服务实现类
 *
 * @author makejava
 * @since 2023-07-21 15:10:56
 */
@Service("diseaseService")
public class DiseaseServiceImpl extends ServiceImpl<DiseaseMapper, Disease> implements DiseaseService {
    /**
     * 展示病人个人的历史病例
     * @param pageNo
     * @param pageSize
     * @param patientId
     * @return
     */
    @Override
    public ResponseResult diseaseInfo(Integer pageNo, Integer pageSize, String patientId) {
        LambdaQueryWrapper<Disease> queryWrapper = new LambdaQueryWrapper<>();
        Page<Disease> page = new Page(pageNo, pageSize);
        queryWrapper.eq(Disease::getPid,patientId);
        page(page,queryWrapper);
        List<DiseaseInfoVo> diseaseInfoList = BeanCopyUtils.copyBeanList(page.getRecords(), DiseaseInfoVo.class);
        return ResponseResult.okResult(diseaseInfoList);
    }
}
