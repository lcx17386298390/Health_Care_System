package com.acm.service.impl;

import com.acm.entity.Disease;
import com.acm.entity.Doctor;
import com.acm.entity.Patient;
import com.acm.entity.Prescription;
import com.acm.enums.AppHttpCodeEnum;
import com.acm.mapper.DiseaseMapper;
import com.acm.mapper.DoctorMapper;
import com.acm.mapper.PatientMapper;
import com.acm.service.DiseaseService;
import com.acm.utils.BeanCopyUtils;
import com.acm.vo.DiseaseInfoVo;
import com.acm.vo.ResponseResult;
import com.alibaba.excel.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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

    @Resource
    private DiseaseMapper diseaseMapper;
    @Resource
    private DoctorMapper doctorMapper;
    @Resource
    private PatientMapper patientMapper;

//    查询病例
    @Override
    public ResponseResult diseaseInfo(Integer pageNo, Integer pageSize, String patientId) {
        LambdaQueryWrapper<Disease> queryWrapper = new LambdaQueryWrapper<>();
        Page<Disease> page = new Page(pageNo, pageSize);
        queryWrapper.eq(Disease::getPid,patientId);
        page(page,queryWrapper);
        List<DiseaseInfoVo> diseaseInfoList = BeanCopyUtils.copyBeanList(page.getRecords(), DiseaseInfoVo.class);
        return ResponseResult.okResult(diseaseInfoList);
    }

//    添加病例单
    @Override
    public ResponseResult adddisease(String pid, String diseasename, Data data, String did) {

        Doctor doctor = doctorMapper.selectById(did);

        Patient patient = patientMapper.selectById(pid);
        if (doctor == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.DOCTOR_NOT_EXIST);
        }
        if(patient == null){
            return ResponseResult.errorResult(AppHttpCodeEnum.PATIENT_NOT_EXIST);
        }
        Disease disease=new Disease();
        disease.setDiseaseName(diseasename);
        disease.setPid(pid);
        disease.setDname(doctor.getRealname());
        disease.setPname(patient.getRealname());
        disease.setClinicDate((Date) data);
        int result=diseaseMapper.insert(disease);
        if(result>0){
            return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
        }else {
            return ResponseResult.errorResult(AppHttpCodeEnum.CASES_NOT_NULL);
        }
    }
    //    只有医生可以修改病例病名
    @Override
    public ResponseResult diseaserevise(String pidId , String diseaseName) {
        try {
            // 校验参数
            if (StringUtils.isEmpty(pidId) || StringUtils.isEmpty(diseaseName)) {
                return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NULL);
            }

            LambdaQueryWrapper<Disease> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(Disease::getPid, pidId);
            Disease disease = diseaseMapper.selectOne(queryWrapper);
            if (disease == null) {
                return ResponseResult.errorResult(AppHttpCodeEnum.CASES_NULL);
            }
            disease.setDiseaseName(diseaseName);
            int result = diseaseMapper.updateById(disease);
            if (result > 0) {
                return ResponseResult.okResult(AppHttpCodeEnum.REVISE_YES);
            } else {
                return ResponseResult.errorResult(AppHttpCodeEnum.REVISE_NOT);
            }
        }catch (Exception e) {
                // 异常处理，返回错误信息
                return ResponseResult.errorResult(AppHttpCodeEnum.valueOf(AppHttpCodeEnum.REVISE_NOT+ e.getMessage()));
            }

        }


}
