package com.acm.mapper;

import com.acm.entity.Doctor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;


/**
 * (Doctor)表数据库访问层
 *
 * @author makejava
 * @since 2023-07-21 15:10:56
 */
@Repository
public interface DoctorMapper extends BaseMapper<Doctor> {

}

