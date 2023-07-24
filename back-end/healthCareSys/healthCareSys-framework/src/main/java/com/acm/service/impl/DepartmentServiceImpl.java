package com.acm.service.impl;

import com.acm.entity.Department;
import com.acm.mapper.DepartmentMapper;
import com.acm.service.DepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * (Department)表服务实现类
 *
 * @author makejava
 * @since 2023-07-21 15:10:55
 */
@Service("departmentService")
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

}
