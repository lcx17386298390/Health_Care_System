package com.acm.service.impl;

import java.util.List;

import com.acm.entity.SysDepartment;
import com.acm.mapper.SysDepartmentMapper;
import com.acm.service.ISysDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 科室信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-28
 */
@Service
public class SysDepartmentServiceImpl implements ISysDepartmentService
{
    @Autowired
    private SysDepartmentMapper sysDepartmentMapper;

    /**
     * 查询科室信息
     * 
     * @param id 科室信息主键
     * @return 科室信息
     */
    @Override
    public SysDepartment selectSysDepartmentById(String id)
    {
        return sysDepartmentMapper.selectSysDepartmentById(id);
    }

    /**
     * 查询科室信息列表
     * 
     * @param sysDepartment 科室信息
     * @return 科室信息
     */
    @Override
    public List<SysDepartment> selectSysDepartmentList(SysDepartment sysDepartment)
    {
        return sysDepartmentMapper.selectSysDepartmentList(sysDepartment);
    }

    /**
     * 新增科室信息
     * 
     * @param sysDepartment 科室信息
     * @return 结果
     */
    @Override
    public int insertSysDepartment(SysDepartment sysDepartment)
    {
        return sysDepartmentMapper.insertSysDepartment(sysDepartment);
    }

    /**
     * 修改科室信息
     * 
     * @param sysDepartment 科室信息
     * @return 结果
     */
    @Override
    public int updateSysDepartment(SysDepartment sysDepartment)
    {
        return sysDepartmentMapper.updateSysDepartment(sysDepartment);
    }

    /**
     * 批量删除科室信息
     * 
     * @param ids 需要删除的科室信息主键
     * @return 结果
     */
    @Override
    public int deleteSysDepartmentByIds(String[] ids)
    {
        return sysDepartmentMapper.deleteSysDepartmentByIds(ids);
    }

    /**
     * 删除科室信息信息
     * 
     * @param id 科室信息主键
     * @return 结果
     */
    @Override
    public int deleteSysDepartmentById(String id)
    {
        return sysDepartmentMapper.deleteSysDepartmentById(id);
    }
}
