package com.acm.mapper;

import com.acm.entity.Prescription;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;


/**
 * (Prescription)表数据库访问层
 *
 * @author makejava
 * @since 2023-07-21 15:10:56
 */
@Repository
public interface PrescriptionMapper extends BaseMapper<Prescription> {

}

