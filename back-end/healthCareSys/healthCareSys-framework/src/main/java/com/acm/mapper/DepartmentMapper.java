package com.acm.mapper;

import com.acm.entity.Department;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;


/**
 * (Department)表数据库访问层
 *
 * @author makejava
 * @since 2023-07-21 15:10:51
 */
@Repository
public interface DepartmentMapper extends BaseMapper<Department> {

}

