package com.acm.service.impl;


import com.acm.entity.LoginUser;
import com.acm.entity.Patient;
import com.acm.service.PatientLoginService;
import com.acm.utils.BeanCopyUtils;
import com.acm.utils.JwtUtil;
import com.acm.utils.RedisCache;
import com.acm.vo.PatientInfoVo;
import com.acm.vo.PatientLoginInfoVo;
import com.acm.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PatientLoginServiceImpl implements PatientLoginService {

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult login(Patient patient) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(patient.getUsername(), patient.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        if (Objects.isNull(authentication)) {
            throw new RuntimeException("用户名或密码错误");
        }
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        String id = loginUser.getPatient().getId().toString();
        String jwt = JwtUtil.createJWT(id);
        redisCache.setCacheObject("patientlogin:" + id, loginUser);
        PatientInfoVo patientInfoVo = BeanCopyUtils.copyBean(loginUser.getPatient(), PatientInfoVo.class);
        PatientLoginInfoVo patientLoginInfoVo = new PatientLoginInfoVo(patientInfoVo,jwt);
        return ResponseResult.okResult(patientLoginInfoVo);
    }
}
