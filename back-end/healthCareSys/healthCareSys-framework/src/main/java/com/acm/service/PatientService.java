package com.acm.service;

import com.acm.entity.Patient;
import com.acm.vo.ResponseResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.IOException;
import java.util.List;


/**
 * (Patient)表服务接口
 *
 * @author makejava
 * @since 2023-07-21 15:10:56
 */
public interface PatientService extends IService<Patient> {


    List<Patient> findByRealname(String realname);

    ResponseResult register(Patient patient);

    ResponseResult infoApp(String idNo, String name) throws IOException;

    ResponseResult saveInfo(String realname, String phonenumber, String sex, String email, String identityinfo, Integer age, String address, String id);

    ResponseResult transAvatar(String url,String id);

    ResponseResult getInfo(String username);
}
