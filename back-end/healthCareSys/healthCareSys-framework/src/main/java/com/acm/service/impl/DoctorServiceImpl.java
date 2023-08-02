package com.acm.service.impl;

import com.acm.entity.Doctor;
import com.acm.entity.LoginDoc;
import com.acm.entity.LoginUser;
import com.acm.entity.Patient;
import com.acm.enums.AppHttpCodeEnum;
import com.acm.exception.SystemException;
import com.acm.mapper.DoctorMapper;
import com.acm.service.DoctorService;
import com.acm.utils.BeanCopyUtils;
import com.acm.utils.JwtUtil;
import com.acm.utils.RedisCache;
import com.acm.vo.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * (Doctor)表服务实现类
 *
 * @author makejava
 * @since 2023-07-21 15:10:56
 */
@Service("doctorService")
public class DoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor> implements DoctorService {


    @Resource
    private DoctorMapper doctorMapper;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //    根据科室来查询医生
    @Override
    public ResponseResult getDoctorsByDepartment(String departmentname) {
        LambdaQueryWrapper<Doctor> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(Doctor::getDepartment,departmentname);
        List<Doctor> doctors = doctorMapper.selectList(queryWrapper);
        List<DoctorsByDepartmentVo> doctorsByDepartmentVos = new ArrayList<>();
        if(doctors!=null){
            doctorsByDepartmentVos= BeanCopyUtils.copyBeanList(doctors,DoctorsByDepartmentVo.class);
            return ResponseResult.okResult(doctorsByDepartmentVos);
        }else {
            return ResponseResult.errorResult(AppHttpCodeEnum.DOCTOR_DEPARTMENT_NOT_NULL);
        }
    }

//    医生修改自己的信息
    @Override
    public ResponseResult revise(Integer doctorId, String username,
                                 String gender, String phonenumber,
                                 String email, String password,
                                 String qualification, String department,
                                 String identityinfo, String realname) {

        // 使用 doctorId 查询医生记录
        Doctor doctor = doctorMapper.selectById(doctorId);
        if (doctor == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.DOCTOR_NOT_EXIST);
        }

        // 设置需要修改的属性值
        if (username != null) {
            doctor.setUsername(username);
        }
        if (gender != null) {
            doctor.setGender(gender);
        }
        if (phonenumber != null) {
            doctor.setPhonenumber(phonenumber);
        }
        if (email != null) {
            doctor.setEmail(email);
        }
        if (qualification != null) {
            doctor.setQualification(qualification);
        }
        if (department != null) {
            doctor.setDepartment(department);
        }
        if (identityinfo != null) {
            doctor.setIdentityinfo(identityinfo);
        }
        if (realname != null) {
            doctor.setRealname(realname);
        }

        // 更新医生记录
        int result = doctorMapper.updateById(doctor);
        if (result > 0) {
            return ResponseResult.okResult(AppHttpCodeEnum.REVISE_YES);
        } else {
            return ResponseResult.errorResult(AppHttpCodeEnum.REVISE_NOT);
        }
    }

    @Override
    public ResponseResult getDoctorId(Integer doctorId) {

        LambdaQueryWrapper<Doctor> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(Doctor::getId,doctorId);
        Doctor doctor=doctorMapper.selectOne(queryWrapper);
        if(doctor!=null){
            DoctorVo doctorVo=BeanCopyUtils.copyBean(doctor,DoctorVo.class);
            return ResponseResult.okResult(doctorVo);
        }else{
            return ResponseResult.errorResult(AppHttpCodeEnum.DOCTOR_NOT_EXIST);
        }
    }


    @Override
    public ResponseResult login(Doctor doctor) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(doctor.getUsername(), doctor.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        if (Objects.isNull(authentication)) {
            throw new RuntimeException("用户名或密码错误");
        }
        LoginDoc loginDoc = (LoginDoc) authentication.getPrincipal();
        String id = loginDoc.getDoctor().getId().toString();
        String jwt = JwtUtil.createJWT(id);
        redisCache.setCacheObject("doctorlogin:" + id, loginDoc);
        DoctorVo doctorVo = BeanCopyUtils.copyBean(loginDoc.getDoctor(), DoctorVo.class);
        DoctorLoginVo doctorInfoVo = new DoctorLoginVo(jwt,doctorVo);
        return ResponseResult.okResult(doctorInfoVo);
    }

    @Override
    public ResponseResult logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginDoc principal = (LoginDoc) authentication.getPrincipal();
        Long userId = Long.valueOf(principal.getDoctor().getId());
        redisCache.deleteObject("doctorlogin:" + userId);
        return ResponseResult.okResult();
    }


    @Override
    public ResponseResult register(Doctor doctor) {
        if(!StringUtils.hasText(doctor.getUsername())){
            throw new SystemException(AppHttpCodeEnum.USERNAME_NOT_NULL);
        }
        if(!StringUtils.hasText(doctor.getPassword())){
            throw new SystemException(AppHttpCodeEnum.PASSWORD_NOT_NULL);
        }
        if(!StringUtils.hasText(doctor.getEmail())){
            throw new SystemException(AppHttpCodeEnum.EMAIL_NOT_NULL);
        }
        if(!StringUtils.hasText(doctor.getRealname())){
            throw new SystemException(AppHttpCodeEnum.NICKNAME_NOT_NULL);
        }
        //对数据进行是否存在的判断
        if(userNameExist(doctor.getUsername())){
            throw new SystemException(AppHttpCodeEnum.USERNAME_EXIST);
        }
        if(nickNameExist(doctor.getRealname())){
            throw new SystemException(AppHttpCodeEnum.NICKNAME_EXIST);
        }
        //...
        //对密码进行加密
        String encodePassword = passwordEncoder.encode(doctor.getPassword());
        doctor.setPassword(encodePassword);
        //存入数据库
        save(doctor);
        return ResponseResult.okResult();
    }

    /**
     * 检测用户名是否存在
     * @param userName
     * @return
     */
    private boolean userNameExist(String userName) {
        LambdaQueryWrapper<Doctor> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Doctor::getUsername,userName);
        return count(queryWrapper) > 0;
    }

    /**
     * 是否输入真名
     * @param nickName
     * @return
     */
    private boolean nickNameExist(String nickName) {
        LambdaQueryWrapper<Doctor> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Doctor::getRealname,nickName);
        return count(queryWrapper) > 0;
    }


    /**
     * 修改医生密码
     * @param doctorId
     * @param currentPassword
     * @param newPassword
     * @return
     */
    @Override
    public ResponseResult changePassword(String doctorId, String currentPassword, String newPassword) {
        Doctor doctor = doctorMapper.selectById(doctorId);
        if (passwordEncoder.matches(currentPassword, doctor.getPassword())) {
            String newPwd = passwordEncoder.encode(newPassword);
            doctor.setPassword(newPwd);
            boolean updateById = updateById(doctor);
            if(updateById){
                return ResponseResult.okResult();
            }else{
                return ResponseResult.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
            }
        }else{
            return ResponseResult.errorResult(AppHttpCodeEnum.PASSWORD_ERROR);
        }
    }
}
