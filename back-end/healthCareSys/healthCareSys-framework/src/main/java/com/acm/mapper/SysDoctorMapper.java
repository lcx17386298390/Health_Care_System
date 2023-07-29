package com.acm.mapper;

import com.acm.entity.SysDoctor;

import java.util.List;

/**
 * 医生信息Mapper接口
 * 
 * @author ruoyi
 * @date 2023-07-28
 */
public interface SysDoctorMapper 
{
    /**
     * 查询医生信息
     * 
     * @param id 医生信息主键
     * @return 医生信息
     */
    public SysDoctor selectSysDoctorById(String id);

    /**
     * 查询医生信息列表
     * 
     * @param sysDoctor 医生信息
     * @return 医生信息集合
     */
    public List<SysDoctor> selectSysDoctorList(SysDoctor sysDoctor);

    /**
     * 新增医生信息
     * 
     * @param sysDoctor 医生信息
     * @return 结果
     */
    public int insertSysDoctor(SysDoctor sysDoctor);

    /**
     * 修改医生信息
     * 
     * @param sysDoctor 医生信息
     * @return 结果
     */
    public int updateSysDoctor(SysDoctor sysDoctor);

    /**
     * 删除医生信息
     * 
     * @param id 医生信息主键
     * @return 结果
     */
    public int deleteSysDoctorById(String id);

    /**
     * 批量删除医生信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysDoctorByIds(String[] ids);
}
