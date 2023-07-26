package com.acm.mapper;

import com.acm.entity.Patient;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.catalina.User;
import org.springframework.stereotype.Repository;


/**
 * (Patient)表数据库访问层
 *
 * @author makejava
 * @since 2023-07-21 15:10:56
 */

@Repository
public interface PatientMapper extends BaseMapper<Patient> {

    // 更新用户数据
    Patient findByRealname(String realname);

}

