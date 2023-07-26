package com.acm.service;

import com.acm.entity.Patient;
import com.acm.vo.ResponseResult;

public interface PatientLoginService {

    ResponseResult login(Patient patient);

    ResponseResult logout();

}
