package com.acm.service.impl;

import com.acm.entity.Patient;
import com.acm.enums.AppHttpCodeEnum;
import com.acm.exception.SystemException;
import com.acm.mapper.PatientMapper;
import com.acm.service.PatientService;
import com.acm.utils.HttpUtils;
import com.acm.vo.ResponseResult;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 检测用户名是否存在
     * @param userName
     * @return
     */
    private boolean userNameExist(String userName) {
        LambdaQueryWrapper<Patient> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Patient::getUsername,userName);
        return count(queryWrapper) > 0;
    }

    /**
     * 是否输入真名
     * @param nickName
     * @return
     */
    private boolean nickNameExist(String nickName) {
        LambdaQueryWrapper<Patient> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Patient::getRealname,nickName);
        return count(queryWrapper) > 0;
    }

    /**
     * 身份证验证api
     * @param idNo
     * @param name
     * @return
     * @throws IOException
     */
    @Override
    public ResponseResult infoApp(String idNo, String name) throws IOException {
        String host = "https://idenauthen.market.alicloudapi.com";
        String path = "/idenAuthentication";
        String method = "POST";
        String appcode = "8ad38273eb9843bcbb0d39ed612f201e";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        Map<String, String> bodys = new HashMap<String, String>();
        bodys.put("idNo", idNo);
        bodys.put("name", name);

        HttpResponse response = null;
        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseResult.okResult(EntityUtils.toString(response.getEntity()));

    }

    /**
     * 录入信息
     * @param realname
     * @param phonenumber
     * @param sex
     * @param email
     * @param identityinfo
     * @param age
     * @param address
     * @param id
     * @return
     */
    @Override
    public ResponseResult saveInfo(String realname, String phonenumber, String sex, String email, String identityinfo, Integer age, String address, String id) {
        Patient patient = new Patient();
        patient.setAddress(address);
        patient.setAge(age);
        patient.setEmail(email);
        patient.setIdentityinfo(identityinfo);
        patient.setRealname(realname);
        patient.setPhonenumber(phonenumber);
        patient.setSex(sex);
        patient.setId(id);
        boolean updateById = updateById(patient);
        if(updateById){
            return ResponseResult.okResult();
        }
        return ResponseResult.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
    }
}
