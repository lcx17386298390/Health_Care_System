package com.acm.service.impl;

import com.acm.entity.Doctor;
import com.acm.entity.LoginDoc;
import com.acm.entity.LoginUser;
import com.acm.entity.Patient;
import com.acm.mapper.DoctorMapper;
import com.acm.mapper.PatientMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PatientMapper patientMapper;


    @Autowired
    private DoctorMapper doctorMapper;
    /**
     * 用户名密码检测
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<Patient> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Patient::getUsername, username);
        LambdaQueryWrapper<Doctor> queryWrapper1 = new LambdaQueryWrapper<>();
        queryWrapper1.eq(Doctor::getUsername, username);
       Patient patient = patientMapper.selectOne(queryWrapper);
        Doctor doctor = doctorMapper.selectOne(queryWrapper1);
        if(Objects.isNull(patient) && Objects.isNull(doctor)){
            throw new RuntimeException("用户不存在");
        }
        if(Objects.isNull(doctor)){
            return new LoginUser(patient);
        }else{
            return new LoginDoc(doctor);
        }
    }
}
