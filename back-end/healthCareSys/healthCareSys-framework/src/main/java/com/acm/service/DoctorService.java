package com.acm.service;

import com.acm.entity.Doctor;
import com.acm.vo.ResponseResult;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 * (Doctor)表服务接口
 *
 * @author makejava
 * @since 2023-07-21 15:10:56
 */
public interface DoctorService extends IService<Doctor> {

    ResponseResult getDoctorsByDepartment(String department);

    ResponseResult revise(Integer doctorId, String username,
                          String gender, String phonenumber,
                          String email, String password,
                          String qualification, String department,
                          String identityinfo, String realname);

    ResponseResult getDoctorId(Integer doctorId);

    ResponseResult login(Doctor doctor);

    ResponseResult logout();

    ResponseResult register(Doctor doctor);

    ResponseResult changePassword(String doctorId, String currentPassword, String newPassword);
}
