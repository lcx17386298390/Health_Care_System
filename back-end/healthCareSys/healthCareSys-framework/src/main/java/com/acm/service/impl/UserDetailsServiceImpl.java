package com.acm.service.impl;

import com.acm.entity.LoginUser;
import com.acm.entity.Patient;
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
       Patient patient = patientMapper.selectOne(queryWrapper);
        if(Objects.isNull(patient)){
            throw new RuntimeException("用户不存在");
        }
        return new LoginUser(patient);
    }
}
