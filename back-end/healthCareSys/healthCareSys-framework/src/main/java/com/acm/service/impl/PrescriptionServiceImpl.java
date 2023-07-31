package com.acm.service.impl;

import com.acm.entity.Doctor;
import com.acm.entity.Patient;
import com.acm.entity.Prescription;
import com.acm.enums.AppHttpCodeEnum;
import com.acm.mapper.DoctorMapper;
import com.acm.mapper.PatientMapper;
import com.acm.mapper.PrescriptionMapper;
import com.acm.service.PrescriptionService;
import com.acm.utils.BeanCopyUtils;
import com.acm.vo.PrescriptionVo;
import com.acm.vo.ResponseResult;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.jdbc.Null;
import org.springframework.security.access.method.P;
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

    @Resource
    private PatientMapper patientMapper;
    @Resource
    private DoctorMapper doctorMapper;

    //查询处方单
    @Override
    public ResponseResult getPrescriptionById(String prescriptionId) {
        LambdaQueryWrapper<Prescription> queryWrapper =new LambdaQueryWrapper<>();
        queryWrapper.eq(Prescription::getId,prescriptionId);
        Prescription prescription=prescriptionMapper.selectOne(queryWrapper);
        if(prescription!=null){
            PrescriptionVo prescriptionVo= BeanCopyUtils.copyBean(prescription,PrescriptionVo.class);
            return ResponseResult.okResult(prescriptionVo);
        }else {
            return ResponseResult.errorResult(AppHttpCodeEnum.PRESCRIPTION_NOT_NULL);
        }
    }
//    添加处方单
    @Override
    public ResponseResult addPrescription(String diseaseId,String diseaseName,
                                          String diseaseDesc,String did,
                                          String pid,
                                          String drugs){

        // 根据did和pid查询患者姓名和医生姓名
        Doctor doctor = doctorMapper.selectById(did);
        Patient patient = patientMapper.selectById(pid);

        if (doctor == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.DOCTOR_NOT_EXIST);
        }
        if(patient == null){
            return ResponseResult.errorResult(AppHttpCodeEnum.PATIENT_NOT_EXIST);
        }

        Prescription prescription = new Prescription();
        prescription.setDiseaseId(diseaseId);
        prescription.setDiseaseName(diseaseName);
        prescription.setPname(patient.getRealname());
        prescription.setDname(doctor.getRealname());
        prescription.setDiseaseDesc(diseaseDesc);
        prescription.setDid(did);
        prescription.setPid(pid);
        prescription.setDrugs(drugs);

        int result = prescriptionMapper.insert(prescription);
        if (result > 0) {
            return ResponseResult.okResult(AppHttpCodeEnum.ADDPRESCRIPTION_YES);
        } else {
            return ResponseResult.errorResult(AppHttpCodeEnum.ADDPRESCRIPTION_NOT);
        }
    }


    //修改处方单

    @Override
    public ResponseResult previse(String prescriptionId,String diseaseId,
                                  String diseaseName, String diseaseDesc,
                                  String did, String pid, String drugs) {
        Prescription prescription=prescriptionMapper.selectById(prescriptionId);
        if(prescription== null){
            return ResponseResult.errorResult(AppHttpCodeEnum.PRESCRIPTION_NOT_NULL);
        }
        if(diseaseId!=null){
            prescription.setDiseaseId(diseaseId);
        }
        if(diseaseName!=null){
            prescription.setDiseaseName(diseaseName);
        }
        if(diseaseDesc!=null){
            prescription.setDiseaseDesc(diseaseDesc);
        }
        if(drugs!=null){
            prescription.setDrugs(drugs);
        }
        if(did!=null){
            prescription.setDid(did);
        }
        if(pid!=null){
            prescription.setPid(pid);
        }

        int result=prescriptionMapper.updateById(prescription);
        if(result>0){
            return ResponseResult.okResult(AppHttpCodeEnum.REVISE_YES);
        }else {
            return ResponseResult.errorResult(AppHttpCodeEnum.REVISE_NOT);
        }
    }

}
