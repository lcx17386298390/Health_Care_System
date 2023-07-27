package com.acm.mapper;

import com.acm.entity.Appointment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;


/**
 * (Appointment)表数据库访问层
 *
 * @author makejava
 * @since 2023-07-21 15:11:24
 */
@Repository
public interface AppointmentMapper extends BaseMapper<Appointment> {

}

