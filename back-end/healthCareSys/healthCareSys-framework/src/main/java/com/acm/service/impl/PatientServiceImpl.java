package com.acm.service.impl;

import com.acm.entity.Patient;
import com.acm.enums.AppHttpCodeEnum;
import com.acm.exception.SystemException;
import com.acm.mapper.PatientMapper;
import com.acm.service.PatientService;
import com.acm.vo.ResponseResult;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * (Patient)表服务实现类
 *
 * @author makejava
 * @since 2023-07-21 15:10:56
 */
@Service("patientService")
public class PatientServiceImpl extends ServiceImpl<PatientMapper, Patient> implements PatientService {

    @Autowired
    private PatientMapper patientMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 用户注册
     * @param patient
     * @return
     */
    @Override
    public ResponseResult register(Patient patient){ //对数据进行非空判断
        if(!StringUtils.hasText(patient.getUsername())){
            throw new SystemException(AppHttpCodeEnum.USERNAME_NOT_NULL);
        }
        if(!StringUtils.hasText(patient.getPassword())){
            throw new SystemException(AppHttpCodeEnum.PASSWORD_NOT_NULL);
        }
        if(!StringUtils.hasText(patient.getEmail())){
            throw new SystemException(AppHttpCodeEnum.EMAIL_NOT_NULL);
        }
        if(!StringUtils.hasText(patient.getRealname())){
            throw new SystemException(AppHttpCodeEnum.NICKNAME_NOT_NULL);
        }
        //对数据进行是否存在的判断
        if(userNameExist(patient.getUsername())){
            throw new SystemException(AppHttpCodeEnum.USERNAME_EXIST);
        }
        if(nickNameExist(patient.getRealname())){
            throw new SystemException(AppHttpCodeEnum.NICKNAME_EXIST);
        }
        //...
        //对密码进行加密
        String encodePassword = passwordEncoder.encode(patient.getPassword());
        patient.setPassword(encodePassword);
        //存入数据库
        save(patient);
        return ResponseResult.okResult();






    }


    @Override
    public List<Patient> findByRealname(String realname) {
        LambdaQueryWrapper<Patient> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Patient::getRealname, realname);
        return patientMapper.selectList(queryWrapper);
    }


    private boolean userNameExist(String userName) {
        LambdaQueryWrapper<Patient> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Patient::getUsername,userName);
        return count(queryWrapper) > 0;
    }

    private boolean nickNameExist(String nickName) {
        LambdaQueryWrapper<Patient> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Patient::getRealname,nickName);
        return count(queryWrapper) > 0;
    }


}
