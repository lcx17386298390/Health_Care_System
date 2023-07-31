package com.acm.mapper;

import com.acm.entity.SysDepartment;

import java.util.List;

/**
 * 科室信息Mapper接口
 * 
 * @author ruoyi
 * @date 2023-07-28
 */
public interface SysDepartmentMapper 
{
    /**
     * 查询科室信息
     * 
     * @param id 科室信息主键
     * @return 科室信息
     */
    public SysDepartment selectSysDepartmentById(String id);

    /**
     * 查询科室信息列表
     * 
     * @param sysDepartment 科室信息
     * @return 科室信息集合
     */
    public List<SysDepartment> selectSysDepartmentList(SysDepartment sysDepartment);

    /**
     * 新增科室信息
     * 
     * @param sysDepartment 科室信息
     * @return 结果
     */
    public int insertSysDepartment(SysDepartment sysDepartment);

    /**
     * 修改科室信息
     * 
     * @param sysDepartment 科室信息
     * @return 结果
     */
    public int updateSysDepartment(SysDepartment sysDepartment);

    /**
     * 删除科室信息
     * 
     * @param id 科室信息主键
     * @return 结果
     */
    public int deleteSysDepartmentById(String id);

    /**
     * 批量删除科室信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysDepartmentByIds(String[] ids);
}
